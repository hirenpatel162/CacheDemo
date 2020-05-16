package com.xmplify.insuranceportal.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xmplify.insuranceportal.entity.Student;
import com.xmplify.insuranceportal.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable(value = "id") int id) {
		logger.info("GET API---> /student/{id} called" + id);
		return studentService.findStudentById(id);
	}

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		logger.info("GET API---> /students called");
		return studentService.findAllStudents();
	}
	
	@PostMapping("/student/save")
	public void saveStudent(@RequestBody Student student) {
		logger.info("POST API----> /student/save called");
		studentService.saveStudent(student);
	}
	
	@PutMapping("/student/{id}")
	public void updateStudent(@PathVariable int id,@RequestBody Student student) {
		logger.info("PUT API----> /student/save called");
		studentService.updateStudent(id, student);
	}
	
	@DeleteMapping("/student/{id}")
	public void removeStudent(@PathVariable int id) {
		logger.info("DELETE API----> /student/{id} called");
		studentService.deleteStudent(id);
	}
}
