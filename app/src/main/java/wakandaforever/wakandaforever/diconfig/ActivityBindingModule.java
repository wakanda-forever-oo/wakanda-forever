package wakandaforever.wakandaforever.diconfig;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import wakandaforever.wakandaforever.views.TemperatureGraph.TemperatureGraphActivity;
import wakandaforever.wakandaforever.views.farmobjectdetails.FarmObjectDetailsActivity;
import wakandaforever.wakandaforever.views.farmobjectlist.FarmObjectListActivity;
import wakandaforever.wakandaforever.views.weatherprediction.WeatherPredictionActivity;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(
            modules = FarmObjectListModule.class
    )
    abstract FarmObjectListActivity farmObjectListActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = FarmObjectDetailsModule.class
    )
    abstract FarmObjectDetailsActivity farmObjectDetailsActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = TemperatureGraphModule.class
    )
    abstract TemperatureGraphActivity temperatureGraphActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = WeatherPredictionModule.class
    )
    abstract WeatherPredictionActivity weatherPredictionActivity();
}

