package project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project_part2.entities.Coupon;
import project_part2.entities.repositories.CouponRepository;

@RestController
@RequestMapping("guest")
@CrossOrigin(origins = "*", maxAge = 3600,allowedHeaders = "*")
public class GuestController {
	
	@Autowired
	private CouponRepository couponRepository;
	
	@GetMapping("/coupon")
	public ResponseEntity<?> getGuestCoupons(){
		return new ResponseEntity<>(couponRepository.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/coupon/{id}")
	public ResponseEntity<?> getGuestCoupons(@PathVariable int id){
		return new ResponseEntity<>(couponRepository.findById(id),HttpStatus.OK);
	}


}
