package wakanda.forever.WakandaSystemServer.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import wakanda.forever.WakandaSystemServer.model.farmobject.FarmObject;

public interface FarmRepository extends CrudRepository<FarmObject, UUID>{

	
}
