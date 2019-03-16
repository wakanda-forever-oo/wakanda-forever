package wakanda.forever.WakandaSystemServer.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wakanda.forever.WakandaSystemServer.dto.farmobject.FarmObjectDto;
import wakanda.forever.WakandaSystemServer.dto.illness.IllnessDto;
import wakanda.forever.WakandaSystemServer.model.farmobject.FarmObject;
import wakanda.forever.WakandaSystemServer.model.illness.Illness;
import wakanda.forever.WakandaSystemServer.repository.farm.FarmRepository;
import wakanda.forever.WakandaSystemServer.repository.illness.IllnessRepository;

@RestController
@RequestMapping("farm")
public class FarmController {
	  
	@Autowired
	private FarmRepository farmRepository;
	
	@Autowired
	private IllnessRepository illnessRepository;
	
	private Float getFreezingProbability(Float temperature) {
		if(temperature < 0.0f) {
			return new Random().nextFloat() * 15 + 70;
		} else {
			return new Random().nextFloat() * 30 + 30;
		}
	}
	
	private Float getFungiProbability(Float humidity) {
		if(humidity > 50.0f) {
			return new Random().nextFloat() * 15 + 75;
		} else {
			return new Random().nextFloat() * 30 + 30;
		}
	}
	
	private Float getSummerSchorchProbability(Float temperature, Float humidity) {
		if(temperature > 31.2f && humidity < 13.0f) {
			return new Random().nextFloat() * 15 + 80;
		} else {
			return new Random().nextFloat() * 30 + 30;
		}
	}
	
	private Float getIronChorasisProbability(Float soilMoisture) {
		if(soilMoisture > 84.0f) {
			return new Random().nextFloat() * 8 + 90;
		} else {
			return new Random().nextFloat() * 30 + 30;
		}
	}
	
	private Illness createIllness(Timestamp time, String name, Float probability) {
		Illness illness = new Illness();
		illness.setCreatedAt(time);
		illness.setModifiedAt(time);
		illness.setName(name);
		illness.setProbability(probability);
		
		return illness;
	}
	
	private List<Illness> populateIllnesses(FarmObject farmObject) {
		List<Illness> illnesses = new ArrayList<Illness>();
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		Illness fungi = createIllness(currentTime, "Fungi", getFungiProbability(farmObject.getHumidity()));		
		Illness freezing = createIllness(currentTime, "Freezing", getFreezingProbability(farmObject.getTemperature()));		
		Illness summerSchorch = createIllness(currentTime, "Summer scorch", getSummerSchorchProbability(farmObject.getTemperature(), farmObject.getHumidity()));		
		Illness ironChorasis = createIllness(currentTime, "Iron chorasis", getIronChorasisProbability(farmObject.getSoilMoisture()));
		
		illnesses.add(illnessRepository.save(fungi));		
		illnesses.add(illnessRepository.save(freezing));
		illnesses.add(illnessRepository.save(summerSchorch));
		illnesses.add(illnessRepository.save(ironChorasis));
		
		return illnesses;
	}

	@PostMapping("/save")
	public FarmObject saveEntity(@RequestBody FarmObjectDto farmObjectDto) {
		
		FarmObject farmObject = new FarmObject(farmObjectDto);
		farmObject.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		farmObject.setModifiedAt(new Timestamp(System.currentTimeMillis()));
		
		List<Illness> illnesses = populateIllnesses(farmObject);
		farmObject.setIllnesses(illnesses);
		
		return farmRepository.save(farmObject);	
	}
	
	@GetMapping("/all")
	public List<FarmObjectDto> getAll() {
		List<FarmObjectDto> dtos = new ArrayList<>();
		farmRepository.findAllSortedByDate(PageRequest.of(0, 300)).forEach(object -> {
			dtos.add(new FarmObjectDto(object));
		});
		
		return dtos;
	}
	
	@GetMapping("/all/{id}")
	public FarmObjectDto getById(@PathVariable @NotNull Long id) {
		Optional<FarmObject> farmObjectOptional = farmRepository.findById(id);
		if(farmObjectOptional.isPresent()) {
			return new FarmObjectDto(farmObjectOptional.get());
		}
		return null;
	}
	
	@GetMapping("/all/{id}/illnesses")
	public List<IllnessDto> getIllnessesForFarm(@PathVariable @NotNull Long id) {
		List<IllnessDto> illnesses = new ArrayList<>();
		Optional<FarmObject> farmObjectOptional = farmRepository.findById(id);
		if(farmObjectOptional.isPresent()) {
			farmObjectOptional.get().getIllnesses().forEach(illness -> {
				illnesses.add(new IllnessDto(illness));
			});
		}
		return illnesses;
	}
}
