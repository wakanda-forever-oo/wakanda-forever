package wakandaforever.wakandaforever.diconfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import wakandaforever.wakandaforever.async.AsyncSchedulerProvider;
import wakandaforever.wakandaforever.async.base.SchedulerProvider;

@Module
public class AsyncModule {
    @Provides
    @Singleton
    public SchedulerProvider schedulerProvider() {
        return AsyncSchedulerProvider.getInstance();
    }
}
