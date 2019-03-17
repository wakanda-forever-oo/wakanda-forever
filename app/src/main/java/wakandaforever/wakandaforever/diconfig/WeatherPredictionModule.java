package wakandaforever.wakandaforever.diconfig;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import wakandaforever.wakandaforever.views.TemperatureGraph.TemperatureGraphContracts;
import wakandaforever.wakandaforever.views.TemperatureGraph.TemperatureGraphFragment;
import wakandaforever.wakandaforever.views.TemperatureGraph.TemperatureGraphPresenter;
import wakandaforever.wakandaforever.views.weatherprediction.WeatherPredictionContracts;
import wakandaforever.wakandaforever.views.weatherprediction.WeatherPredictionFragment;
import wakandaforever.wakandaforever.views.weatherprediction.WeatherPredictionPresenter;

@Module
public abstract class WeatherPredictionModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract WeatherPredictionFragment temperatureGraphFragment();

    @ActivityScoped
    @Binds
    abstract WeatherPredictionContracts.Presenter temperatureGraphPresenter(WeatherPredictionPresenter presenter);
}
