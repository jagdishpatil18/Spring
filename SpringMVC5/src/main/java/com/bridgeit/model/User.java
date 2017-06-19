package com.bridgeit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="USERREG2")
public class User {
	
	
	@Id
	@GenericGenerator(name="any" ,strategy="increment")
	@GeneratedValue(generator="any")
	private int id;
	
	@Column(name="Name" ,nullable=false)
	@NotBlank(message="Please enter name")
	private String name;
	
	@Column(name="Emailid", unique=true, nullable=false)
	@NotEmpty(message="enter Email id")
	private String emailid;
	
	@Column(name="MobilNo", nullable=false)
	@NotNull(message="Enter mobile number")
	private int mobileno;
	
	@Column(name="Password", nullable=false)
	/*@NotEmpty(message="Password never blank")*/
	@Size(min=6, max=12, message="Password must be between 6 to 12 characters long")
	private String password;
	
	public User()
	{
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public int getMobileno() {
		return mobileno;
	}
	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", emailid=" + emailid + ", mobileno=" + mobileno + ", password="
				+ password + "]";
	}
	
	

}
