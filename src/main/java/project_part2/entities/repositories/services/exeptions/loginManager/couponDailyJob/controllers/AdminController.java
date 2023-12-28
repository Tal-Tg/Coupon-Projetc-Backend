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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import project_part2.entities.Company;
import project_part2.entities.Customer;
import project_part2.entities.repositories.services.AdminService;
import project_part2.entities.repositories.services.exeptions.CouponSystemException;
import project_part2.entities.repositories.services.exeptions.loginManager.ClientType;
import project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security.LoginRequest;
import project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security.LoginResponse;
import project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob.controllers.security.TokenManager;

@RestController
@RequestMapping("admin")
@CrossOrigin(origins = "*", maxAge = 3600,allowedHeaders = "*")
public class AdminController extends ClientController {
	
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private TokenManager tokenManager;

	
	@PostMapping("login")
	@Override
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws CouponSystemException {
		
		
		if(loginRequest.getType().equals(ClientType.ADMINISTRATOR)) {
			
			if(!adminService.login(loginRequest.getEmail(), loginRequest.getPassword())) {
				return new ResponseEntity<String>("cannot login with thous details",HttpStatus.BAD_REQUEST); 
			}
		
			String token = tokenManager.createToken(ClientType.ADMINISTRATOR, -1);
			return new ResponseEntity<>(new LoginResponse(token,ClientType.ADMINISTRATOR,"admin"),HttpStatus.OK);
		
		}
		
			return new ResponseEntity<String>("cannot login with thous details",HttpStatus.BAD_REQUEST); 
		}
		
	
	
	
	@PostMapping("company")
	public ResponseEntity<?> addNewCompany(@RequestBody Company comapny , @RequestHeader("authorization") String token) throws CouponSystemException{
		return new ResponseEntity<>(adminService.addNewCompany(comapny),HttpStatus.CREATED);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<?> updateCompany(@RequestBody Company comapny ,@PathVariable int id , @RequestHeader("authorization") String token) throws CouponSystemException{
		comapny.setId(id);
		return new ResponseEntity<>(adminService.updateCompany(comapny),HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("company/{id}")
	public ResponseEntity<?> deleteCompany(@PathVariable int id ,@RequestHeader("authorization") String token) throws CouponSystemException{
		return new ResponseEntity<>(adminService.deleteCompany(id),HttpStatus.CREATED);
	}
	
	@GetMapping("company")									
	public ResponseEntity<?> getAllCompanies(@RequestHeader("Authorization") String token){
		return new ResponseEntity<List<Company>>(adminService.getAllCompanyies(),HttpStatus.OK);

	}
	
	@GetMapping("company/{id}")
	public ResponseEntity<?> getOneCompany(@PathVariable int id ,@RequestHeader("authorization") String token) throws CouponSystemException{
		return new ResponseEntity<>(adminService.getOneCompany(id),HttpStatus.OK);
	}
	
	@PostMapping("customer")
	public ResponseEntity<?> addNewCustomer(@RequestBody Customer customer , @RequestHeader("authorization") String token) throws CouponSystemException{
		return new ResponseEntity<>(adminService.addNewCustomer(customer),HttpStatus.CREATED);
	}
	
	@PutMapping("customer/{id}")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer ,@PathVariable int id, @RequestHeader("authorization") String token) throws CouponSystemException{
		customer.setId(id);
		return new ResponseEntity<>(adminService.updateCustomer(customer),HttpStatus.CREATED);
	}
	
	@DeleteMapping("customer/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int id ,@RequestHeader("authorization") String token) throws CouponSystemException{
		return new ResponseEntity<>(adminService.deleteCustomer(id),HttpStatus.OK);
	}
	
	@GetMapping("customer")
	public ResponseEntity<?> getAllCustomer(@RequestHeader("authorization") String token){
		return new ResponseEntity<List<Customer>>(adminService.getAllCustomers(),HttpStatus.OK);
	}
	
	@GetMapping("customer/{id}")
	public ResponseEntity<?> getOneCustomer(@PathVariable int id ,@RequestHeader("authorization") String token) throws CouponSystemException{
		return new ResponseEntity<>(adminService.getOneCustomer(id),HttpStatus.OK);
	}
	
	
	
}
