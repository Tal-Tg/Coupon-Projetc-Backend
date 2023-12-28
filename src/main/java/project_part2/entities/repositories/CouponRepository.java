package project_part2.entities.repositories;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import project_part2.entities.Coupon;


public interface CouponRepository extends JpaRepository<Coupon, Integer> {

	List<Coupon> findByCompanyId( Integer companyId);
	
	void deleteByCompanyId( Integer companyId);
	
	List<Coupon> findByCompanyIdAndCategoryId( Integer categoryId , Integer companyId);
	
	List<Coupon> findByCompanyIdAndPrice( Integer companyId ,double price);
	
	List<Coupon> findByCompanyIdAndPriceBetween( int companyId ,double priceCheck ,double price);
	
	Coupon findByCompanyIdAndTitle(int companyId, String title);
	
	List<Coupon> findByCategoryId(int categoryId);
	
	
	
	
	List<Coupon> findByEndDateBefore(Date endDate);
	
	@Modifying
	@Query(value = "UPDATE Coupon c set c.amount=1? where c.id=2?" , nativeQuery = true)
	void updateCouponAmount(int amount, int id);
	
}
