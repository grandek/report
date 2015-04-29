/**
 *
 * @author Ekkachai.K
 * @date Dec 26, 2014
 */
package th.co.augmentis.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Entity
@Table(name="PRODUCT")
@Repository
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer productId;
	private String productName;
	private double price;
	private Blob image;
	
	//Relation to category @ManyToOne
	private Category category;
	
	private Set<OrderDetails> orderDetails = new HashSet<OrderDetails>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID", unique = true, nullable = false)
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	@Column(name = "PRODUCT_NAME", length = 50, nullable = false)
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Column(name = "PRICE", precision=18 , scale= 2, nullable = false)
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Column(name = "IMAGE")
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID",referencedColumnName="CATEGORY_ID" )
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category productCategory) {
		this.category = productCategory;
	}
	
	@OneToMany (mappedBy = "product")
	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
}
