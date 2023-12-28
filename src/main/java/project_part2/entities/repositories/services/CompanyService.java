package project_part2.entities.repositories.services;


import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.sun.istack.NotNull;

import project_part2.entities.Company;
import project_part2.entities.Coupon;
import project_part2.entities.repositories.CategoryRepository;
import project_part2.entities.repositories.CompanyRepositroy;
import project_part2.entities.repositories.CouponRepository;
import project_part2.entities.repositories.CustomerCouponsRepository;
import project_part2.entities.repositories.services.exeptions.CouponSystemException;
import project_part2.entities.repositories.services.exeptions.ErrorMessages;

@Service
@Transactional
@Validated
public class CompanyService {

	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CompanyRepositroy companyRepositroy;

	@Autowired
	private CouponRepository couponRepository;

	@Autowired
	private CustomerCouponsRepository customer_vs_CouponsRepository;

	
	
	public Company login(@NotNull  String email,@NotNull String passowrd) throws CouponSystemException {
		Company checkCompanyLodin = companyRepositroy.findCompanyByEmailAndPassword(email, passowrd);
		if(checkCompanyLodin == null) {
			throw new CouponSystemException(ErrorMessages.CANNOT_LOGGIN_IN_THIS_DETAILS);
		}
		return checkCompanyLodin;
	}

	
	
	public Coupon addCoupon(Coupon coupon, int companyId) throws CouponSystemException {
		Company companyCheck = companyRepositroy.findById(companyId).orElseThrow(() -> new CouponSystemException(ErrorMessages.NO_COMPANY_FOUND));
		categoryRepository.findById(coupon.getCategoryId()).orElseThrow(() -> new CouponSystemException(ErrorMessages.NO_CATEGORY_FOUND_IN_THIS_DETAILS));
		
		Date rightNow = new Date();
		
		if(coupon.getCompany().getId() != companyId) {
			throw new CouponSystemException(ErrorMessages.COMPANY_ID_IS_NOT_THE_SAME);
		}
		
		Coupon couponCheck = couponRepository.findByCompanyIdAndTitle(coupon.getCompany().getId(),coupon.getTitle().toLowerCase());
		
		if(couponCheck != null && companyCheck.getId() == couponCheck.getCompany().getId()) {
			throw new CouponSystemException(ErrorMessages.CANNOT_ADD_THE_SAME_TITLE);
		}
		
		if(coupon.getStartDate().before(rightNow) || coupon.getEndDate().before(rightNow)) {
			throw new CouponSystemException(ErrorMessages.DATES_MUST_BE_IN_FUTURE);
		}
		
		if( coupon.getStartDate().after(coupon.getEndDate())) {
			throw new CouponSystemException(ErrorMessages.DATES_MUST_BE_IN_PRESENT);
		}
		coupon.setTitle(coupon.getTitle().toLowerCase());
		Coupon couponReturn = couponRepository.save(coupon);
		return couponReturn;
		
	}


	public Coupon updateCoupon(@NotNull @Valid Coupon coupon,@NumberFormat int companyId) throws CouponSystemException {
		companyRepositroy.findById(companyId).orElseThrow(() -> new CouponSystemException(ErrorMessages.NO_COMPANY_FOUND));
		
		Date rightNow = new Date();
		
		if(coupon.getCompany().getId() != companyId) {
			throw new CouponSystemException(ErrorMessages.COMPANY_ID_IS_NOT_THE_SAME);
		}
		
		Coupon couponCheck = couponRepository.findByCompanyIdAndTitle(companyId,coupon.getTitle().toLowerCase());
		Coupon couponGet = couponRepository.findById(coupon.getId()).orElseThrow(() -> new CouponSystemException(ErrorMessages.NO_COUPON_FOUND_IN_THIS_DETAILS));
		if(couponCheck != null && companyId == couponCheck.getCompany().getId() && couponCheck.getId() != couponGet.getId() ) {
			throw new CouponSystemException(ErrorMessages.CANNOT_ADD_THE_SAME_TITLE);
		}
		
		if(coupon.getStartDate().before(rightNow) || coupon.getEndDate().before(rightNow)) {
			throw new CouponSystemException(ErrorMessages.DATES_MUST_BE_IN_FUTURE);
		}
		
		if( coupon.getStartDate().after(coupon.getEndDate())) {
			throw new CouponSystemException(ErrorMessages.DATES_MUST_BE_IN_PRESENT);
		}
		
		
		
		if(couponGet.getCompany().getId() != companyId ) {
			throw new CouponSystemException(ErrorMessages.YOU_DONY_HAVE_THIS_COUPON);
		}
		
		couponGet.setCategoryId(coupon.getCategoryId());
		couponGet.setDescription(coupon.getDescription());
		couponGet.setAmount(coupon.getAmount());
		couponGet.setEndDate(coupon.getEndDate());
		couponGet.setStartDate(coupon.getStartDate());
		couponGet.setPrice(coupon.getPrice());
		couponGet.setImage(coupon.getImage());
		couponGet.setTitle(coupon.getTitle());
		Coupon couponReturn =  couponRepository.save(couponGet);
		return couponReturn;
	}


	public int deleteCoupon(@NumberFormat int couponId ,@NumberFormat int companyId ) throws CouponSystemException {
		companyRepositroy.findById(companyId).orElseThrow(() -> new CouponSystemException(ErrorMessages.NO_COMPANY_FOUND));
		Coupon couponGet = couponRepository.findById(couponId).orElseThrow(() -> new CouponSystemException(ErrorMessages.NO_COUPON_FOUND_IN_THIS_DETAILS));

		if(couponGet.getCompany().getId() == companyId) {
			customer_vs_CouponsRepository.deleteByCouponId(couponGet.getId());
			couponRepository.deleteById(couponGet.getId());
			 return couponGet.getId();
		}else {
			throw new CouponSystemException(ErrorMessages.MAKE_SURE_YOU_TRY_TO_DELETE_YOUR_COUPONS);
		}

	}

	public List<Coupon> getCoumpanyCoupons(@NumberFormat int companyId) throws CouponSystemException {
		companyRepositroy.findById(companyId).orElseThrow(() -> new CouponSystemException(ErrorMessages.NO_COMPANY_FOUND));
		List<Coupon> coupons = couponRepository.findByCompanyId(companyId);
		return coupons;
		
	}

	public Company getCompanyDetails(@NumberFormat Integer companyId) throws CouponSystemException {
		return companyRepositroy.findById(companyId).orElseThrow(() -> new CouponSystemException(ErrorMessages.NO_COMPANY_FOUND));
		
	}

	public List<Coupon> getCompanyCouponsByCategory(@NumberFormat int companyId ,@NumberFormat int categoryId) throws CouponSystemException {
		companyRepositroy.findById(companyId).orElseThrow(() -> new CouponSystemException(ErrorMessages.NO_COMPANY_FOUND));
		categoryRepository.findById(categoryId).orElseThrow(() -> new CouponSystemException(ErrorMessages.NO_CATEGORY_FOUND));
		return couponRepository.findByCompanyIdAndCategoryId(companyId, categoryId);
		

	}


	public List<Coupon> getCouponsByMaxPrice(@NumberFormat int companyId,@NumberFormat double price) throws CouponSystemException	{
		companyRepositroy.findById(companyId).orElseThrow(() -> new CouponSystemException(ErrorMessages.NO_COMPANY_FOUND));
		return couponRepository.findByCompanyIdAndPriceBetween(companyId ,0.0, price);
	}

}
