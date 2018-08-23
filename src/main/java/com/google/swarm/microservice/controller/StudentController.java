package com.google.swarm.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.swarm.microservice.entity.Student;
import com.google.swarm.microservice.service.StudentService;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("/api/students")
public class StudentController {

	
	@Autowired
	private StudentService studentService;
	
		@RequestMapping(value = "/{studentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ResponseEntity<Student> getStudent(@PathVariable("studentId") String studentId) {
			Student student = null;
			student = this.studentService.findStudentById(studentId);
			if (student == null) {
				return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		}
}
