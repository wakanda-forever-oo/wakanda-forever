package wakandaforever.wakandaforever.views.TemperatureGraph;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import wakandaforever.wakandaforever.async.base.SchedulerProvider;
import wakandaforever.wakandaforever.http.OkHttpHttpRequester;
import wakandaforever.wakandaforever.models.FarmObject;
import wakandaforever.wakandaforever.services.base.FarmObjectsService;
import wakandaforever.wakandaforever.views.farmobjectlist.FarmObjectListContracts;

public class TemperatureGraphPresenter
        implements TemperatureGraphContracts.Presenter {

    private TemperatureGraphContracts.View mView;

    @Inject
    public TemperatureGraphPresenter() {
    }

    @Override
    public void subscribe(TemperatureGraphContracts.View view) {
        mView = view;
    }
}
