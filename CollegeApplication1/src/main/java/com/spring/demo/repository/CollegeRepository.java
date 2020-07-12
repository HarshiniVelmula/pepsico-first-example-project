package com.spring.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.spring.demo.pojo.College;

public interface CollegeRepository extends CrudRepository <College,String> {
	
	Iterable<College> findAll();

	
	



	
}

