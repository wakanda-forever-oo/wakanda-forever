package wakanda.forever.WakandaSystemServer.dto.illness;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wakanda.forever.WakandaSystemServer.model.illness.Illness;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IllnessDto {

	private Long id;
	private String name;
	private Float probability;
	private String createdAt;
	
	private String convertDtoDate(Timestamp date) {
		String dateResult = date.getDate() + "-" + date.getMonth() + "-" + date.getYear() + " " + date.getHours() + ":" + date.getMinutes();
		return dateResult;
	}
	
	public IllnessDto(Illness entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.probability = entity.getProbability();
		this.createdAt = convertDtoDate(entity.getCreatedAt());
	}
}
