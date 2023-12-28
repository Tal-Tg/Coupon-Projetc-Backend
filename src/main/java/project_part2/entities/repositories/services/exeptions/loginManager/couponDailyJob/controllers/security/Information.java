package project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project_part2.entities.repositories.services.exeptions.loginManager.ClientType;


@Data

@NoArgsConstructor
public class Information {
	
	private ClientType type;
	private int id;
	private LocalDateTime time;
	
	
	
	
	
	public Information(ClientType type, int id, LocalDateTime time) {
		super();
		this.type = type;
		this.id = id;
		this.time = time;
	}
	public ClientType getType() {
		return type;
	}
	public void setType(ClientType type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	
	
}
