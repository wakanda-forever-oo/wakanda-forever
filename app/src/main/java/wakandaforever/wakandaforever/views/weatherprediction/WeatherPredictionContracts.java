package wakandaforever.wakandaforever.views.weatherprediction;

import java.util.List;

import wakandaforever.wakandaforever.models.FarmObject;
import wakandaforever.wakandaforever.models.Prediction;
import wakandaforever.wakandaforever.views.farmobjectlist.FarmObjectListContracts;

public interface WeatherPredictionContracts {
    interface View {
        void setPresenter(WeatherPredictionContracts.Presenter presenter);

        void showFarmObjects(List<Prediction> predictions);

        void showEmptyFarmObjectsList();

        void showError(Throwable e);

        void showLoading();

        void hideLoading();
    }

    interface Presenter {
        void subscribe(WeatherPredictionContracts.View view);

        void loadFarmObjects();

        void filterFarmObjects(String pattern);

        void selectFarmObject(Prediction prediction);
    }

    interface Navigator {
    }
}
