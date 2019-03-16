package wakanda.forever.WakandaSystemServer.model.farmobject;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wakanda.forever.WakandaSystemServer.dto.farmobject.FarmObjectDto;

@Entity
@Table(name = "FarmObject")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FarmObject{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(columnDefinition = "serial", name = "id")
	private Long id;
	
	@NotNull
	private Timestamp createdAt;
	
	@NotNull
	private Timestamp modifiedAt;
	
	@Column(name = "soil_moisture")
	private Float soilMoisture;
	
	@Column(name = "humidity")
	private Float humidity;
	
	@Column(name = "temperature")
	private Float temperature;
	
	@Column(name = "pressure")
	private Float pressure;
	
	@Column(name = "fire")
	private Float fire;
	
	public FarmObject(FarmObjectDto dto) {
		this.soilMoisture = dto.getSoilMoisture();
		this.humidity = dto.getHumidity();
		this.pressure = dto.getWaterLevel();
		this.temperature = dto.getTemperature();
	}
}
