package com.rit.enrollment.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name="users")
	public class User implements java.io.Serializable{
		
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 8001349980121476264L;
		
		public User(User user){
			this.password = user.password;
			this.role = user.role;
			this.userId = user.userId;
			this.username = user.username;
		}
		
		public User(){
			
		}

		@Id
		 @Column(name = "user_id")
		private int userId;
		
		private String role;

		private String password;
		
		private String username;

		public int getUserId() {
			return userId;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}
		
}
