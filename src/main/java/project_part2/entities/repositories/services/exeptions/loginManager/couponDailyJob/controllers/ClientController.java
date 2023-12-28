package project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import project_part2.entities.repositories.services.exeptions.CouponSystemException;
import project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security.LoginRequest;
import project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security.LoginResponse;


public abstract class ClientController {

	public abstract ResponseEntity<?> login( LoginRequest loginRequest) throws CouponSystemException;
	
}
