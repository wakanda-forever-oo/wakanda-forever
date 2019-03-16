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

import wakanda.forever.WakandaSystemServer.dto.illness.IllnessDto;
import wakanda.forever.WakandaSystemServer.model.illness.Illness;
import wakanda.forever.WakandaSystemServer.repository.illness.IllnessRepository;

@RestController
@RequestMapping("illness")
public class IllnessController {
	
	@Autowired
	private IllnessRepository illnessRepository;
	
	@PostMapping("/save")
	public Illness saveEntity(@RequestBody IllnessDto illnessDto) {
		
		Illness illnessEntity = new Illness(illnessDto);
		illnessEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		illnessEntity.setModifiedAt(new Timestamp(System.currentTimeMillis()));
		return illnessRepository.save(illnessEntity);
	}
	
	@GetMapping("/all")
	public List<IllnessDto> getAll() {
		List<IllnessDto> dtos = new ArrayList<>();
		illnessRepository.findAll().forEach(illness -> {
			dtos.add(new IllnessDto(illness));
		});
		
		return dtos;
	}
	
	@GetMapping("/all/{id}")
	public IllnessDto getById(@PathVariable @NotNull Long id) {
		Optional<Illness> illnessOptional = illnessRepository.findById(id);
		if(illnessOptional.isPresent()) {
			return new IllnessDto(illnessOptional.get());
		}
		return null;
	}

}
