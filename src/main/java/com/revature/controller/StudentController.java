package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.Student;
import com.revature.service.StudentService;

@RestController
@RequestMapping("api/v1")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents(){
		return new ResponseEntity<>(studentService.getStudents(),HttpStatus.OK);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable(name="id") int id){
		return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.OK);
	}
	
	@PostMapping("/student")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		return new ResponseEntity<>(studentService.addStudent(student),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(name="id") int id,
			@RequestBody Student student){
		return new ResponseEntity<>(studentService.updateById(student, id),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("student/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable(name="id") int id){
		studentService.deleteById(id);
		return new ResponseEntity<>("Student deleted successfully ",HttpStatus.OK);
	}
	
}
