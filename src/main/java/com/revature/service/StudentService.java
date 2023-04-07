package com.revature.service;

import java.util.List;

import com.revature.entity.Student;

public interface StudentService {
	
	public List<Student> getStudents();
	
	public Student getStudentById(int id);
	
	public Student addStudent(Student student);
	
	public Student updateById(Student student,int id);
	
	public void deleteById(int id);

}
