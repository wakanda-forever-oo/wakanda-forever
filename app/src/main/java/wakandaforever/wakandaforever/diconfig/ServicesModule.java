package wakandaforever.wakandaforever.diconfig;

import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {
    @Provides
    public SuperheroesService superheroesService(Repository<Superhero> repository, Validator<Superhero> validator) {
        return new HttpSuperheroesService(repository, validator);
    }
}

