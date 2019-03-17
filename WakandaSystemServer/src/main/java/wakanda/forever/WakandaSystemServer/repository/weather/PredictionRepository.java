package wakanda.forever.WakandaSystemServer.repository.weather;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import wakanda.forever.WakandaSystemServer.model.weather.Prediction;

public interface PredictionRepository extends CrudRepository<Prediction, Long>{
	
	@Query(
			value = "SELECT * FROM prediction ORDER BY created_at DESC", nativeQuery = true
		)
		public abstract List<Prediction> findAllSortedByDate(Pageable page);
}
