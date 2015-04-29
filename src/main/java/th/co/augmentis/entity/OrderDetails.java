/**
 *
 * @author Ekkachai.K
 * @date Apr 4, 2015
 */
package th.co.augmentis.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Entity
@Table(name="ORDERDETAILS")
@Repository
public class OrderDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer orderDetailId;
	private Integer quantity;
	private Orders order;
	private Product product;
	
	@Id
	@GeneratedValue
	@Column( name = "ORDER_DETAIL_ID" )
	public Integer getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	@Column( name = "QUANTITY")
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@ManyToOne
	@JoinColumn( name = "ORDER_ID", referencedColumnName = "ORDER_ID" )
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	@ManyToOne
	@JoinColumn( name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID" )
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
