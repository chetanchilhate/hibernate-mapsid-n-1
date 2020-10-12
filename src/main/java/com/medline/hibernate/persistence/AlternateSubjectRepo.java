package com.medline.hibernate.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medline.hibernate.entity.AlternateSubject;

public interface AlternateSubjectRepo extends JpaRepository<AlternateSubject, Long> {

}
