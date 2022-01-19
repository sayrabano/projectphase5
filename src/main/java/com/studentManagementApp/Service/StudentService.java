package com.studentManagementApp.Service;

import java.util.List;

import com.studentManagementApp.Entity.Student;

public interface StudentService {
	List<Student> getAllStudents();
	
	Student saveStudents(Student student);
	Student getStudentById(Long id);
	Student updateStudent(Student student);
void deleteStudentById(Long id);

}
