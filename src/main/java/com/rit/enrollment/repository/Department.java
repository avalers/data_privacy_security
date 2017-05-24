package com.rit.enrollment.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

	@Entity
	@Table(name="departments")
	public class Department implements java.io.Serializable{
			
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
		@Column(name = "dept_id")
		private int deptId;
		
		@Column(name = "dept_name")
		private String name;

		@ManyToOne
		@JoinColumn(name = "user_id", referencedColumnName="user_id")
		private User user;

		public int getDeptId() {
			return deptId;
		}

		public User getUser() {
			return user;
		}



		public String getName() {
			return name;
		}

	
		
		
		
}
