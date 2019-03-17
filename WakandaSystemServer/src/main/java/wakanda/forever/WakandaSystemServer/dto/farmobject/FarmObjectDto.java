package wakanda.forever.WakandaSystemServer.dto.farmobject;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

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
	private Float danger;
	
	private String convertDtoDate(Timestamp date) {
//		System.out.println("Called convertDtoDate");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		dateFormat.setTimeZone(TimeZone.getTimeZone("EET"));
		return dateFormat.format(date.getTime());		
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
