package wakandaforever.wakandaforever.views.TemperatureGraph;

import java.util.List;

import wakandaforever.wakandaforever.models.FarmObject;
import wakandaforever.wakandaforever.views.farmobjectdetails.FarmObjectDetailsContracts;
import wakandaforever.wakandaforever.views.farmobjectlist.FarmObjectListContracts;

public interface TemperatureGraphContracts {
    interface View {
        void setPresenter(TemperatureGraphContracts.Presenter presenter);
//
//        void showFarmObjects(List<FarmObject> farmObjects);
//
//        void showEmptyFarmObjectsList();
//
        void showError(Throwable e);

        void showLoading();

        void hideLoading();
//
//        void showFarmObjectDetails(FarmObject farmObject);
    }

    interface Presenter {
        void subscribe(TemperatureGraphContracts.View view);
//
//        void loadFarmObjects();
//
//        void filterFarmObjects(String pattern);
//
//        void selectFarmObject(FarmObject farmObject);
    }

    interface Navigator {
//        void navigateWith(FarmObject farmObject);
    }
}
