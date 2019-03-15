package wakandaforever.wakandaforever.diconfig;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(
            modules = SuperheroesListModule.class
    )
    abstract SuperheroesListActivity superheroesListActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = SuperheroDetailsModule.class
    )
    abstract SuperheroDetailsActivity superheroDetailsActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = SuperheroCreateModule.class
    )
    abstract SuperheroCreateActivity superheroCreateActivity();
}

