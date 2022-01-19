package com.studentManagementApp.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentManagementApp.Entity.Student;
import com.studentManagementApp.Service.StudentService;
@Controller
public class StudentController {
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/")
	public String listStudents(Model model) {
		model.addAttribute("students",studentService.getAllStudents());
		return "students";
	}

	
	@GetMapping("/students/new")
	public String createStudentForm(Model m) {
		Student st = new Student();
		m.addAttribute("student",st);
		return "add_student";
	}
	
	@PostMapping("/")
	public String saveStudent(@ModelAttribute("student") Student student) {
    studentService.saveStudents(student);
    return "redirect:/";
}
	@GetMapping("/students/edit/{id}")
	public String updateStudentForm(@PathVariable Long id ,Model m) {
		m.addAttribute("student",studentService.getStudentById(id));
		return "edit_student";
		
	}
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long  id,
		@ModelAttribute("student") Student student,Model m) {
		
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(student.getId());
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		studentService.updateStudent(existingStudent);
		return "redirect:/";
		
		
	}
	
	@GetMapping("/students/delete/{id}")
	public String studentDelet(@PathVariable Long id) {
	studentService.deleteStudentById(id);	
	return "redirect:/";
	}
}