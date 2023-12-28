package project_part2;


import java.sql.Date;
import java.time.LocalDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import project_part2.entities.Company;
import project_part2.entities.Coupon;
import project_part2.entities.Customer;
import project_part2.entities.repositories.services.AdminService;
import project_part2.entities.repositories.services.CompanyService;
import project_part2.entities.repositories.services.CustomerService;
import project_part2.entities.repositories.services.exeptions.CouponSystemException;
import project_part2.entities.repositories.services.exeptions.loginManager.ClientType;
import project_part2.entities.repositories.services.exeptions.loginManager.LoginManager;


@SpringBootApplication
@EnableScheduling
public class Test {
/*
	public void testAll(String [] args) {

		String[] argsTest = args;

		ConfigurableApplicationContext context = SpringApplication.run(Test.class, argsTest); 

		LoginManager loginManager = context.getBean(LoginManager.class);

		AdminService adminService = context.getBean(AdminService.class);

		CompanyService companyService = context.getBean(CompanyService.class);

		CustomerService customerService = context.getBean(CustomerService.class);

		int countMethoudsSecces = 0;


		try {
			System.out.println("try to login admin with wrong details\n");
			loginManager.login("admin@admin.com", "ad", ClientType.ADMINISTRATOR);
			System.out.println("login Successfully");
			countMethoudsSecces++;
		} catch (CouponSystemException e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to login admin with correct details\n");
			loginManager.login("admin@admin.com", "admin", ClientType.ADMINISTRATOR);
			System.out.println("login Successfully");
			countMethoudsSecces++;
		} catch (CouponSystemException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("\n\ntry to add new company with name already exist\n");
			adminService.addNewCompany(new Company("tal", "tal@gmai", "tal123456"));
			System.out.println("added successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("\n\ntry to add new company with email already exist\n");
			adminService.addNewCompany(new Company("gali", "tal@gmail.com", "tal123456"));
			System.out.println("added successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to add new company with correct  details\n");
			adminService.addNewCompany(new Company("atali", "atali@gmail.com", "atali123456"));
			System.out.println("added successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to update company with name already exist\n");
			adminService.updateCompany(new Company(2,"tal", "atali@gmail.c", "gal123456"),2);
			System.out.println("upstae successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}



			try {
			System.out.println("\n\ntry to update company with email already exist\n");
			adminService.updateCompany(new Company(1,"galii", "atali@gmail.com", "gal123456"),1);
			System.out.println("update successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}



		try {
			System.out.println("\n\ntry to update company with correct details\n");
			adminService.updateCompany(new Company(2,"lali", "gal@gal.com", "lali123456") , 2);
			System.out.println("update successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}




		try {
			System.out.println("\n\ntry to delete company with wrong id\n");
			adminService.deleteCompany(0);
			System.out.println("update successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to delete company with correct id\n");
			adminService.deleteCompany(3);
			System.out.println("delete successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}



		try {
			System.out.println("\n\ntry to get all company's\n");
			System.out.println(adminService.getAllCompanyies());
			System.out.println("getting successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to get one company with wrong id\n");
			System.out.println(adminService.getOneCompany(0));
			System.out.println("getting successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("\n\ntry to get one company with correct id\n");
			System.out.println(adminService.getOneCompany(1));
			System.out.println("getting successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}



		try {
			System.out.println("\n\ntry to add new customer with email already exist \n");
			adminService.addNewCustomer(new Customer("dana","dana","dana@dana.com","dana123"));
			System.out.println("getting successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("\n\ntry to add new customer with correct details \n");
			adminService.addNewCustomer(new Customer("hili","govert","hili@hili.com","hili123465"));
			System.out.println("added successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to update a customer with email already exist \n");
			adminService.updateCustomer(new Customer(3,"danaaa","danaaa","dana@dana.com","dannaa"),3);
			System.out.println("updated successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}




		try {
			System.out.println("\n\ntry to update a customer with correct details \n");
			adminService.updateCustomer(new Customer(3,"dani","shal","GAL@GAL.COM","dana123456"),3);
			System.out.println("update successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to delete a customer with wrong details \n");
			adminService.deleteCustomer(0);
			System.out.println("update successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to delete a customer with correct details \n");
			adminService.deleteCustomer(4);
			System.out.println("delete successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to get all customer's with correct details \n");
			System.out.println(adminService.getAllCustomers());
			System.out.println("getting successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to get one customer with wrong details \n");
			System.out.println(adminService.getOneCustomer(0));
			System.out.println("getting successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}



		try {
			System.out.println("\n\ntry to get one customer with correct details \n");
			System.out.println(adminService.getOneCustomer(1));
			System.out.println("getting successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}



		try {
			System.out.println("\n\ntry to login Company with wrong details ... \n");
			loginManager.login("tal@lalalala.com", "tal123", ClientType.COMPANY);
			System.out.println("login successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("\n\ntry to login Company with correct details ... \n");
			loginManager.login("tal@gmail.com", "tal123456", ClientType.COMPANY);
			System.out.println("login successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}



		try {
			System.out.println("\n\ntry to add a coupon with wrong company id... \n");
			Coupon couponAdd = new Coupon(new Company(0), 1, "iphone","cases",Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now().plusDays(1)),10,20.00,"iphone");
			companyService.addCoupon(couponAdd,0);
			System.out.println("added to company: "+ couponAdd.getCompany().getId()  +" successfully. " );
			countMethoudsSecces++;
		} catch (Exception e) {
				System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to add a coupon with same title ... \n");
			Coupon couponAdd2 = new Coupon(new Company(1), 1, "cases","cases",Date.valueOf(LocalDate.now().plusDays(3)),Date.valueOf(LocalDate.now().plusDays(6)),10,20.00,"iphone");
			companyService.addCoupon(couponAdd2,1);
			System.out.println("added to company: "+ couponAdd2.getCompany().getId()  +" successfully. " );
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

		try {
			System.out.println("\n\ntry to add a coupon with correct details ... \n");
			Coupon couponAdd3 = new Coupon(new Company(1), 1, "food","food",Date.valueOf(LocalDate.now().plusDays(2)),Date.valueOf(LocalDate.now().plusDays(3)),10,20.00,"iphone");
			companyService.addCoupon(couponAdd3,1);
			System.out.println("added coupon: "+couponAdd3.getId()+" to company: "+ couponAdd3.getCompany().getId()  +" successfully. " );
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to update a coupon with wrong company id ... \n");
			Coupon couponUpdate = new Coupon(1,new Company(0), 1, "iphone","cases",Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now().plusDays(1)),10,20.00,"iphone");
			companyService.updateCoupon(couponUpdate,0);
			System.out.println("update coupon: "+couponUpdate.getId()+" to company: "+ couponUpdate.getCompany().getId()  +" successfully. " );
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to update a coupon with same title  ... \n");
			Coupon couponUpdate2 = new Coupon(1,new Company(1), 1, "food","iphone",Date.valueOf(LocalDate.now().plusDays(1)),Date.valueOf(LocalDate.now().plusDays(2)),10,20.00,"iphone");
			companyService.updateCoupon(couponUpdate2,1);
			System.out.println("update coupon: "+couponUpdate2.getId()+" to company: "+ couponUpdate2.getCompany().getId()  +" successfully. " );
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("\n\ntry to update a coupon with wrong coupon id  ... \n");
			Coupon couponUpdate3 = new Coupon(0 ,new Company(1), 1, "tallll","cases",Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now().plusDays(1)),10,20.00,"iphone");
			companyService.updateCoupon(couponUpdate3,1);
			System.out.println("update coupon: "+couponUpdate3.getId()+" to company: "+ couponUpdate3.getCompany().getId()  +" successfully. " );
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}



		try {
			System.out.println("\n\ntry to update a coupon with wrong dates details ... \n");
			Coupon couponUpdate4 = new Coupon(1 ,new Company(1), 1, "fodod","salsa",Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now()),10,20.00,"salsa");
			companyService.updateCoupon(couponUpdate4,1);
			System.out.println("update coupon: "+couponUpdate4.getId()+" to company: "+ couponUpdate4.getCompany().getId()  +" successfully. " );
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		try {
			System.out.println("\n\ntry to update a coupon with different company id ... \n");
			Coupon couponUpdate5 = new Coupon(2 ,new Company(2), 1, "light","computer",Date.valueOf(LocalDate.now().plusDays(1)),Date.valueOf(LocalDate.now().plusMonths(12)),10,20.00,"computer");
			companyService.updateCoupon(couponUpdate5,2);
			System.out.println("update coupon: "+couponUpdate5.getId()+" to company: "+ couponUpdate5.getCompany().getId()  +" successfully. " );
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			System.out.println("\n\ntry to update a coupon with correct details ... \n");
			Coupon couponUpdate5 = new Coupon(1 ,new Company(1), 1, "light","computer",Date.valueOf(LocalDate.now().plusDays(1)),Date.valueOf(LocalDate.now().plusMonths(12)),10,20.00,"computer");
			companyService.updateCoupon(couponUpdate5,1);
			System.out.println("update coupon: "+couponUpdate5.getId()+" to company: "+ couponUpdate5.getCompany().getId()  +" successfully. " );
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to delete a coupon with wrong company id ... \n");
			int couponId = 2;
			int companyId = 0;
			companyService.deleteCoupon(couponId,companyId);
			System.out.println("delete coupon: "+couponId+" and company: "+ companyId  +" successfully. " );
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("\n\ntry to delete a coupon with wrong coupon id ... \n");
			int couponId = 0;
			int companyId = 2;
			companyService.deleteCoupon(couponId,companyId);
			System.out.println("delete coupon: "+couponId+" and company: "+ companyId  +" successfully. " );
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("\n\ntry to delete a coupon with different company id ... \n");
			int couponId = 1;
			int companyId = 2;
			companyService.deleteCoupon(couponId,companyId);
			System.out.println("delete coupon: "+couponId+" and company: "+ companyId  +" successfully. " );
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}



		try {
			System.out.println("\n\ntry to delete a coupon with correct details ... \n");
			int couponId = 3;
			int companyId = 1;
			companyService.deleteCoupon(couponId, companyId);
			System.out.println("delete coupon: "+couponId+" and company: "+ companyId  +" successfully. " );
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to get company coupon's with wrong id ... \n");
			int companyId1 = 0;
			companyService.getCoumpanyCoupons(companyId1);
			System.out.println("get coupon to company: "+ companyId1  +" successfully. " );
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to get company coupon's with correct details ... \n");
			int companyId2 = 1;
			System.out.println(companyService.getCoumpanyCoupons(companyId2));
			System.out.println("getting coupon to company: "+ companyId2  +" successfully. " );
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to get company details with wrong id ... \n");
			int companyGet = 0;
			System.out.println(companyService.getCompanyDetails(companyGet));
			System.out.println("getting company: "+ companyGet  +" successfully. " );
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to get company details with correct details ... \n");
			int companyGet1 = 1;
			System.out.println(companyService.getCompanyDetails(companyGet1));
			System.out.println("getting company : "+ companyGet1  +" details successfully. " );
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to get company coupon's with wrong category id ... \n");
			int companyGet2 = 1;
			int categoryId = 5;
			System.out.println(companyService.getCompanyCouponsByCategory(companyGet2, categoryId));
			System.out.println("getting company: "+ companyGet2  +" coupon by category: "+ categoryId  + " successfully. " );
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

		try {
			System.out.println("\n\ntry to get company coupon's with correct details ... \n");
			int companyGet3 = 1;
			int categoryId1 = 1;
			System.out.println(companyService.getCompanyCouponsByCategory(companyGet3, categoryId1));
			System.out.println("getting company: "+ companyGet3  +" coupon by category: "+ categoryId1  + " successfully. " );
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to get company coupon's by max price with wrong company id ... \n");
			int companyGet4 = 50;
			double  maxPrice = 50.0;
			System.out.println(companyService.getCouponsByMaxPrice(companyGet4, maxPrice));
			System.out.println("getting company: "+ companyGet4  +" coupon by max Price: "+ maxPrice  + " successfully. " );
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

		try {
			System.out.println("\n\ntry to get company coupon's by max price with correct details ... \n");
			int companyGet5 = 1;
			double  maxPrice1 = 50.0;
			System.out.println(companyService.getCouponsByMaxPrice(companyGet5, maxPrice1));
			System.out.println("getting company: "+ companyGet5  +" coupon by max Price: "+ maxPrice1  + " successfully. " );
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		


		try {
			System.out.println("\n\ntry to login Customer with wrond details  ... \n");
			loginManager.login("tal@asdsa", "tal123", ClientType.CUSTOMER);
			System.out.println("login successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("\n\ntry to login Customer with correct details  ... \n");
			loginManager.login("tal@golan", "123456", ClientType.CUSTOMER);
			System.out.println("login successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to purchase a coupon with wrong customer Id ... \n");
			int customerId = 20;
			int couponId = 1;
			customerService.purchaseAcoupon(customerId, couponId);
			System.out.println("purchase coupon: "+couponId +" for customer: "+ customerId +" successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to purchase a coupon with wrong coupon Id ... \n");
			int customerId1 = 1;
			int couponId1 = 10;
			customerService.purchaseAcoupon(customerId1, couponId1);
			System.out.println("purchase coupon: "+couponId1 +" for customer: "+ customerId1 +" successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to purchase same coupon twice ... \n");
			int customerId2 = 1;
			int couponId2 = 1;
			customerService.purchaseAcoupon(customerId2, couponId2);
			System.out.println("purchase coupon: "+couponId2 +" for customer: "+ customerId2 +" successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to purchase with correct details ... \n");
			int customerId3 = 3;
			int couponId3 = 1;
			customerService.purchaseAcoupon(customerId3, couponId3);
			System.out.println("purchase coupon: "+couponId3 +" for customer: "+ customerId3 +" successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		
		try {
			System.out.println("\n\ntry to get customer coupons with wrong customer id... \n");
			int customerId4 = 0;
			System.out.println(customerService.getCustomerCoupons(customerId4));
			System.out.println("getting coupon's for customer: "+ customerId4 +" successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("\n\ntry to get customer coupons correct details... \n");
			int customerId4 = 1;
			System.out.println(customerService.getCustomerCoupons(customerId4));
			System.out.println("getting coupon's for customer: "+ customerId4 +" successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to get customer coupons by category with wrong category id... \n");
			int customerId5 = 1;
			int categoryIdGet = 5;
			System.out.println(customerService.getCustomerCouponsByCategory(customerId5, categoryIdGet));
			System.out.println("getting coupon's for customer: "+ customerId5 +" successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}



		try {
			System.out.println("\n\ntry to get customer coupons by category with wrong customer id... \n");
			int customerId56 = 0;
			int categoryIdGet1 = 1;
			System.out.println(customerService.getCustomerCouponsByCategory(customerId56, categoryIdGet1));
			System.out.println("getting coupon's for customer: "+ customerId56 +" successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("\n\ntry to get customer coupons by category with correct details... \n");
			int customerId56 = 1;
			int categoryIdGet1 = 1;
			System.out.println(customerService.getCustomerCouponsByCategory(customerId56, categoryIdGet1));
			System.out.println("getting coupon's for customer: "+ customerId56 +" successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}



		try {
			System.out.println("\n\ntry to get customer coupons by max price with customer Id not valid... \n");
			int customerId8 = 0;
			double maxPrice1 = 50.00;
			System.out.println(customerService.getCustomerCouponsByMaxPrice(customerId8, maxPrice1));
			System.out.println("getting coupon's for customer: "+ customerId8 +" successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		try {
			System.out.println("\n\ntry to get customer coupons by max price with correct details... \n");
			int customerId8 = 1;
			double maxPrice1 = 50.00;
			System.out.println(customerService.getCustomerCouponsByMaxPrice(customerId8, maxPrice1));
			System.out.println("getting coupon's for customer: "+ customerId8 +" successfully");
			countMethoudsSecces++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		 
		System.out.println("\n\nSummery:\n________ \nMethods that succeed: -> "+ countMethoudsSecces);

	}
	*/
}
