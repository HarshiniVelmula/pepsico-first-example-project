package com.spring.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.demo.pojo.student.Student;



public interface StudentRepository extends CrudRepository<Student,String> {
		
	

		Iterable<Student> findAll();
		


}
