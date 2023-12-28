 package project_part2.entities.repositories.services.exeptions.loginManager;


import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project_part2.entities.repositories.services.AdminService;
import project_part2.entities.repositories.services.CompanyService;
import project_part2.entities.repositories.services.CustomerService;
import project_part2.entities.repositories.services.exeptions.CouponSystemException;

@Service
@Transactional
public class LoginManager {

	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CustomerService customerService;
	
	
	public boolean login(@NotNull @Email String email,@NotNull String password, ClientType clientType)throws CouponSystemException {
		if(clientType.equals(ClientType.ADMINISTRATOR)) {
			if(adminService.login(email, password)) {
				return true;
			}
		}
			
		if(clientType.equals(ClientType.COMPANY)) {
			/*
			if(companyService.login(email, password)) {
				return true;
			}
			*/
		}
		
		if(clientType.equals(ClientType.CUSTOMER)) {
			/*
			if(customerService.login(email, password)) {
				return true;
			}
			*/
		}
		return false;
	}
	
	
	
	
}
