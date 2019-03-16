package wakandaforever.wakandaforever.diconfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import wakandaforever.wakandaforever.models.FarmObject;
import wakandaforever.wakandaforever.validators.FarmObjectValidator;
import wakandaforever.wakandaforever.validators.base.Validator;

@Module
public class ValidatorsModule {
    @Provides
    @Singleton
    public Validator<FarmObject> superheroValidator() {
        return new FarmObjectValidator();
    }
}

