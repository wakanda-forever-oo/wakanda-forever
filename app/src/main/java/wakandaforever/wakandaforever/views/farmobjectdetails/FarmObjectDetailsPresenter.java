package wakandaforever.wakandaforever.views.farmobjectdetails;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import wakandaforever.wakandaforever.async.base.SchedulerProvider;
import wakandaforever.wakandaforever.http.OkHttpHttpRequester;
import wakandaforever.wakandaforever.models.FarmObject;
import wakandaforever.wakandaforever.services.base.FarmObjectsService;

public class FarmObjectDetailsPresenter
        implements FarmObjectDetailsContracts.Presenter {
    private final FarmObjectsService mSuperheroesService;
    private final SchedulerProvider mSchedulerProvider;

    private FarmObjectDetailsContracts.View mView;
    private int mFarmObjectId;

    @Inject
    public FarmObjectDetailsPresenter(
            FarmObjectsService superheroesService,
            SchedulerProvider schedulerProvider
    ) {
        mSuperheroesService = superheroesService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(FarmObjectDetailsContracts.View view) {
        mView = view;
    }

    @Override
    public void loadFarmObject() {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<FarmObject>) emitter -> {
                    FarmObject farmObject = mView.showFarmObject(new FarmObject());//mSuperheroesService.getDetailsById(mFarmObjectId);
                    emitter.onNext(farmObject);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(mView::showError)
                .subscribe(mView::showFarmObject);
    }

    @Override
    public void setFarmObjectId(int farmObjectId) {
        mFarmObjectId = farmObjectId;
    }
}

