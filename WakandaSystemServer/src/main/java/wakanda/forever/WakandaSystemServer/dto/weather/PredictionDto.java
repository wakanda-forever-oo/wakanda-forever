package wakanda.forever.WakandaSystemServer.dto.weather;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import wakanda.forever.WakandaSystemServer.dto.BaseDto;
import wakanda.forever.WakandaSystemServer.model.weather.Prediction;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class PredictionDto extends BaseDto{
	
	private Long id;
	private String createdAt;
	private List<DayPredictionDto> result;
	
	public PredictionDto(Prediction entity) {
		this.id = entity.getId();
		this.createdAt = convertDtoDate(entity.getCreatedAt());		
	}
}
