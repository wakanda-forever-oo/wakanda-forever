package wakandaforever.wakandaforever.services.base;

import java.io.IOException;
import java.util.List;

import wakandaforever.wakandaforever.models.FarmObject;

public interface FarmObjectsService {
    List<FarmObject> getAllFarmObjects() throws Exception;

    FarmObject getDetailsById(int id) throws Exception;

    List<FarmObject> getFilteredFarmObjects(String pattern) throws Exception;

    FarmObject createFarmObject(FarmObject farmObject) throws Exception;
}

