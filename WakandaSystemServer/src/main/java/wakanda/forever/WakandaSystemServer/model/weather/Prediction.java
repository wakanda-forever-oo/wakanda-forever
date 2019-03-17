package wakanda.forever.WakandaSystemServer.model.weather;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
import wakanda.forever.WakandaSystemServer.dto.weather.PredictionDto;

@Entity
@Table(name = "prediction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prediction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Timestamp createdAt;
	
	@NotNull
	private Timestamp modifiedAt;
	
	@OneToMany
	private List<DayPrediction> dayPredictions;
	
	public Prediction(PredictionDto dto) {		
		dayPredictions = new ArrayList<DayPrediction>();		
	}
}
