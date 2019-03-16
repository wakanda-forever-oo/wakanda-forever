package wakanda.forever.WakandaSystemServer.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public Illness saveEntity(@RequestBody IllnessDto illnessDto) {
		
		Illness illnessEntity = new Illness(illnessDto);
		illnessEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		illnessEntity.setModifiedAt(new Timestamp(System.currentTimeMillis()));
		return illnessRepository.save(illnessEntity);
	}

}
