package wakanda.forever.WakandaSystemServer.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wakanda.forever.WakandaSystemServer.dto.FarmObjectDto;
import wakanda.forever.WakandaSystemServer.model.farmobject.FarmObject;
import wakanda.forever.WakandaSystemServer.repository.FarmRepository;

@RestController
@RequestMapping("farm")
public class FarmController {
	  
	@Autowired
	private FarmRepository farmRepository;

	@PostMapping("/save")
	public FarmObject populateFarmObjectToDb(@RequestBody FarmObjectDto farmObjectDto) {
		
		FarmObject farmObject = new FarmObject(farmObjectDto);
		farmObject.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		farmObject.setModifiedAt(new Timestamp(System.currentTimeMillis()));
		return farmRepository.save(farmObject);			
	}
	
	@GetMapping("/all")
	public List<FarmObject> getAll() {
		return (List<FarmObject>) farmRepository.findAll();
	}
	
	@GetMapping("/test")
	public String testHello(@RequestParam(name = "name") String name) {		
		return "Hello " + name;
	}
	
}
