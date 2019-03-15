package wakanda.forever.WakandaSystemServer.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public abstract class BaseModel {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(columnDefinition = "serial", name = "id")
	private UUID id;
	
	@NotNull
	@Column(name = "createdat")
	private Timestamp createdAt;
	
	@NotNull
	@Column(name = "modifiedat")
	private Timestamp modifiedAt;
}
