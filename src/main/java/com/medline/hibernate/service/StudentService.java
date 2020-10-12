package com.medline.hibernate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medline.hibernate.dto.AllSubject;
import com.medline.hibernate.dto.StudentBasicSubjects;
import com.medline.hibernate.dto.StudentSubjects;
import com.medline.hibernate.entity.AlternateSubject;
import com.medline.hibernate.entity.BasicSubject;
import com.medline.hibernate.entity.Student;
import com.medline.hibernate.persistence.AlternateSubjectRepo;
import com.medline.hibernate.persistence.StudentRepo;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepo repo;
	
	@Autowired
	private AlternateSubjectRepo asRepo;
	
	public List<StudentBasicSubjects> getStudentBasicSubjects() {
		return repo
			.findAllStudents()	
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
	
	public List<StudentSubjects> getStudentAllSubjects() {
		List<Student> students = repo.findAllStudents();
		List<AlternateSubject> asList = asRepo.findAll();
		
		return students
			.stream()
			.map(e -> toStudentSubjects(e, asList))
			.collect(Collectors.toList());
	}
	
	private StudentSubjects toStudentSubjects(Student student, List<AlternateSubject> asList) {
		StudentSubjects sbs = new StudentSubjects();
		sbs.setName(student.getName());
		
		Set<BasicSubject> bsList = student.getBasicSubject();
		List<AllSubject> allSubList = new ArrayList<>();

		for(BasicSubject basicSubject : bsList) {
			allSubList.add(new AllSubject(basicSubject.getName(), 
					asList.stream()
						  .filter(e -> e.getId().equals(basicSubject.getId()))
						  .findFirst()
						  .orElse(new AlternateSubject())
						  .getName()));
		}
		
		sbs.setSubjects(allSubList);
		return sbs;
	}
	
}
