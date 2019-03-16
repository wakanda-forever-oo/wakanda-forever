package wakandaforever.wakandaforever.diconfig;

import java.io.IOException;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import wakandaforever.wakandaforever.models.FarmObject;
import wakandaforever.wakandaforever.repositories.base.Repository;

@Module
public class RepositoriesModule {
    @Provides
    @Singleton
    public Repository<FarmObject> superheroRepository() {
//        Repository<FarmObject> repository = new InMemoryRepository<>();
//        List<Superhero> initialSuperheroes = Arrays.asList(
//                new Superhero("Batman", "Bruce Wayne", "https://upload.wikimedia.org/wikipedia/en/8/87/Batman_DC_Comics.png"),
//                new Superhero("Wonder woman", "Diana Prince", "https://upload.wikimedia.org/wikipedia/en/thumb/9/93/Wonder_Woman.jpg/250px-Wonder_Woman.jpg"),
//                new Superhero("The Flash", "Barry Alan", "https://upload.wikimedia.org/wikipedia/en/thumb/2/29/Barry_Allen_Flash_Vol_4_30.png/250px-Barry_Allen_Flash_Vol_4_30.png"),
//                new Superhero("Batman", "Bruce Wayne", "https://upload.wikimedia.org/wikipedia/en/8/87/Batman_DC_Comics.png"),
//                new Superhero("Wonder woman", "Diana Prince", "https://upload.wikimedia.org/wikipedia/en/thumb/9/93/Wonder_Woman.jpg/250px-Wonder_Woman.jpg"),
//                new Superhero("The Flash", "Barry Alan", "https://upload.wikimedia.org/wikipedia/en/thumb/2/29/Barry_Allen_Flash_Vol_4_30.png/250px-Barry_Allen_Flash_Vol_4_30.png"),
//                new Superhero("Batman", "Bruce Wayne", "https://upload.wikimedia.org/wikipedia/en/8/87/Batman_DC_Comics.png"),
//                new Superhero("Wonder woman", "Diana Prince", "https://upload.wikimedia.org/wikipedia/en/thumb/9/93/Wonder_Woman.jpg/250px-Wonder_Woman.jpg"),
//                new Superhero("The Flash", "Barry Alan", "https://upload.wikimedia.org/wikipedia/en/thumb/2/29/Barry_Allen_Flash_Vol_4_30.png/250px-Barry_Allen_Flash_Vol_4_30.png"),
//                new Superhero("Batman", "Bruce Wayne", "https://upload.wikimedia.org/wikipedia/en/8/87/Batman_DC_Comics.png"),
//                new Superhero("Wonder woman", "Diana Prince", "https://upload.wikimedia.org/wikipedia/en/thumb/9/93/Wonder_Woman.jpg/250px-Wonder_Woman.jpg"),
//                new Superhero("The Flash", "Barry Alan", "https://upload.wikimedia.org/wikipedia/en/thumb/2/29/Barry_Allen_Flash_Vol_4_30.png/250px-Barry_Allen_Flash_Vol_4_30.png")
//        );

//        initialSuperheroes.forEach(s -> {
//            try {
//                repository.add(s);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });

        return new Repository<FarmObject>() {
            @Override
            public List<FarmObject> getAll() throws IOException {
                return null;
            }

            @Override
            public FarmObject add(FarmObject item) throws IOException {
                return null;
            }

            @Override
            public FarmObject getById(int id) throws IOException {
                return null;
            }
        };
    }
}

