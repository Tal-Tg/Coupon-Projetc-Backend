package project_part2.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_part2.entities.CustomerCoupons;

@Repository
public interface CustomerCouponsRepository extends JpaRepository<CustomerCoupons, Integer>{

	
	void deleteByCouponId(Integer couponId);
	
	void deleteByCustomerId(Integer customerid);
	
	
	CustomerCoupons findByCustomerIdAndCouponId(int customerId, int couponId);
	
	
	
	List<CustomerCoupons> findByCustomerId(int customerId);
	
	
}
