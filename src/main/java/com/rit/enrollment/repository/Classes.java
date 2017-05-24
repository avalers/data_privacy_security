package com.rit.enrollment.repository;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

	@Entity
	@Table(name="classes")
	public class Classes implements java.io.Serializable{
			
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@ManyToOne
		@JoinColumn(name = "course_id", referencedColumnName="course_id")
		private Course course;
		
		@ManyToOne
		@JoinColumn(name = "fact_id", referencedColumnName="fact_id")
		private Faculty faculty;
		
		@Column(name = "class_id")
		@Id
		private int classId;
		
		@Column(name = "started_date")
		private Date startedDate;
		
		@Column(name = "finished_date")
		private Date finishedDate;

		public Course getCourse() {
			return course;
		}

		public Faculty getFaculty() {
			return faculty;
		}

		public int getClassId() {
			return classId;
		}

		public Date getStartedDate() {
			return startedDate;
		}

		public Date getFinishedDate() {
			return finishedDate;
		}

		public void setCourse(Course course) {
			this.course = course;
		}

	
		
		
		
}
