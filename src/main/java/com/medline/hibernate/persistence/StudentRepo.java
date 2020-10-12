package com.medline.hibernate.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medline.hibernate.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

}
