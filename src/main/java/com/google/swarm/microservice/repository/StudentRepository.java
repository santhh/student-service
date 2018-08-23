package com.google.swarm.microservice.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.google.swarm.microservice.entity.Student;




//@Profile("spring-data-jpa")
public interface StudentRepository extends Repository <Student, Integer>{

	@Query("SELECT student FROM Student student WHERE student.id =:id")	
    public Student findById(@Param("id") String studentId);
}
