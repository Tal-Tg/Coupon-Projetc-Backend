package project_part2.entities.repositories.services.exeptions;

public class CouponSystemException extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public CouponSystemException(ErrorMessages errorMessages) {
		super(errorMessages.getError());
	}
	
	
	

}
