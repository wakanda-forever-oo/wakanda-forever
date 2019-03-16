package wakanda.forever.WakandaSystemServer.repository.farm;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import wakanda.forever.WakandaSystemServer.model.farmobject.FarmObject;

public interface FarmRepository extends CrudRepository<FarmObject, Long>{

	@Query(
		value = "SELECT * FROM farm_object ORDER BY created_at DESC", nativeQuery = true
	)
	public abstract List<FarmObject> findAllSortedByDate();
}
