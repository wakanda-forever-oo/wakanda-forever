package wakanda.forever.WakandaSystemServer.dto.illness;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import wakanda.forever.WakandaSystemServer.dto.BaseDto;
import wakanda.forever.WakandaSystemServer.model.illness.Illness;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class IllnessDto extends BaseDto {

	private Long id;
	private String name;
	private Float probability;
	private String createdAt;
	
	public IllnessDto(Illness entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.probability = entity.getProbability();
		this.createdAt = convertDtoDate(entity.getCreatedAt());
	}
}
