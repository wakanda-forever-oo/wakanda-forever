package wakandaforever.wakandaforever.views.weatherprediction;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import wakandaforever.wakandaforever.async.base.SchedulerProvider;
import wakandaforever.wakandaforever.http.OkHttpHttpRequester;
import wakandaforever.wakandaforever.models.FarmObject;
import wakandaforever.wakandaforever.models.Prediction;
import wakandaforever.wakandaforever.services.base.FarmObjectsService;
import wakandaforever.wakandaforever.views.farmobjectlist.FarmObjectListContracts;

public class WeatherPredictionPresenter
        implements WeatherPredictionContracts.Presenter {

    private WeatherPredictionContracts.View mView;

    private final FarmObjectsService mFarmObjectService;
    private final SchedulerProvider mSchedulerProvider;

    @Inject
    public WeatherPredictionPresenter(
            FarmObjectsService farmObjectService,
            SchedulerProvider schedulerProvider) {
        mFarmObjectService = farmObjectService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(WeatherPredictionContracts.View view) {
        mView = view;
    }

    @Override
    public void loadFarmObjects() {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Prediction>>) emitter -> {
                    List<Prediction> predictions = new OkHttpHttpRequester().getAllPredictions();
                    emitter.onNext(predictions);
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
//                    List<FarmObject> farmObjects = mFarmObjectService.getFilteredFarmObjects(pattern);
//                    emitter.onNext(farmObjects);
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
    public void selectFarmObject(Prediction prediction) {

    }


    private void presentFarmObjectsToView(List<Prediction> predictions) {
        if (predictions.isEmpty()) {
            mView.showEmptyFarmObjectsList();
        } else {
            mView.showFarmObjects(predictions);
        }
    }
}
