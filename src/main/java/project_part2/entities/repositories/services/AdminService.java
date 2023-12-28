package project_part2.entities.repositories.services;

import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import com.sun.istack.NotNull;
import project_part2.entities.Company;
import project_part2.entities.Coupon;
import project_part2.entities.Customer;
import project_part2.entities.repositories.CompanyRepositroy;
import project_part2.entities.repositories.CouponRepository;
import project_part2.entities.repositories.CustomerRepository;
import project_part2.entities.repositories.CustomerCouponsRepository;
import project_part2.entities.repositories.services.exeptions.CouponSystemException;
import project_part2.entities.repositories.services.exeptions.ErrorMessages;


@Service
@Transactional
@Validated
public class AdminService {


	@Autowired
	private CouponRepository couponRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CompanyRepositroy companyRepositroy;

	@Autowired
	private CustomerCouponsRepository customer_vs_CouponsRepository;



	public boolean login(@NotNull String email, @NotNull String password ) throws CouponSystemException {
		
		if(email.equalsIgnoreCase("admin@admin.com") && password.equals("admin")) {
			return true;
		}
		throw new CouponSystemException(ErrorMessages.CANNOT_LOGGIN_IN_THIS_DETAILS);
			
	}


	public Company addNewCompany(@NotNull @Valid Company company) throws CouponSystemException {
		Company companyEmail = companyRepositroy.findByEmail(company.getEmail());
		Company companyName = companyRepositroy.findByName(company.getName());
		if(companyName != null) {
			System.out.println("lala");
			 throw new CouponSystemException(ErrorMessages.NAME_ALREDY_EXIST_IN_DB);
		}
		if(companyEmail != null) {
			System.out.println("lala1");
			throw new CouponSystemException(ErrorMessages.EMAIL_ALREADY_EXIST_IN_DB);
		}
		
		Company comapny = companyRepositroy.save(company);
		return comapny;
	}

	//,@NotNull Integer companyId
	public Company updateCompany(@NotNull Company company) throws CouponSystemException {
		Company companyCheck = companyRepositroy.findById(company.getId()).orElseThrow( () -> new CouponSystemException(ErrorMessages.NO_COMPANY_FOUND)); 
		
		Company emailCheck = companyRepositroy.findByEmail(company.getEmail());
		Company nameCheck = companyRepositroy.findByName(company.getName());
		
		if(emailCheck != null && companyCheck.getId() != emailCheck.getId()) {
			throw new CouponSystemException(ErrorMessages.EMAIL_ALREADY_EXIST_IN_DB);
		}
		if(nameCheck != null && companyCheck.getId() != nameCheck.getId()) {
			throw new CouponSystemException(ErrorMessages.NAME_ALREDY_EXIST_IN_DB);
		}
		companyCheck.setEmail(company.getEmail());
		companyCheck.setPassword(company.getPassword());
		Company companyReturn = companyRepositroy.save(companyCheck);
		return companyReturn;
		}


	public int deleteCompany(@NotNull Integer companyID) throws CouponSystemException {
		Company companyCheck = companyRepositroy.findById(companyID).orElseThrow( () -> new CouponSystemException(ErrorMessages.NO_COMPANY_FOUND) ); 
		int id = companyCheck.getId();
		List<Coupon> coupons = couponRepository.findByCompanyId(companyCheck.getId());
		coupons.forEach( (c) -> customer_vs_CouponsRepository.deleteByCouponId(c.getId()));
		coupons.forEach((c) -> couponRepository.delete(c));
		companyRepositroy.delete(companyCheck);
		return id;
		
	}


	public List<Company> getAllCompanyies(){
		return companyRepositroy.findAll();
		
	}


	public Company getOneCompany(@NotNull Integer companyID) throws CouponSystemException {
		return companyRepositroy.findById(companyID).orElseThrow(() ->new CouponSystemException(ErrorMessages.NO_COMPANY_FOUND));
		
	}


	
	public Customer addNewCustomer(@NotNull @Valid Customer customer) throws CouponSystemException {
		Customer customerCheck = customerRepository.findByEmail(customer.getEmail());
		if(customerCheck != null) {
			throw new CouponSystemException(ErrorMessages.EMAIL_ALREADY_EXIST_IN_DB);
		}
		Customer customerReturn = customerRepository.save(customer);
		return customerReturn;

	}


	public Customer updateCustomer(@NotNull Customer customer) throws CouponSystemException {
		Customer customerCheck = customerRepository.findById(customer.getId()).orElseThrow( () -> new CouponSystemException(ErrorMessages.NO_CUTOMER_FOUND_IN_THIS_DETAILS));
	
		Customer customerEmail = customerRepository.findByEmail( customer.getEmail());
		
		if(customerCheck != null && customerEmail != null ) {
			throw new CouponSystemException(ErrorMessages.EMAIL_ALREADY_EXIST_IN_DB);
		}
		customerCheck.setFirstName(customer.getFirstName());
		customerCheck.setLastName(customer.getLastName());
		customerCheck.setPassword(customer.getPassword());
		Customer customerReturn = customerRepository.save(customerCheck);
		return customerReturn;
		
	}


	public int deleteCustomer(@NotNull Integer customerID) throws CouponSystemException {
		Customer customer = customerRepository.findById(customerID).orElseThrow( () -> new CouponSystemException(ErrorMessages.NO_CUTOMER_FOUND_IN_THIS_DETAILS));
		int id = customer.getId();
		customer_vs_CouponsRepository.deleteByCustomerId(customer.getId());
		customerRepository.delete(customer);
		return id;
	}


	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
		 
	}


	public Customer getOneCustomer(@NotNull Integer customerID) throws CouponSystemException {
		return customerRepository.findById(customerID).orElseThrow(() -> new CouponSystemException(ErrorMessages.NO_CUTOMER_FOUND_IN_THIS_DETAILS));
		
	}

	

}
