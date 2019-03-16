package wakandaforever.wakandaforever.diconfig;

import dagger.Module;
import dagger.Provides;
import wakandaforever.wakandaforever.models.FarmObject;
import wakandaforever.wakandaforever.parsers.GsonJsonParser;
import wakandaforever.wakandaforever.parsers.base.JsonParser;

@Module
public class ParsersModule {
    @Provides
    public JsonParser<FarmObject> farmObjectJsonParser() {
        return new GsonJsonParser<>(FarmObject.class, FarmObject[].class);
    }
}

