package com.medline.hibernate.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medline.hibernate.dto.StudentBasicSubjects;
import com.medline.hibernate.entity.BasicSubject;
import com.medline.hibernate.entity.Student;
import com.medline.hibernate.persistence.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo repo;
	
	public List<StudentBasicSubjects> getStudentBasicSubjects() {
		return repo
			.findAll()	
			.stream()
			.map(this::toStudentBasicSubjects)
			.collect(Collectors.toList());
	}
	
	private StudentBasicSubjects toStudentBasicSubjects(Student student) {
		StudentBasicSubjects sbs = new StudentBasicSubjects();
		sbs.setName(student.getName());
		sbs.setSubjects(
			student.getBasicSubject()
				   .stream()
				   .map(BasicSubject::getName)
				   .collect(Collectors.toList()));
		return sbs;
	}
	
}
