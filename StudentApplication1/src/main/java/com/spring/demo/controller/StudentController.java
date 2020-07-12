package com.spring.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.feign.CollegeFeign;
import com.spring.demo.pojo.student.Student;
import com.spring.demo.pojo.student.StudentBo;
import com.spring.demo.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
      StudentService studentService;
	@RequestMapping("/getAllStudents")
	public Iterable<Student> getAll() {
		return studentService.getAll();	
}

	@GetMapping("/find/{studentId}")
	 public Optional<Student> getStudentById(@PathVariable("studentId") String studentId)
	 {
	 return studentService.getStudentById(studentId);
	 
	 }
	
	@GetMapping("/findByStudentId/{studentId}")
	public StudentBo findOneInAll(@PathVariable("studentId") String studentId)
	 {
	  return studentService.findOneInAll(studentId);
	 }
	  @PostMapping("/save")
	  public ResponseEntity<String> addStudent(@Valid @RequestBody Student student ,BindingResult bindingResult) {
	    	if (bindingResult.hasErrors()) {
	    	
	        return ResponseEntity.ok("Your request is not saved");
	  }
	    	return ResponseEntity.ok("Data is saved");
	    }
	
}

	
		




	



