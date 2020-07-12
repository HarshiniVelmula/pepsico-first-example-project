package com.spring.demo.services;

import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.feign.CollegeFeign;
import com.spring.demo.pojo.student.Student;
import com.spring.demo.pojo.student.StudentBo;
import com.spring.demo.repository.StudentRepository;
@Service
public class StudentService {
		@Autowired
		DataSource dataSource;
		@Autowired
		StudentRepository studentRepository;
		@Autowired
		CollegeFeign collegeFeign;
		

		public  Iterable<Student> getAll()
		{
			Iterable<Student> stud=studentRepository.findAll();
			stud.forEach(entry->{ if(entry.getGender().equals("M")) {
				                     entry.setStudentName("Mr." + entry.getStudentName());
			
			
			}
			else {
				entry.setStudentName("Ms."+entry.getStudentName());
			}
			});
			return stud;
		}
	
		
		
		public Optional<Student> getStudentById(String studentId) {
			
			return studentRepository.findById(studentId);
		}
		 
	public StudentBo findOneInAll(String studentId) {
		Optional<Student> student=studentRepository.findById(studentId);
			Student stud=student.get();
		     StudentBo bo=new StudentBo();
		     
		    bo.setCollegeId(stud.getCollegeId());
		    bo.setAge(stud.getAge());
		    bo.setGender(stud.getGender());
		    bo.setStudentId(stud.getStudentId());
			 bo.setCollegeName(collegeFeign.getCollegeName(stud.getCollegeId()));
			return bo;
			}
	
		

}
