package com.studentManagementApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentManagementApp.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
