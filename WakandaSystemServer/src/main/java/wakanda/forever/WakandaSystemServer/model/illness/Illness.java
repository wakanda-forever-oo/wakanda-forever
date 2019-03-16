package wakanda.forever.WakandaSystemServer.model.illness;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;
import wakanda.forever.WakandaSystemServer.dto.illness.IllnessDto;

@Entity
@Data
public class Illness {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Timestamp createdAt;
	
	@NotNull
	private Timestamp modifiedAt;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "probability")
	private Float probability;
	
	public Illness(IllnessDto dto) {
		this.name = dto.getName();
		this.probability = dto.getProbability();
	}
}
