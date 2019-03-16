package wakandaforever.wakandaforever.diconfig;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import wakandaforever.wakandaforever.views.farmobjectlist.FarmObjectListActivity;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(
            modules = FarmObjectListModule.class
    )
    abstract FarmObjectListActivity farmObjectListActivity();

//    @ActivityScoped
//    @ContributesAndroidInjector(
//            modules = FarmObjectDetailsModule.class
//    )
//    abstract FarmObjectDetailsActivity farmObjectDetailsActivity();
}

