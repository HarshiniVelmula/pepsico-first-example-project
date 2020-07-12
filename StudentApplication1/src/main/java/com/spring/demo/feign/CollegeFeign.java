package com.spring.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "college-data", url = "http://localhost:8093/college")
public interface CollegeFeign {
	@GetMapping("/collegeId/{collegeId}")
	public String getCollegeName(@PathVariable(value = "collegeId") String collegeId);
}
