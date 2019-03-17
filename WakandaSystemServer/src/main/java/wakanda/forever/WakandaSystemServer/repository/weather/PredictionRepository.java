package wakanda.forever.WakandaSystemServer.repository.weather;

import org.springframework.data.repository.CrudRepository;

import wakanda.forever.WakandaSystemServer.model.weather.Prediction;

public interface PredictionRepository extends CrudRepository<Prediction, Long>{
	
}
