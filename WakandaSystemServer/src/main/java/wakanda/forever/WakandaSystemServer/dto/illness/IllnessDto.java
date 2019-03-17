package wakanda.forever.WakandaSystemServer.dto.illness;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

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
//		System.out.println("Called convertDtoDate");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		dateFormat.setTimeZone(TimeZone.getTimeZone("EET"));
		return dateFormat.format(date.getTime());
	}
	
	public IllnessDto(Illness entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.probability = entity.getProbability();
		this.createdAt = convertDtoDate(entity.getCreatedAt());
	}
}
