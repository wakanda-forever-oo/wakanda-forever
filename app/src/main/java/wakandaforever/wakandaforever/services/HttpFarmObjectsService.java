package wakandaforever.wakandaforever.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import wakandaforever.wakandaforever.models.FarmObject;
import wakandaforever.wakandaforever.repositories.base.Repository;
import wakandaforever.wakandaforever.services.base.FarmObjectsService;
import wakandaforever.wakandaforever.validators.base.Validator;

public class HttpFarmObjectsService implements FarmObjectsService {
    private final Repository<FarmObject> mFarmObjectsRepository;
    private final Validator<FarmObject> mFarmObjectValidator;

    public HttpFarmObjectsService(
            Repository<FarmObject> superheroesRepository,
            Validator<FarmObject> superheroValidator) {
        mFarmObjectsRepository = superheroesRepository;
        mFarmObjectValidator = superheroValidator;
    }

    @Override
    public List<FarmObject> getAllFarmObjects() throws Exception {
        return mFarmObjectsRepository.getAll();
    }

    @Override
    public FarmObject getDetailsById(int id) throws Exception {
        return mFarmObjectsRepository.getById(id);
    }

    @Override
    public List<FarmObject> getFilteredFarmObjects(String pattern) {
//        String patternToLower = pattern.toLowerCase();
//
//        return getAllSuperheroes().stream()
//                .filter(superhero -> superhero.getName().toLowerCase().contains(patternToLower))
//                .collect(Collectors.toList());

        return new ArrayList<FarmObject>();
    }

    @Override
    public FarmObject createFarmObject(FarmObject farmObject) {
//        if (!mSuperheroValidator.isValid(superhero)) {
//            throw new IllegalArgumentException("Superhero is invalid");
//        }
//
//        return mSuperheroesRepository.add(superhero);
        return new FarmObject();
    }
}

