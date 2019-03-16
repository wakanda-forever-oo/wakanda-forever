package wakanda.forever.WakandaSystemServer.dto.farmobject;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wakanda.forever.WakandaSystemServer.dto.illness.IllnessDto;
import wakanda.forever.WakandaSystemServer.model.farmobject.FarmObject;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmObjectDto {
	
	private Long id;
	private Float humidity;
	private Float temperature;
	private Float waterLevel;
	private Float soilMoisture;
	private Float fire;
	private Float pressure;
	private String createdAt;
	private List<IllnessDto> illnesses;
	
	private String convertDtoDate(Timestamp date) {
		System.out.println("Called convertDtoDate");
		return new SimpleDateFormat("dd-MM-yyyy hh:mm").format(date.getTime());		
	}
	
	public FarmObjectDto(FarmObject farmObject) {
		this.id = farmObject.getId();
		this.humidity = farmObject.getHumidity();
		this.temperature = farmObject.getTemperature();
		this.waterLevel = farmObject.getWaterLevel();
		this.soilMoisture = farmObject.getSoilMoisture();
		this.fire = farmObject.getFire();
		this.pressure = farmObject.getPressure();
		this.createdAt = convertDtoDate(farmObject.getCreatedAt());
	}
}
