package wakandaforever.wakandaforever.diconfig;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SuperheroesListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract SuperheroesListFragment superheroesListFragment();

    @ActivityScoped
    @Binds
    abstract SuperheroesListContracts.Presenter superheroesListPresenter(SuperheroesListPresenter presenter);
}

