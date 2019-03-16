package wakandaforever.wakandaforever.views.farmobjectlist;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import wakandaforever.wakandaforever.async.base.SchedulerProvider;
import wakandaforever.wakandaforever.models.FarmObject;
import wakandaforever.wakandaforever.services.base.FarmObjectsService;

public class FarmObjectListPresenter
        implements FarmObjectListContracts.Presenter {

    private final FarmObjectsService mFarmObjectService;
    private final SchedulerProvider mSchedulerProvider;
    private FarmObjectListContracts.View mView;

    @Inject
    public FarmObjectListPresenter(
            FarmObjectsService farmObjectService,
            SchedulerProvider schedulerProvider) {
        mFarmObjectService = farmObjectService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(FarmObjectListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadFarmObjects() {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<FarmObject>>) emitter -> {
                    List<FarmObject> farmObjects = mFarmObjectService.getAllFarmObjects();
                    emitter.onNext(farmObjects);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(
                        this::presentFarmObjectsToView,
                        error -> mView.showError(error)
                );
    }

    @Override
    public void filterFarmObjects(String pattern) {
//        mView.showLoading();
//        Disposable observable = Observable
//                .create((ObservableOnSubscribe<List<FarmObject>>) emitter -> {
//                    List<FarmObject> superheroes = mFarmObjectService.getFilteredFarmObjects(pattern);
//                    emitter.onNext(superheroes);
//                    emitter.onComplete();
//                })
//                .subscribeOn(mSchedulerProvider.background())
//                .observeOn(mSchedulerProvider.ui())
//                .doFinally(mView::hideLoading)
//                .subscribe(
//                        this::presentFarmObjectToView,
//                        error -> mView.showError(error)
//                );
    }

    @Override
    public void selectFarmObject(FarmObject farmObject) {
        mView.showFarmObjectDetails(farmObject);
    }

    private void presentFarmObjectsToView(List<FarmObject> farmObjects) {
        if (farmObjects.isEmpty()) {
            mView.showEmptyFarmObjectsList();
        } else {
            mView.showFarmObjects(farmObjects);
        }
    }
}

