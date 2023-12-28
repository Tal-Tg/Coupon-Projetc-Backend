package project_part2.entities;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor

public class Coupon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;		
	
	
	private int categoryId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Company company;
	
	
	private String title;
	
	
	private String description;
	

	private Date startDate;
	
	
	private Date endDate;
	
	
	private int amount;
	
	
	private double price;
	
	
	private String image;
	
	private String alt;
	
	private String bought;
	
	private String location;
	
	
	public Coupon() {
		
	}
	
	public Coupon( Company company, int categoryId, String title, String description, Date startDate,
				 Date endDate, int amount, double price, String image, String alt, String bought,String location) {
		super();
		
		this.company = company;
		this.categoryId = categoryId;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.price = price;
		this.image = image;
		this.alt = alt;
		this.bought = bought;
		this.location = location;
		
	}
	
	
	public Coupon( Integer id, Company company,int categoryId, String title, String description, Date startDate,
			 Date endDate, int amount, double price, String image) {
		super();
		this.id = id;
		this.company = company;
		this.categoryId = categoryId;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.price = price;
		this.image = image;
		
	}
	
	public Coupon( int id,int categoryId, String title, String description, Date startDate,
			 Date endDate, int amount, double price, String image) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.price = price;
		this.image = image;
		
	}
	
	
	

	@Override
	public String toString() {
		return "\nCoupon [id=" + id + ", companyID=" + company.getId()+ ", categoryID="+categoryId + ", title=" + title + ", description=" + description
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", amount=" + amount + ", price=" + price
				+ ", image=" + image + "]\n";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}

	

}
