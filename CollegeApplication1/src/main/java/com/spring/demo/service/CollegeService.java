package com.spring.demo.service;


import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.pojo.College;
import com.spring.demo.repository.CollegeRepository;


@Service
public class CollegeService {

	@Autowired
	DataSource dataSource;
	@Autowired
	CollegeRepository collegeRepository;
	public Optional<College> getCollege(String collegeName) {
		return collegeRepository.findById(collegeName);
	}
	public College saveCollege( College college) {

		  return collegeRepository.save(college);

		 }
	
	public Iterable<College> getAll(){
		return collegeRepository.findAll();
	}
	
	public String getCollegeName(String collegeId) {
		Optional<College> college=collegeRepository.findById(collegeId);
		College coll=college.get();
		return  coll.getCollegeName();
	}
	
	public Boolean deleteCollege(String collegeId) {
		 Optional<College> college = collegeRepository.findById(collegeId);
		 collegeRepository.delete(college.get());
		 return true;
		 }
}


