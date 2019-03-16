package wakanda.forever.WakandaSystemServer.dto.farmobject;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
	
	private String convertDtoDate(Timestamp date) {
		System.out.println("Called convertDtoDate");
		String dateResult = date.getDate() + "-" + date.getMonth() + "-" + date.getYear() + " " + date.getHours() + ":" + date.getMinutes();
		return dateResult;
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
