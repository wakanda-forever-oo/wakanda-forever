package wakanda.forever.WakandaSystemServer.dto.illness;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IllnessDto {

	private String name;
	private Float probability;
}
