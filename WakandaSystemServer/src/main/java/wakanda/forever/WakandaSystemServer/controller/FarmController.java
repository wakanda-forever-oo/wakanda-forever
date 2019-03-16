package wakanda.forever.WakandaSystemServer.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wakanda.forever.WakandaSystemServer.dto.farmobject.FarmObjectDto;
import wakanda.forever.WakandaSystemServer.model.farmobject.FarmObject;
import wakanda.forever.WakandaSystemServer.repository.farm.FarmRepository;

@RestController
@RequestMapping("farm")
public class FarmController {
	  
	@Autowired
	private FarmRepository farmRepository;

	@PostMapping("/save")
	public FarmObject saveEntity(@RequestBody FarmObjectDto farmObjectDto) {
		
		FarmObject farmObject = new FarmObject(farmObjectDto);
		farmObject.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		farmObject.setModifiedAt(new Timestamp(System.currentTimeMillis()));
		return farmRepository.save(farmObject);	
	}
	
	@GetMapping("/all")
	public List<FarmObjectDto> getAll() {
		List<FarmObjectDto> dtos = new ArrayList<>();
		farmRepository.findAll().forEach(object -> {
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
	
}
