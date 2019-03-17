package wakanda.forever.WakandaSystemServer.controller.weather;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	private List<DayPredictionDto> getDayPredictionDtos(Prediction entity) {
		List<DayPredictionDto> resultList = new ArrayList<DayPredictionDto>();
		
		entity.getDayPredictions().forEach(dayEntity -> {
			resultList.add(new DayPredictionDto(dayEntity));
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
	
	@PostMapping("/prediction/save")
	public Prediction savePrediction(@RequestBody PredictionDto dto) {
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		List<DayPrediction> dayPredictions = populateDayPredictions(dto, currentTime);
		Prediction entity = new Prediction(dto);
		entity.setDayPredictions(dayPredictions);
		entity.setCreatedAt(currentTime);
		entity.setModifiedAt(currentTime);
		
		return predictionRepository.save(entity);
		
	}
	
	@GetMapping("/prediction/all")
	public List<PredictionDto> getAllPredictions() {
		List<PredictionDto> resultDtos = new ArrayList<PredictionDto>();
		
		predictionRepository.findAllSortedByDate(PageRequest.of(0, 300)).forEach(entity -> {
			PredictionDto dto = new PredictionDto(entity);
			dto.setResult(getDayPredictionDtos(entity));
			resultDtos.add(new PredictionDto());
		});
		
		return resultDtos;
	}
	
	@GetMapping("/prediction/{id}")
	public PredictionDto getPredictionById(@PathVariable @NotNull Long id) {
		Optional<Prediction> predictionOptional = predictionRepository.findById(id);
		if(predictionOptional.isPresent()) {
			Prediction entity = predictionOptional.get();
			PredictionDto resultDto = new PredictionDto(entity);
			resultDto.setResult(getDayPredictionDtos(entity));
			return resultDto;
		}
		return null;
	}
	
	@GetMapping("/prediction/{id}/days")
	public List<DayPredictionDto> getAllDayPredictionsForPrediction(@PathVariable @NotNull Long id) {
		List<DayPredictionDto> resultDtos = new ArrayList<DayPredictionDto>();
		Optional<Prediction> entityOptional = predictionRepository.findById(id);
		if(entityOptional.isPresent()) {
			Prediction entity = entityOptional.get();
			entity.getDayPredictions().forEach(dayPrediction -> {
				resultDtos.add(new DayPredictionDto(dayPrediction));
			});
		}
		return resultDtos;
	}
	
	@GetMapping("/prediction/today")
	public List<DayPredictionDto> getCurrentDayPrediction() {
		Prediction entity = predictionRepository.findAllSortedByDate(PageRequest.of(0, 300)).get(0);
		List<DayPredictionDto> resultDtos = new ArrayList<>();
		entity.getDayPredictions().forEach(dayEntity -> {
			resultDtos.add(new DayPredictionDto(dayEntity));
		});
		
		return resultDtos;
	}

}
