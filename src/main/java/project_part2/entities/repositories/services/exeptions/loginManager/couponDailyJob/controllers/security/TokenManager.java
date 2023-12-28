package project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import project_part2.entities.repositories.services.exeptions.loginManager.ClientType;
import project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.ClientController;

@Service
public class TokenManager {
	
	@Autowired
	private Map<String,Information> tokens;
	
	
	public String createToken(ClientType clientType, int clientId ) {
		String token = UUID.randomUUID().toString();
		
		Information information = new Information(clientType,clientId,LocalDateTime.now());
		tokens.put(token,information);
		return token;
	}
	
	
	public boolean isTokenExistAndAdmin(String token) {
		try {
			return tokens.get(token).getType().equals(ClientType.ADMINISTRATOR) ;
		}catch (Exception e) {
			throw new SecurityException("Un Authorizedd");
		}
		
		
	}
	
	public boolean isTokenExistAndCompany(String token) {
		try {
			return tokens.get(token).getType().equals(ClientType.COMPANY) ;
		}catch (Exception e) {
			
			throw new SecurityException("Un Authorizedd");
		}
		
		
	}
	
	public boolean isTokenExistAndCustomer(String token) {
		try {
			return tokens.get(token).getType().equals(ClientType.CUSTOMER) ;
		}catch (Exception e) {
			throw new SecurityException("Un Authorizedd");
		}
		
		
	}

	
	@Scheduled(fixedRate = 1_000*60)
	public void deleteExpired() {
		tokens.values().removeIf((i) -> i.getTime().isAfter(LocalDateTime.now().plusMinutes(30)));
	}
	
}
