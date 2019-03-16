package wakandaforever.wakandaforever;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import wakandaforever.wakandaforever.diconfig.DaggerAppComponent;

public class AndroidApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}

