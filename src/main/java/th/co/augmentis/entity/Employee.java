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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Entity
@Table( name = "EMPLOYEE")
@Repository
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private Date birthDay;
	
	private Set<Orders> orders = new HashSet<Orders>();
	
	@Id
	@GeneratedValue
	@Column( name = "EMPLOYEE_ID")
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	@Column( name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column( name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column( name = "BIRTHDAY")
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	@OneToMany( mappedBy= "employee")
	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	
}
