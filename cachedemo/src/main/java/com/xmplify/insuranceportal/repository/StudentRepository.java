package com.xmplify.insuranceportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xmplify.insuranceportal.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	

}
