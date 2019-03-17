package wakandaforever.wakandaforever.diconfig;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import wakandaforever.wakandaforever.views.TemperatureGraph.TemperatureGraphContracts;
import wakandaforever.wakandaforever.views.TemperatureGraph.TemperatureGraphFragment;
import wakandaforever.wakandaforever.views.TemperatureGraph.TemperatureGraphPresenter;

@Module
public abstract class TemperatureGraphModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract TemperatureGraphFragment temperatureGraphFragment();

    @ActivityScoped
    @Binds
    abstract TemperatureGraphContracts.Presenter temperatureGraphPresenter(TemperatureGraphPresenter presenter);
}
