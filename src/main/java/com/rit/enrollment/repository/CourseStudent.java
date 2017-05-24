package com.rit.enrollment.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

	@Entity
	@Table(name="course_students")
	public class CourseStudent implements java.io.Serializable{
			
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@ManyToOne
		@JoinColumn(name = "course_id", referencedColumnName="course_id")
		private Course course;
		
		@ManyToOne
		@JoinColumn(name = "stud_id", referencedColumnName="stud_id")
		private Student student;
		
		@Column(name = "cs_id")
		@Id
		private int csId;

		public Course getCourse() {
			return course;
		}

		public Student getStudent() {
			return student;
		}

		public int getCsId() {
			return csId;
		}
		
		
		
}
