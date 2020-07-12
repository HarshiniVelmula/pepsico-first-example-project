package com.spring.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.pojo.College;
import com.spring.demo.service.CollegeService;

@RestController
@RequestMapping("/college")
public class CollegeController {

	@Autowired
	CollegeService collegeService;

	@RequestMapping("/getAllColleges")
	public Iterable<College> getAll() {
		return collegeService.getAll();
	}
	
	@GetMapping("/collegeName/{collegeName}")
	public Optional<College> getCollege(@PathVariable String collegeName) {
		return collegeService.getCollege(collegeName);
	}
	

	
	@DeleteMapping("/deleteStudent/{id}")
	 public Boolean deleteStudent(@PathVariable("collegeId") String collegeId) {
	 System.out.println(collegeId);
	 return collegeService.deleteCollege(collegeId);
	 }

	
	@GetMapping("/collegeId/{collegeId}")
	public String getCollegeName(@PathVariable(value = "collegeId") String collegeId) {
		System.out.println("Iam in college application");
		return collegeService.getCollegeName(collegeId);
		
	}
    @PostMapping("/save")
     public ResponseEntity<String> addCollege(@Valid @RequestBody College college ,BindingResult bindingResult) {
    	if (bindingResult.hasErrors()) {
        return ResponseEntity.ok("Your request is not saved "+ bindingResult.getAllErrors());
    	}
    	collegeService.saveCollege(college);
    	return ResponseEntity.ok("Data is saved");
    }


}

	

	

