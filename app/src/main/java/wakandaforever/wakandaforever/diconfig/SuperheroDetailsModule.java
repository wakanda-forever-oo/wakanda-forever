package wakandaforever.wakandaforever.diconfig;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class SuperheroDetailsModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract SuperheroDetailsFragment superheroDetailsFragment();

    @ActivityScoped
    @Binds
    abstract SuperheroDetailsContracts.Presenter superheroesListPresenter(SuperheroDetailsPresenter presenter);
}

