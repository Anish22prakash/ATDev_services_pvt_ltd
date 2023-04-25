package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.StudentException;
import com.masai.model.Student;
import com.masai.repo.StudentDao;


@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentService;
	

	@Override
	public Student addStudent(Student student) throws StudentException {
		Student saveStudent= studentService.save(student);
		return saveStudent;
	}

	@Override
	public Student getStudentById(Integer id) throws StudentException {
		Optional<Student> st=studentService.findById(id);
		
		if(st.isPresent()) {
			return st.get();
		}else{
		 throw new StudentException("student not found by this id");
		}
	}

	@Override
	public List<Student> getAllStudent() throws StudentException {
		List<Student> allStudents= studentService.findAll();
		if(allStudents.size()>0) {
			return allStudents;
		}else {
			throw new StudentException("no student is availabel");
		}
		
	}

	@Override
	public Student deleteStudentById(Integer id) throws StudentException {
		Optional<Student> st=  studentService.findById(id);
		if(st.isPresent()) {
			Student delStudent= st.get();
			studentService.delete(delStudent);
			
			return delStudent;
		}else {
			throw new StudentException("student is not found by this id");
		}
		
	}

	@Override
	public Student updateStudent(Student student) throws StudentException {
		Optional<Student> st  = studentService.findById(student.getId());
		
		if(st.isPresent()) {
			studentService.save(st.get());
			return st.get();
		}else {
			throw new StudentException("student data is not updated");
		}
		
	}

}
