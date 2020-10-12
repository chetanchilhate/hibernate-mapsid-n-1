package com.medline.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medline.hibernate.dto.StudentBasicSubjects;
import com.medline.hibernate.service.StudentService;

@RestController
public class HomeController {

	@Autowired
	private StudentService service;

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/students")
	public List<StudentBasicSubjects> getAllStudents() {
		return service.getStudentBasicSubjects();
	}
}
