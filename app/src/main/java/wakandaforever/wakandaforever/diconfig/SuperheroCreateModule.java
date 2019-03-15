package wakandaforever.wakandaforever.diconfig;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SuperheroCreateModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract SuperheroCreateFragment superheroCreateFragment();

    @ActivityScoped
    @Binds
    abstract SuperheroCreateContracts.Presenter superheroCreatePresenter(SuperheroCreatePresenter presenter);
}


