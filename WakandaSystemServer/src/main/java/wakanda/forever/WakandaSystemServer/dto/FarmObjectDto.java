package wakanda.forever.WakandaSystemServer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmObjectDto {
	
	private Float humidity;
	private Float temperature;
	private Float waterLevel;
	private Float soilMoisture;
}
