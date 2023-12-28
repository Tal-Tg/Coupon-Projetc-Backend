package project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security.config.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import project_part2.entities.repositories.services.exeptions.CouponSystemException;

@ControllerAdvice
@RestController
public class CouponControllerAdvice {
	
	
	@ExceptionHandler(value = CouponSystemException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDetails handleException(Exception e) {
		return new ErrorDetails("lol",e.getMessage());
	}
	
	
	@ExceptionHandler(value = SecurityException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ErrorDetails handleException2(Exception e) {
		return new ErrorDetails("lol",e.getMessage());
	}
	
}
