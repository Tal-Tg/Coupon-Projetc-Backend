package project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project_part2.entities.Customer;
import project_part2.entities.repositories.services.CustomerService;
import project_part2.entities.repositories.services.exeptions.CouponSystemException;
import project_part2.entities.repositories.services.exeptions.loginManager.ClientType;
import project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security.LoginRequest;
import project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security.LoginResponse;
import project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security.LoginResponseCustomer;
import project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security.TokenManager;

@RestController
@RequestMapping("customer")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class CustomerController extends ClientController {

	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private TokenManager tokenManager;
	
	
	@PostMapping("login")
	@Override
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws CouponSystemException {
		if(loginRequest.getType().equals(ClientType.CUSTOMER)) {
			
			if(customerService.login(loginRequest.getEmail(), loginRequest.getPassword()) == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
			}
			
			Customer customerReeturn = customerService.login(loginRequest.getEmail(), loginRequest.getPassword());
		
			String token = tokenManager.createToken(ClientType.CUSTOMER, customerReeturn.getId());
			
			return new ResponseEntity<>(new LoginResponseCustomer(customerReeturn.getId(),token,ClientType.CUSTOMER,customerReeturn.getFirstName()),HttpStatus.CREATED);
		}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
	
	
	
	@PostMapping("coupon/{couponId}/{customerId}")
	public ResponseEntity<?> purchaseACoupon(@PathVariable int couponId, @PathVariable int customerId, @RequestHeader("authorization") String token) throws CouponSystemException {
		
		return new ResponseEntity<>(customerService.purchaseAcoupon(customerId, couponId),HttpStatus.OK);
	}
	
	@GetMapping("coupon/{customerId}")
	public ResponseEntity<?> getCustomerCoupons(@PathVariable int customerId,  @RequestHeader("authorization") String token) throws CouponSystemException{
		return new ResponseEntity<>(customerService.getCustomerCoupons(customerId),HttpStatus.OK);
		}
	
	@GetMapping("all-coupon/{customerId}")
	public ResponseEntity<?> getAllCoupons(@PathVariable int customerId,  @RequestHeader("authorization") String token) throws CouponSystemException{
		
		return new ResponseEntity<>(customerService.getAllCouponForPurchase(customerId),HttpStatus.OK);
	}
	
	@GetMapping("coupons-by-category/{customerId}/{categoryId}")
	public ResponseEntity<?> getCouponByCategory(@PathVariable int customerId, @PathVariable int categoryId, @RequestHeader("authorization") String token ) throws CouponSystemException{
		return new ResponseEntity<>(customerService.getCustomerCouponsByCategory(customerId, categoryId), HttpStatus.OK);
	}
	
	@GetMapping("coupons-by-maxPrice/{customerId}/{maxPrice}")
	public ResponseEntity<?> getCouponsByMaxPrice(@PathVariable int customerId, @PathVariable int maxPrice ,@RequestHeader("authorization") String token) throws CouponSystemException{
		return new ResponseEntity<>(customerService.getCustomerCouponsByMaxPrice(customerId, maxPrice), HttpStatus.OK);
	}
	
	
	
}
