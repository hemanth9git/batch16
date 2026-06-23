package com.tejait.batch16.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tejait.batch16.model.Student;

public interface StudentService{

	Student saveStudent(Student stu);

	void deleteStudent(Integer id);

	Student getStudentById(Integer id);

	List<Student> getAllStudents();

	Page<Student> getAllPagination(int pageNum, int pageSize);

}
