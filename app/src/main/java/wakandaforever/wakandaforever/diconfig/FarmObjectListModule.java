package wakandaforever.wakandaforever.diconfig;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import wakandaforever.wakandaforever.views.farmobjectlist.FarmObjectListContracts;
import wakandaforever.wakandaforever.views.farmobjectlist.FarmObjectListFragment;
import wakandaforever.wakandaforever.views.farmobjectlist.FarmObjectListPresenter;

@Module
public abstract class FarmObjectListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract FarmObjectListFragment farmObjectListFragment();

    @ActivityScoped
    @Binds
    abstract FarmObjectListContracts.Presenter farmObjectListPresenter(FarmObjectListPresenter presenter);
}

