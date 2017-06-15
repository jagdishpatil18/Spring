package com.bridgeit.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Employee")
public class Employee implements Serializable 
{
	@Id
	@GenericGenerator(name="eid",strategy="increment")
	@GeneratedValue(generator="eid")
	private int eid;
	@Column(nullable=false)
	private String Empname;
	@Column(nullable=false)
	private String address;
	@Column(nullable=false,unique=true)
	private long mobile;
	@Column(nullable=false)
	private int salary;
	private int uid;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEmpname() {
		return Empname;
	}
	public void setEmpname(String empname) {
		Empname = empname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", Empname=" + Empname + ", address=" + address + ", mobile=" + mobile
				+ ", salary=" + salary + ", uid=" + uid + "]";
	}
	
	
	
}
