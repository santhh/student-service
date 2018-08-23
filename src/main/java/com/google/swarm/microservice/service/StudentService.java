package com.google.swarm.microservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.swarm.microservice.entity.Student;
import com.google.swarm.microservice.repository.StudentRepository;

@Service

public class StudentService {

	
	static private final Logger logger = LoggerFactory.getLogger(StudentService.class);

	@Autowired
	private StudentRepository studentRepository;

	   
	   @Transactional(readOnly = true)
		public Student findStudentById(String studentId) throws DataAccessException {
			Student student = null;
			try {
				student = studentRepository.findById(studentId);
			} catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
				logger.error(e.toString());

				return null;
			}
			return student;
		}

	   
}
