package wakanda.forever.WakandaSystemServer.dto.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wakanda.forever.WakandaSystemServer.model.weather.DayPrediction;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayPredictionDto {
	
	private Long id;
	private String datetime;
	private Float temperature;
	private Float temperature_min;
	private Float temperature_max;
	private Float pressure;
	private Float sea_level;
	private Float grnd_level;
	private Integer humidity;
	private Float wind_speed;
	
	public DayPredictionDto(DayPrediction entity) {
		this.id = entity.getId();
		this.datetime = entity.getDatetime();
		this.temperature = entity.getTemperature();
		this.temperature_min = entity.getTemperatureMin();
		this.temperature_max = entity.getTemperatureMax();
		this.pressure = entity.getPressure();
		this.sea_level = entity.getSeaLevel();
		this.grnd_level = entity.getGrndLevel();
		this.humidity = entity.getHumidity();
		this.wind_speed = entity.getWindSpeed();
	}

	public DayPredictionDto(DayPredictionDto prd) {
		this.id = prd.getId();
		this.datetime = prd.getDatetime();
		this.temperature = prd.getTemperature();
		this.temperature_min = prd.getTemperature_min();
		this.temperature_max = prd.getTemperature_max();
		this.pressure = prd.getPressure();
		this.sea_level = prd.getSea_level();
		this.grnd_level = prd.getGrnd_level();
		this.humidity = prd.getHumidity();
		this.wind_speed = prd.getWind_speed();
	}
}
