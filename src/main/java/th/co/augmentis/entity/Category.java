/**
 *
 * @author Ekkachai.K
 * @date Dec 26, 2014
 */
package th.co.augmentis.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;


@Entity
@Table(name="CATEGORY")
@Repository
public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer categoryId;
	private String categoryName;
	
	// Relation to product
    private Set<Product> products = new HashSet<Product>();
	
	@Id
	@GeneratedValue
	@Column(name = "CATEGORY_ID", unique = true, nullable = false)
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	@Column(name = "CATEGORY_NAME", length = 50, nullable = false)
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@OneToMany(mappedBy="category", orphanRemoval=true)
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}
