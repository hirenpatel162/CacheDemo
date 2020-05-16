package com.xmplify.insuranceportal.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.xmplify.insuranceportal.entity.Student;
import com.xmplify.insuranceportal.repository.StudentRepository;
import com.xmplify.insuranceportal.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private Map<Integer, Student> cacheMap = new HashMap<Integer, Student>();
	private final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Autowired
	private StudentRepository studentRepository;

	// When Application Starts successfully this event triggered

	@EventListener(ApplicationReadyEvent.class)
	public void AcknowledgeApplicationStartUp() {
		List<Student> studentList = studentRepository.findAll();
		for (Student student : studentList) {
			cacheMap.put(student.getId(), student);
		}
		log.info("############# CACHE INITIALIZED SUCCESSFULLY  ######");
		log.info("######## CAHCE SIZE:::" + cacheMap.size());
	}

	@Override
	public List<Student> findAllStudents() {
		List<Student> studentList = null;
		long startingTime = System.currentTimeMillis();
		try {
			synchronized (cacheMap) {
				if (cacheMap.size() > 0) {
					log.info("values provided from cache...");
					studentList = cacheMap.values().stream().collect(Collectors.toList());
					return studentList;
				}
			}
			log.info("Value provided from DB....");
			studentList = studentRepository.findAll();
			return studentList;
		} catch (Exception e) {
			log.error("Error in reading student list", e);
			return studentList;
		} finally {
			log.info("Time to read data::::" + (System.currentTimeMillis() - startingTime));
		}

	}

	@Override
	public Student findStudentById(int id) {
		Student student = null;
		try {
			synchronized (cacheMap) {
				student = cacheMap.get(id);
				if (student != null) {
					log.info("Value provided from cache....");
					return student;
				}
			}
			student = studentRepository.findById(id).get();
			log.info("Value provided from DB....");
			synchronized (cacheMap) {
				cacheMap.put(student.getId(), student);
			}
			return student;
		} catch (Exception e) {
			log.error("No Data Available in DB..");
			return student;
		}

	}

	@Override
	public void saveStudent(Student student) {
		try {
			studentRepository.save(student);
			log.info("Value added to DB...");
			synchronized (cacheMap) {
				cacheMap.put(student.getId(), student);
				log.info("Value added to cache...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(int id, Student student) {
		try {
			Student stu = studentRepository.findById(id).get();
			stu.setFirstName(student.getFirstName());
			stu.setLastName(student.getLastName());
			stu.setEmai(student.getEmai());
			studentRepository.save(stu);
			synchronized (cacheMap) {
				cacheMap.put(id, stu);
				log.info("cacheMap updated.....");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteStudent(int id) {
		try {
			studentRepository.deleteById(id);
			synchronized (cacheMap) {
				cacheMap.remove(id);
				log.info("Entry deleted from cache...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
