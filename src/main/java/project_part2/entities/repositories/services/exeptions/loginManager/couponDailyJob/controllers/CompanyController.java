package project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project_part2.entities.Company;
import project_part2.entities.Coupon;
import project_part2.entities.repositories.services.CompanyService;
import project_part2.entities.repositories.services.exeptions.CouponSystemException;
import project_part2.entities.repositories.services.exeptions.loginManager.ClientType;
import project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security.LoginRequest;
import project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security.LoginResponse;
import project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security.LoginResponseCompany;
import project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security.TokenManager;

@RestController
@RequestMapping("company")
@CrossOrigin(origins = "*", maxAge = 3600,allowedHeaders = "*")
public class CompanyController extends ClientController{
	
	@Autowired
	private TokenManager tokenManager;
	
	@Autowired
	protected CompanyService companyService;
	
	@PostMapping("login")
	@Override
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws CouponSystemException {
		
		if(loginRequest.getType().equals(ClientType.COMPANY)) {
			
			if(companyService.login(loginRequest.getEmail(), loginRequest.getPassword()) == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
			}
			Company companyReturn = companyService.login(loginRequest.getEmail(), loginRequest.getPassword()); 
		
			String token = tokenManager.createToken(ClientType.COMPANY, companyReturn.getId());
			return new ResponseEntity<>(new LoginResponseCompany(companyReturn.getId(),token,ClientType.COMPANY,companyReturn.getName()),HttpStatus.CREATED);
		
		}
		
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
	
	
	@PostMapping("coupon/{id}")
	public ResponseEntity<?> addCoupon( @RequestBody Coupon coupon , @PathVariable int id, @RequestHeader("authorization") String token) throws CouponSystemException{
		coupon.setCompany(new Company(id));
		return new ResponseEntity<>(companyService.addCoupon(coupon, id),HttpStatus.CREATED);
	}
	
	@PutMapping("coupon/{id}")
	public ResponseEntity<?> updateCoupon(@RequestBody Coupon coupon, @PathVariable int id, @RequestHeader("authorization") String token) throws CouponSystemException{
		return new ResponseEntity<>(companyService.updateCoupon(coupon, id),HttpStatus.OK);
	}
	

	@GetMapping("coupon/{id}")
	public ResponseEntity<?> getCompanyCoupons(@PathVariable int id  ,@RequestHeader("authorization") String token) throws CouponSystemException{
		return new ResponseEntity<List<Coupon>>(companyService.getCoumpanyCoupons(id),HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("coupon/{couponId}/{companyId}")
	public ResponseEntity<?> deleteCoupon(@PathVariable int couponId, @PathVariable int companyId , @RequestHeader("authorization") String token) throws CouponSystemException{
		return new ResponseEntity<>(companyService.deleteCoupon(couponId,companyId),HttpStatus.OK);
	}
	
	
	@GetMapping("couponByCategory/{companyId}/{categoryId}")
	public ResponseEntity<?> getCouponsByCategory(@PathVariable int companyId, @PathVariable int categoryId, @RequestHeader("authorization") String token) throws CouponSystemException{
		
		return new ResponseEntity<>(companyService.getCompanyCouponsByCategory(companyId,categoryId),HttpStatus.OK);
		
	}
	
	@GetMapping("couponByMaxPrice/{companyId}/{maxPrice}")
	public ResponseEntity<?> getCouponsByMaxPrice(@PathVariable int companyId, @PathVariable double maxPrice, @RequestHeader("authorization") String token) throws CouponSystemException{
		return new ResponseEntity<>(companyService.getCouponsByMaxPrice(companyId,maxPrice),HttpStatus.OK);
	}
	
	

}
