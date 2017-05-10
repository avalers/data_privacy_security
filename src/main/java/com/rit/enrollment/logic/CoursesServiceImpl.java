package com.rit.enrollment.logic;

import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.rit.enrollment.repository.Course;
import com.rit.enrollment.repository.CourseRepository;
import com.rit.enrollment.repository.Student;
import com.rit.enrollment.repository.User;
import com.rit.enrollment.repository.UserRepository;

@Service
public class CoursesServiceImpl implements CoursesService{
	
	@Autowired
	private CourseRepository courseRepository;


	@Override
	@Transactional
	public List<Course> myCourses(String username, Collection<GrantedAuthority> authorities) {
		Iterator<GrantedAuthority> it =authorities.iterator();
		GrantedAuthority grantedAuthority = it.next();
		 List<Course> courses = null;
		if (grantedAuthority.getAuthority().equalsIgnoreCase("student")){
			courses = courseRepository.myCourses(username);
		} else if (grantedAuthority.getAuthority().equalsIgnoreCase("faculty")){
			courses = courseRepository.myClasses(username);
		} else if (grantedAuthority.getAuthority().equalsIgnoreCase("head")){
			courses = courseRepository.allCoursesForDepartment(username);
		}
		
		return courses;
	}


}
