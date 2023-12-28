package project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security.config.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class ErrorDetails {
	
	
	private String key;
	private String value;
	
	
	
	public ErrorDetails(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	

	
}
