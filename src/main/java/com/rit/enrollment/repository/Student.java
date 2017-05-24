package com.rit.enrollment.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student  implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "stud_id")
	private int studId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private String address;

	private String email;
	
	private String phone;
	
	private int  dept_id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName="user_id")
	private User user;

	public int getStudId() {
		return studId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public int getDept_id() {
		return dept_id;
	}

	public User getUser() {
		return user;
	}
	

}
