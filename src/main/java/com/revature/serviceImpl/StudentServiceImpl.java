package com.revature.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entity.Student;
import com.revature.repository.StudentRepository;
import com.revature.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepo;


	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return studentRepo.findById(id).get();
	}

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		Student s=studentRepo.save(student);
		return s;
	}

	@Override
	public Student updateById(Student student,int id) {
		// TODO Auto-generated method stub
		Student s=studentRepo.findById(id).get();
		s.setName(student.getName());
		s.setAge(student.getAge());
		s.setCourse(student.getCourse());
		return studentRepo.save(s);
	}

	@Override
	public void deleteById(int id) {
		studentRepo.deleteById(id);
		
	}

}
