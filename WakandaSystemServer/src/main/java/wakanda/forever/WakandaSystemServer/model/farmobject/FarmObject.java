package wakanda.forever.WakandaSystemServer.model.farmobject;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wakanda.forever.WakandaSystemServer.dto.farmobject.FarmObjectDto;
import wakanda.forever.WakandaSystemServer.model.illness.Illness;

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
	
	@Column(name = "water_level")
	private Float waterLevel;
	
	@Column(name = "fire")
	private Float fire;
	
	@Column(name = "pressure")
	private Float pressure;
	
	@OneToMany
	private List<Illness> illnesses;
	
	public FarmObject(FarmObjectDto dto) {
		this.soilMoisture = dto.getSoilMoisture();
		this.humidity = dto.getHumidity();
		this.waterLevel = dto.getWaterLevel();
		this.temperature = dto.getTemperature();
		this.fire = dto.getFire();
		this.pressure = dto.getPressure();
	}
}
