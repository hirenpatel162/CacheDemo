package com.xmplify.insuranceportal.service;

import java.util.List;

import com.xmplify.insuranceportal.entity.Student;

public interface StudentService {
	public List<Student> findAllStudents();
	public Student findStudentById(int id);
	public void saveStudent(Student student);
	public void updateStudent(int id,Student student);
	public void deleteStudent(int id);
}
