package wakanda.forever.WakandaSystemServer.repository.illness;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import wakanda.forever.WakandaSystemServer.model.illness.Illness;

public interface IllnessRepository extends CrudRepository<Illness, Long>{
	
	@Query(
			value = "SELECT * FROM illness ORDER BY created_at ASC", nativeQuery = true
		)
	public abstract List<Illness> findAllSortedByDate();
}
