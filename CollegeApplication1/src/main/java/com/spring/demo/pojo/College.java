package com.spring.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "College")
@Getter
@Setter
public class College {
	@Id
	private String collegeId;
	@NotBlank(message = "Name is mandatory")
	private String collegeName;
	@NotBlank(message = "Location is mandatory")
	private String location;

	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + ", location=" + location + "]";
	}

}
