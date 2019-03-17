package wakanda.forever.WakandaSystemServer.model.weather;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wakanda.forever.WakandaSystemServer.dto.weather.DayPredictionDto;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DayPrediction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Timestamp createdAt;
	
	@NotNull
	private Timestamp modifiedAt;
	
	private String datetime;
	
	private Float temperature;
	
	@Column(name = "temperature_min")
	private Float temperatureMin;
	
	@Column(name = "temperature_max")
	private Float temperatureMax;
	
	private Float pressure;
	
	@Column(name = "sea_level")
	private Float seaLevel;
	
	@Column(name = "grnd_level")
	private Float grndLevel;
	
	private Integer humidity;
	
	@Column(name = "wind_speed")
	private Float windSpeed;
	
	public DayPrediction(DayPredictionDto dto) {
		this.datetime = dto.getDatetime();
		this.temperature = dto.getTemperature();
		this.temperatureMin = dto.getTemperature_min();
		this.temperatureMax = dto.getTemperature_max();
		this.pressure = dto.getPressure();
		this.seaLevel = dto.getSea_level();
		this.grndLevel = dto.getGrnd_level();
		this.humidity = dto.getHumidity();
		this.windSpeed = dto.getWind_speed();
	}

}
