package wakanda.forever.WakandaSystemServer.dto.farmobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import wakanda.forever.WakandaSystemServer.dto.BaseDto;
import wakanda.forever.WakandaSystemServer.model.farmobject.FarmObject;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class FarmObjectDto extends BaseDto {
	
	private Long id;
	private Float humidity;
	private Float temperature;
	private Float waterLevel;
	private Float soilMoisture;
	private Float fire;
	private Float pressure;
	private String createdAt;
	private Float danger;
	
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
