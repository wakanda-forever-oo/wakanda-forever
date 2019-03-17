package wakanda.forever.WakandaSystemServer.repository.weather;

import org.springframework.data.repository.CrudRepository;

import wakanda.forever.WakandaSystemServer.model.weather.DayPrediction;

public interface DayPredictionRepository extends CrudRepository<DayPrediction, Long>{
	
}
