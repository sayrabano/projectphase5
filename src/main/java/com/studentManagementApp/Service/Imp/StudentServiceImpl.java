package com.studentManagementApp.Service.Imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentManagementApp.Entity.Student;
import com.studentManagementApp.Repository.StudentRepository;
import com.studentManagementApp.Service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository repo;
	

	@Override
	public List<Student> getAllStudents() {
		
		return repo.findAll();
	}


	public StudentServiceImpl(StudentRepository repo) {
		super();
		this.repo = repo;
	}


	@Override
	public Student saveStudents(Student student) {
		
		return repo.save(student);
	}


	@Override
	public Student getStudentById(Long id) {
		
		return repo.findById(id).get();
	}


	@Override
	public Student updateStudent(Student student) {
		
		return repo.save(student);
	}


	@Override
	public void deleteStudentById(Long id) {
		repo.deleteById(id);
		
	}
	
	

}
