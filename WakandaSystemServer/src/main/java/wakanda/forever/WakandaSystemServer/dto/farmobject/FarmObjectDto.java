package wakanda.forever.WakandaSystemServer.dto.farmobject;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wakanda.forever.WakandaSystemServer.model.farmobject.FarmObject;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmObjectDto {
	
	private Float humidity;
	private Float temperature;
	private Float waterLevel;
	private Float soilMoisture;
	private Float fire;
	
	public FarmObjectDto(FarmObject farmObject) {
		this.humidity = farmObject.getHumidity();
		this.temperature = farmObject.getTemperature();
		this.waterLevel = farmObject.getPressure();
		this.soilMoisture = farmObject.getSoilMoisture();
		this.fire = farmObject.getFire();
	}
}
