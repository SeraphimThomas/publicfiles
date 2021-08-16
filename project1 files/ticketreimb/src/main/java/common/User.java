package common;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="employeelogin")

public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	@SequenceGenerator(name = "id_generator", sequenceName = "tickets_ticketnumber_seq", allocationSize = 1)
	@Column
	private int employeeid;
	@Column
	private String username;
	@Column
	private String address;
	@Column
	private String city;
	@Column
	private String password;
	@Column
	private boolean manager;
	
	public User() {
		super();
	}
	public User(int employeeid, String username, String address, String city, String password, boolean manager) {
		this.employeeid = employeeid;
		this.username = username;
		this.address=address;
		this.city=city;
		this.password=password;
		this.manager=manager;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isManager() {
		return manager;
	}
	public void setManager(boolean manager) {
		this.manager = manager;
	}
	
	


}
