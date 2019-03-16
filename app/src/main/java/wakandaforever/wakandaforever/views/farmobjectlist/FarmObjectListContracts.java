package wakandaforever.wakandaforever.views.farmobjectlist;

import java.util.List;

import wakandaforever.wakandaforever.models.FarmObject;

public interface FarmObjectListContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showFarmObjects(List<FarmObject> farmObjects);

        void showEmptyFarmObjectsList();

        void showError(Throwable e);

        void showLoading();

        void hideLoading();

        void showFarmObjectDetails(FarmObject farmObject);
    }

    interface Presenter {
        void subscribe(View view);

        void loadFarmObjects();

        void filterFarmObjects(String pattern);

        void selectFarmObject(FarmObject farmObject);
    }

    interface Navigator {
        void navigateWith(FarmObject farmObject);
    }
}

