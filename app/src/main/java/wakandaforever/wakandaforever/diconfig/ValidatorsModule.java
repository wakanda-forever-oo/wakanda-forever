package wakandaforever.wakandaforever.diconfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ValidatorsModule {
    @Provides
    @Singleton
    public Validator<Superhero> superheroValidator() {
        return new SuperheroValidator();
    }
}

