package wakandaforever.wakandaforever.diconfig;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import wakandaforever.wakandaforever.AndroidApplication;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBindingModule.class,
        AppModule.class,
        ParsersModule.class,
        HttpModule.class,
//        RepositoriesModule.class,
        ServicesModule.class,
        ValidatorsModule.class,
        AsyncModule.class,
        ViewsModule.class
})
public interface AppComponent extends AndroidInjector<AndroidApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}

