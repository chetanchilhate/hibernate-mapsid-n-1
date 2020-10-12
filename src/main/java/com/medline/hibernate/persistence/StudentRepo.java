package com.medline.hibernate.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medline.hibernate.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

	@Query("SELECT DISTINCT s FROM Student s LEFT JOIN FETCH s.basicSubject")
	List<Student> findAllStudents();
}
