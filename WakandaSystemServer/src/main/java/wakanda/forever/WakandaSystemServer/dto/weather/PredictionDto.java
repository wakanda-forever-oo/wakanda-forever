package wakanda.forever.WakandaSystemServer.dto.weather;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PredictionDto {
	
	private List<DayPredictionDto> result;
}
