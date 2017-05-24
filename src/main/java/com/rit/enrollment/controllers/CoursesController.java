package com.rit.enrollment.controllers;


import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rit.enrollment.logic.CoursesService;
import com.rit.enrollment.repository.Course;




/**
 * Handles requests for the application home page.
 */
@Controller
public class CoursesController {
	@Autowired
	private CoursesService coursesService;
	
	
	
	
	
	@RequestMapping(value = "/coursesList", method = RequestMethod.GET)
    public String coursesList(Model model) {
	 System.out.println("in CoursesList");
	 org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 SimpleGrantedAuthority headSimpleGrantedAuthority = new SimpleGrantedAuthority("head");
	 SimpleGrantedAuthority studentSimpleGrantedAuthority = new SimpleGrantedAuthority("student");
	 SimpleGrantedAuthority facultySimpleGrantedAuthority = new SimpleGrantedAuthority("faculty");
	    if (user.getAuthorities().contains(headSimpleGrantedAuthority)){
	    	return "redirect:/myCoursesDepartment";
	    	
	    }else if (user.getAuthorities().contains(facultySimpleGrantedAuthority)){
	    	return "redirect:/myCoursesFaculty";
	    	
	    }else if (user.getAuthorities().contains(studentSimpleGrantedAuthority)){
	    	return "redirect:/myCoursesStudent";
	    	
	    }
		return null;
	}
	
	@RequestMapping(value = "/myCoursesDepartment", method = RequestMethod.GET)
    public String myCoursesDepartment(Model model) {
	 System.out.println("myCoursesDepartment");
	 org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    List<Course> listCourses = this.coursesService.myCourses(user.getUsername(), user.getAuthorities());
		model.addAttribute("courses", listCourses);
		return "myCoursesDepartment";
	}
	
	@RequestMapping(value = "/myCoursesFaculty", method = RequestMethod.GET)
    public String myCoursesFaculty(Model model) {
	 System.out.println("myCoursesFaculty");
	 org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    List<Course> listCourses = this.coursesService.myCourses(user.getUsername(), user.getAuthorities());
		model.addAttribute("courses", listCourses);
		return "myCoursesFaculty";
	}
	
	@RequestMapping(value = "/myCoursesStudent", method = RequestMethod.GET)
    public String myCoursesStudent(Model model) {
	 System.out.println("myCoursesStudent");
	 org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    List<Course> listCourses = this.coursesService.myCourses(user.getUsername(), user.getAuthorities());
		model.addAttribute("courses", listCourses);
		return "myCoursesStudent";
	}
	
	@RequestMapping(value = "/enrollStudent", method = RequestMethod.GET)
	public String enrollStudentd(Locale locale, Model model) {
		return "enrollStudent";
	}
	
}
