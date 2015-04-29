/**
 *
 * @author Ekkachai.K
 * @date Apr 4, 2015
 */
package th.co.augmentis.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Entity
@Table(name="ORDERS")
@Repository
public class Orders implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer orderId;
	private Date orderDate;
	private Customer customer;
	private Employee employee;
	
	private Set<OrderDetails> orderDetails = new HashSet<OrderDetails>();
	
	@Id
	@GeneratedValue
	@Column( name = "ORDER_ID" )
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	@Column ( name = "ORDER_DATE")
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@ManyToOne
	@JoinColumn(name ="CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@ManyToOne
	@JoinColumn(name ="EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@OneToMany (mappedBy = "order")
	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
	
}
