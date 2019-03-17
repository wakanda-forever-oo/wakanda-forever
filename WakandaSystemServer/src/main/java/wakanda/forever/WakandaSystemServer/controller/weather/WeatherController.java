package wakanda.forever.WakandaSystemServer.controller.weather;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import wakanda.forever.WakandaSystemServer.dto.weather.DayPredictionDto;
import wakanda.forever.WakandaSystemServer.dto.weather.PredictionDto;
import wakanda.forever.WakandaSystemServer.model.weather.DayPrediction;
import wakanda.forever.WakandaSystemServer.model.weather.Prediction;
import wakanda.forever.WakandaSystemServer.repository.weather.DayPredictionRepository;
import wakanda.forever.WakandaSystemServer.repository.weather.PredictionRepository;

@RestController("/weather")
public class WeatherController {
	
	@Autowired
	private DayPredictionRepository dayPredictionRepository;
	
	@Autowired
	private PredictionRepository predictionRepository;
	
	private List<DayPrediction> populateDayPredictions(PredictionDto predictionDto, Timestamp currentTime) {
		
		List<DayPrediction> resultList = new ArrayList<DayPrediction>();		
		
		predictionDto.getResult().forEach(prd -> {
			DayPrediction dayPrd = new DayPrediction(prd);
			dayPrd.setCreatedAt(currentTime);
			dayPrd.setModifiedAt(currentTime);
			resultList.add(dayPredictionRepository.save(dayPrd));
		});
		
		return resultList;
	}
	
	@PostMapping("/day/save")
	public DayPrediction saveDayPredictionEntity(@RequestBody DayPredictionDto dto) {
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		DayPrediction entity = new DayPrediction(dto);
		entity.setCreatedAt(currentTime);
		entity.setModifiedAt(currentTime);
		
		return dayPredictionRepository.save(entity);
	}
	
	@PostMapping("prediction/save")
	public Prediction savePrediction(@RequestBody PredictionDto dto) {
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		List<DayPrediction> dayPredictions = populateDayPredictions(dto, currentTime);
		Prediction entity = new Prediction(dto);
		entity.setDayPredictions(dayPredictions);
		entity.setCreatedAt(currentTime);
		entity.setModifiedAt(currentTime);
		
		return predictionRepository.save(entity);
		
	}
	
//	public List<DayPredictionDto> getAllDayPredictions() {
//		return dayPredictionRepository.findAll();
//	}

}
