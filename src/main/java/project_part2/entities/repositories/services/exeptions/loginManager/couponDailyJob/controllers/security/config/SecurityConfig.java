package project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security.Information;

@Configuration
public class SecurityConfig {

	@Bean
	public Map<String, Information> map(){
		return new HashMap<>();
	}
	
}
