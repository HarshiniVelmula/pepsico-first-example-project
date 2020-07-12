package com.spring.demo.pojo.student;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "Student")
public class Student {
	@Id
	private String studentId;
	private int age;
	private String gender;
	private String collegeId;
	private String studentName;
	

}
