package project_part2.entities;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;



@Entity
@AllArgsConstructor

@Data
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "name cannot be empty")
	private String name;
	
	@Email(message = "email must be valid")
	private String email;
	
	@NotBlank(message = "password cannot be empty")
	private String password;

	/*
	@OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
	private List<Coupon> coupons;
	*/
	public Company( ) {
		
	}
	
	
	public Company( Integer id) {
		this.id = id;
	}
	

	
	public Company( String name,String email,String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	/*
	public Company(Integer id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
*/
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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
/*
	public List<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}
**/
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", Company coupons: ";
	}





}
