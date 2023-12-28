package project_part2.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor

public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@NotBlank(message = "first name cannot be empty")
	private String firstName;
	
	@NotNull
	@NotBlank(message = "first name cannot be empty")
	private String lastName;
	
	
	@Email(message = "email must be valid")
	private String email;
	
	@NotNull
	@NotBlank(message = "password cannot be empty")
	private String password;
	
	@OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
	private List<Coupon> coupons;
	
	public Customer() {
		
	}
	
	
	public Customer(@NotNull @NotBlank(message = "") Integer id,@NotBlank(message = "first name cannot be empty") @NotNull String firstName,@NotBlank(message = "last name cannot be empty") @NotNull String lastName,@Email(message = "email must be valid") @NotNull String email,@NotBlank(message = "password cannot be empty") @NotNull  String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		
	}

	
	
	public Customer(@NotBlank(message = "first name cannot be empty") @NotNull String firstName,@NotBlank(message = "last name cannot be empty") @NotNull String lastName,@Email(message = "email is not valid") @NotNull String email,@NotBlank(message = "password cannot be empty") @NotNull String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		
	}

	
	
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public List<Coupon> getCoupons() {
		return coupons;
	}



	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}



	@Override
	public String toString() {
		return "\nCustomer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", Customer coupons= "  ;
	}






}
