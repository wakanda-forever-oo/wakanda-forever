package wakandaforever.wakandaforever.diconfig;

import dagger.Module;
import dagger.Provides;

@Module
public class ParsersModule {
    @Provides
    public JsonParser<Superhero> superheroJsonParser() {
        return new GsonJsonParser<>(Superhero.class, Superhero[].class);
    }
}

