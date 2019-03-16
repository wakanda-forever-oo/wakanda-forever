package wakandaforever.wakandaforever.diconfig;

import dagger.Module;
import dagger.Provides;
import wakandaforever.wakandaforever.models.FarmObject;
import wakandaforever.wakandaforever.repositories.base.Repository;
import wakandaforever.wakandaforever.services.HttpFarmObjectsService;
import wakandaforever.wakandaforever.services.base.FarmObjectsService;
import wakandaforever.wakandaforever.validators.base.Validator;

@Module
public class ServicesModule {
    @Provides
    public FarmObjectsService superheroesService(Repository<FarmObject> repository, Validator<FarmObject> validator) {
        return new HttpFarmObjectsService(repository, validator);
    }
}

