package project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project_part2.entities.repositories.services.exeptions.loginManager.ClientType;

@Data

@NoArgsConstructor
public class LoginRequest {

	
	private String email;
	private String password;
	private ClientType type;
	
	
	
	
	
	public LoginRequest(String email, String password, ClientType type) {
		super();
		this.email = email;
		this.password = password;
		this.type = type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ClientType getType() {
		return type;
	}
	public void setType(ClientType type) {
		this.type = type;
	}
	
	
}
