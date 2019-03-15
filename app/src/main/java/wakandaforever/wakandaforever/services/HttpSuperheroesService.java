package wakandaforever.wakandaforever.services;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class HttpSuperheroesService implements SuperheroesService {
    private final Repository<Superhero> mSuperheroesRepository;
    private final Validator<Superhero> mSuperheroValidator;

    public HttpSuperheroesService(
            Repository<Superhero> superheroesRepository,
            Validator<Superhero> superheroValidator) {
        mSuperheroesRepository = superheroesRepository;
        mSuperheroValidator = superheroValidator;
    }

    @Override
    public List<Superhero> getAllSuperheroes() throws Exception {
        return mSuperheroesRepository.getAll();
    }

    @Override
    public Superhero getDetailsById(int id) throws Exception {
        return mSuperheroesRepository.getById(id);
    }

    @Override
    public List<Superhero> getFilteredSuperheroes(String pattern) throws Exception {
        String patternToLower = pattern.toLowerCase();

        return getAllSuperheroes().stream()
                .filter(superhero -> superhero.getName().toLowerCase().contains(patternToLower))
                .collect(Collectors.toList());
    }

    @Override
    public Superhero createSuperhero(Superhero superhero) throws Exception {
        if (!mSuperheroValidator.isValid(superhero)) {
            throw new IllegalArgumentException("Superhero is invalid");
        }

        return mSuperheroesRepository.add(superhero);
    }
}

