package project_part2.entities.repositories.services.exeptions.loginManager.couponDailyJob;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import project_part2.entities.Coupon;
import project_part2.entities.repositories.CouponRepository;
import project_part2.entities.repositories.CustomerCouponsRepository;

@Service
public class CouponDailyJob {
	
	@Autowired
	private CouponRepository couponRepository;
	
	@Autowired
	private CustomerCouponsRepository customer_vs_CouponsRepository;
	

	@Scheduled(fixedDelay = 5_000)
	public void deleteCouponsByEndDates() {
		List<Coupon> expiredCoupons = couponRepository.findByEndDateBefore( java.sql.Date.valueOf( LocalDate.now() ) );
		expiredCoupons.forEach( (c) -> customer_vs_CouponsRepository.deleteByCouponId(c.getId() ) );
		expiredCoupons.forEach( (c) -> couponRepository.deleteById(c.getId() ) );
		
	}


	

}
