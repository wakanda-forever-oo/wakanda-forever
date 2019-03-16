package wakandaforever.wakandaforever.diconfig;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import wakandaforever.wakandaforever.views.farmobjectdetails.FarmObjectDetailsContracts;
import wakandaforever.wakandaforever.views.farmobjectdetails.FarmObjectDetailsFragment;
import wakandaforever.wakandaforever.views.farmobjectdetails.FarmObjectDetailsPresenter;


@Module
public abstract class FarmObjectDetailsModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract FarmObjectDetailsFragment farmObjectDetailsFragment();

    @ActivityScoped
    @Binds
    abstract FarmObjectDetailsContracts.Presenter farmObjectListPresenter(FarmObjectDetailsPresenter presenter);
}

