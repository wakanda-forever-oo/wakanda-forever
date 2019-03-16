package wakanda.forever.WakandaSystemServer.dto.illness;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wakanda.forever.WakandaSystemServer.model.illness.Illness;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IllnessDto {

	private String name;
	private Float probability;
	
	public IllnessDto(Illness entity) {
		this.name = entity.getName();
		this.probability = entity.getProbability();
	}
}
