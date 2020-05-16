package com.xmplify.insuranceportal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.xmplify.insuranceportal.entity.Student;
import com.xmplify.insuranceportal.repository.StudentRepository;

@SpringBootApplication
public class CachedemoApplication implements CommandLineRunner{

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(CachedemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		studentRepository.save(new Student(1, "hiren","patel","hiren.patel@gmail.com"));
		studentRepository.save(new Student(2,"dipika","patel","dipika.patel@gmail.com"));
		studentRepository.save(new Student(3,"darshi","patel","darshi.patel@gmail.com"));
		studentRepository.save(new Student(4,"rishaan","patel","rishaan.patel@gmail.com"));
		studentRepository.save(new Student(5,"darshan","patel","darshan.patel@gmail.com"));
		studentRepository.save(new Student(6,"kalu","patel","kalu.patel@gmail.com"));
		studentRepository.save(new Student(7,"sanjay","patel","sanjay.patel@gmail.com"));
		studentRepository.save(new Student(8,"rishabh","patel","rishabh.patel@gmail.com"));
		studentRepository.save(new Student(9,"nivya","patel","nivya.patel@gmail.com"));
		studentRepository.save(new Student(10,"nency","patel","nency.patel@gmail.com"));
		studentRepository.save(new Student(11,"ajay","patel","ajay.patel@gmail.com"));
		studentRepository.save(new Student(12,"aarju","patel","aarju.patel@gmail.com"));
		studentRepository.save(new Student(13,"neeta","patel","neeta.patel@gmail.com"));
		studentRepository.save(new Student(14,"digu","patel","digu.patel@gmail.com"));
		studentRepository.save(new Student(15,"saumya","patel","saumya.patel@gmail.com"));
		studentRepository.save(new Student(16,"jayesh","patel","jayesh.patel@gmail.com"));
		studentRepository.save(new Student(17,"chirag","patel","chirag.patel@gmail.com"));
		studentRepository.save(new Student(18,"kush","patel","kush.patel@gmail.com"));
		studentRepository.save(new Student(19,"ram","patel","ram.patel@gmail.com"));
		studentRepository.save(new Student(20,"sheeta","patel","sheeta.patel@gmail.com"));
		studentRepository.save(new Student(21,"bharat","patel","bharat.patel@gmail.com"));
		studentRepository.save(new Student(22,"anjali","patel","anjali.patel@gmail.com"));
		studentRepository.save(new Student(23,"laxman","patel","laxman.patel@gmail.com"));
		
		log.info("################# INITIAL DATA SAVE SUCCESSFULLY #########################");
	}

}
