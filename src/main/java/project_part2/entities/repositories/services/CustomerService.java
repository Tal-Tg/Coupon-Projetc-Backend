package project_part2.entities.repositories.services;


import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import project_part2.entities.Coupon;
import project_part2.entities.Customer;
import project_part2.entities.CustomerCoupons;
import project_part2.entities.repositories.CouponRepository;
import project_part2.entities.repositories.CustomerRepository;
import project_part2.entities.repositories.CustomerCouponsRepository;
import project_part2.entities.repositories.services.exeptions.CouponSystemException;
import project_part2.entities.repositories.services.exeptions.ErrorMessages;

@Service
@Transactional
@Validated
public class CustomerService {
	

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CouponRepository couponRepository;
	
	@Autowired
	private CustomerCouponsRepository customer_vs_CouponsRepository;
	
	
	
	public Customer login(String email, String passowrd) throws CouponSystemException {
		Customer checkCustomerLogin = customerRepository.findByEmailAndPassword(email, passowrd);
		
		if(checkCustomerLogin == null) {
			throw new CouponSystemException(ErrorMessages.CANNOT_LOGGIN_IN_THIS_DETAILS);
		}
		return checkCustomerLogin;
	}
	
	
	public CustomerCoupons purchaseAcoupon(int customerId, int couponId) throws CouponSystemException {
		Customer customer = customerRepository.findById(customerId).orElseThrow(() ->new CouponSystemException(ErrorMessages.NO_CUTOMER_FOUND_IN_THIS_DETAILS) );
		Coupon couponGet=  couponRepository.findById(couponId).orElseThrow(() -> new CouponSystemException(ErrorMessages.NO_COUPON_FOUND_IN_THIS_DETAILS));
		
		CustomerCoupons couponCheck = customer_vs_CouponsRepository.findByCustomerIdAndCouponId(customerId, couponId);
		
		if(couponCheck != null) {
			throw new CouponSystemException(ErrorMessages.YOU_CANNOT_PURCHASE_THE_SAME_COUPON_TWICE);
		}
		
		if(couponGet.getAmount()<=0) {
			throw new CouponSystemException(ErrorMessages.COUPON_CANNOT_BE_PURCHASE_ANY_MORE);
		}
		
		couponGet.setAmount(couponGet.getAmount()-1);
		CustomerCoupons customerCouponsReturn = customer_vs_CouponsRepository.save(new CustomerCoupons(couponGet,customer));
		couponRepository.updateCouponAmount(couponGet.getAmount()-1, couponId);
		return customerCouponsReturn;
	}
	
	
	public List<Coupon> getCustomerCoupons(int customerId) throws CouponSystemException {
		customerRepository.findById(customerId).orElseThrow( () -> new CouponSystemException(ErrorMessages.NO_CUTOMER_FOUND_IN_THIS_DETAILS));
		List<CustomerCoupons> coupons = customer_vs_CouponsRepository.findByCustomerId(customerId);
		List<Coupon> coupon2 = new ArrayList<>();
		coupons.forEach((c) -> coupon2.add(c.getCoupon())); 
		return coupon2;
	}
	
	public List<Coupon> getCustomerCouponsByCategory(int customerId, int categoryId) throws CouponSystemException{
		customerRepository.findById(customerId).orElseThrow( () -> new CouponSystemException(ErrorMessages.NO_CUTOMER_FOUND_IN_THIS_DETAILS));
		
		List<CustomerCoupons> coupons = customer_vs_CouponsRepository.findByCustomerId(customerId);
		List<Coupon> couponByCategroy = new ArrayList<>();
		for(CustomerCoupons coupon : coupons) {
			if(coupon.getCoupon().getCategoryId() == categoryId) {
				couponByCategroy.add(coupon.getCoupon());	
			}
		}
		
		return couponByCategroy;
	}
	
	
	public List<Coupon> getCustomerCouponsByMaxPrice(int customerId ,double maxPrice) throws CouponSystemException{
		customerRepository.findById(customerId).orElseThrow( () -> new CouponSystemException(ErrorMessages.TRY_TO_ENTER_A_VALID_CUSTOMER_ID));
		List<CustomerCoupons> coupons = customer_vs_CouponsRepository.findByCustomerId(customerId);
		List<Coupon> couponByMaxPrice = new ArrayList<>();
		
		for(CustomerCoupons coupon : coupons) {
			if(coupon.getCoupon().getPrice() <= maxPrice) {
				couponByMaxPrice.add(coupon.getCoupon());
			}
			
		}
		return couponByMaxPrice;
	}
	
	
	
	
	public List<Coupon> getAllCouponForPurchase(int customerId) throws CouponSystemException{
		customerRepository.findById(customerId).orElseThrow( () -> new CouponSystemException(ErrorMessages.TRY_TO_ENTER_A_VALID_CUSTOMER_ID));
		
		List<Coupon> couponsReturn = couponRepository.findAll();
		
		return couponsReturn;
	}

	
}
