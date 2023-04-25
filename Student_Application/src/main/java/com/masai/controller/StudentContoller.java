package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.StudentException;
import com.masai.model.Student;
import com.masai.service.StudentService;

@RestController
public class StudentContoller {
	
	
	@Autowired
	private StudentService service;
	
	
	
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudentHandler(@RequestBody Student student) throws StudentException{
		Student st= service.addStudent(student);
		
		return new ResponseEntity<Student>(st,HttpStatus.CREATED);
	} 
	
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<Student> getStudentHandler(@PathVariable("id") Integer id) throws StudentException{
		Student st= service.getStudentById(id);
		
		return new ResponseEntity<Student>(st,HttpStatus.OK);
	} 
	
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudentHandler() throws StudentException{
		List<Student> st= service.getAllStudent();
		
		return new ResponseEntity<List<Student>>(st,HttpStatus.OK);
	} 
	
    @PutMapping("/updateStudents")
	public ResponseEntity<Student> updateStudentHandler(@RequestBody Student student) throws StudentException{
		Student st= service.updateStudent(student);
		
		return new ResponseEntity<Student>(st,HttpStatus.OK);
	} 
	
   @DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<Student> deleteStudentHandler(@PathVariable("id") Integer id) throws StudentException{
		Student st= service.deleteStudentById(id);
		
		return new ResponseEntity<Student>(st,HttpStatus.OK);
	} 
	
	
	
	

}
