package project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project_part2.entities.repositories.services.exeptions.loginManager.ClientType;

@Data

@Builder
public class LoginResponseCustomer {

	
	
	private int id;
	private String token;
	private ClientType type;
	private String userName;
	
	
	
	
	
	
	public LoginResponseCustomer() {
		super();
	}






	public LoginResponseCustomer(int id, String token, ClientType type, String userName) {
		super();
		this.id = id;
		this.token = token;
		this.type = type;
		this.userName = userName;
	}






	public int getId() {
		return id;
	}






	public void setId(int id) {
		this.id = id;
	}






	public String getToken() {
		return token;
	}






	public void setToken(String token) {
		this.token = token;
	}






	public ClientType getType() {
		return type;
	}






	public void setType(ClientType type) {
		this.type = type;
	}






	public String getUserName() {
		return userName;
	}






	public void setUserName(String userName) {
		this.userName = userName;
	}






	@Override
	public String toString() {
		return "LoginResponseCustomer [id=" + id + ", token=" + token + ", type=" + type + ", userName=" + userName
				+ "]";
	}
	
	
	
	
}
