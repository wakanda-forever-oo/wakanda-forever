package wakandaforever.wakandaforever.views.farmobjectdetails;

import wakandaforever.wakandaforever.models.FarmObject;

public interface FarmObjectDetailsContracts {
    interface View {
        FarmObject showFarmObject(FarmObject farmObject);

        void setPresenter(Presenter presenter);

        void showError(Throwable e);

        void showLoading();

        void hideLoading();
    }

    interface Presenter {
        void subscribe(View view);

        void loadFarmObject();

        void setFarmObjectId(int id);
    }
}

