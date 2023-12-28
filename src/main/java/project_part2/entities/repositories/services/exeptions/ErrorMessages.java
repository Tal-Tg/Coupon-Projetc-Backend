package project_part2.entities.repositories.services.exeptions;


public enum ErrorMessages {

	EMAIL_IS_INVALID("Email or password is invalid"),
	NAME_ALREDY_EXIST_IN_DB("Name already exist"),
	EMAIL_ALREADY_EXIST_IN_DB("Email already exist"),
	NO_COMPANY_FOUND("No company found in this detail`s"),
	CANNOT_LOGGIN_IN_THIS_DETAILS("cannot Login with thous details"),
	COMPANY_ID_IS_NOT_THE_SAME("Company id is not the same"),
	CANNOT_ADD_THE_SAME_TITLE("You already have this title. You cannot add the same title twice."),
	DATES_MUST_BE_IN_FUTURE("Dates must be in the future."),
	DATES_MUST_BE_IN_PRESENT("Coupon start date cannot be after end date."),
	YOU_DONY_HAVE_THIS_COUPON("You don`t have this coupon"),
	NO_COUPON_FOUND_IN_THIS_DETAILS("no coupon in this details"),
	MAKE_SURE_YOU_TRY_TO_DELETE_YOUR_COUPONS("Make sure you trying to delete Your conpon`s"),
	NO_CATEGORY_FOUND("no category in this details."),
	NO_CUTOMER_FOUND_IN_THIS_DETAILS("there is no customer in this details"),
	YOU_CANNOT_PURCHASE_THE_SAME_COUPON_TWICE("You cannot purchase the same coupon twice"),
	COUPON_CANNOT_BE_PURCHASE_ANY_MORE("Coupon cannot be purchase any more"),
	TRY_TO_ENTER_A_VALID_CUSTOMER_ID("try to enter a valid customer id."),
	NO_CATEGORY_FOUND_IN_THIS_DETAILS("no categroy id found in this details");
	
	
	private String error;
	
	ErrorMessages(String error){
		this.setError(error);
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
	
	
}
