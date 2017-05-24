package com.rit.enrollment.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

	@Entity
	@Table(name="courses")
	public class Course implements java.io.Serializable{
			
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
		@Column(name = "course_id")
		private int courseId;
		
		@Column(name = "course_name")
		private String name;

		@ManyToOne
		@JoinColumn(name = "dept_id", referencedColumnName="dept_id")
		private Department department;

		public int getCourseId() {
			return courseId;
		}

		public String getName() {
			return name;
		}

	
		
		
		
}
