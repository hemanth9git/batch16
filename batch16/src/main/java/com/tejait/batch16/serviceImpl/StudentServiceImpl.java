package com.tejait.batch16.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.tejait.batch16.model.Student;
import com.tejait.batch16.repository.StudentRepository;
import com.tejait.batch16.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository repository;
	@Override
	public Student saveStudent(Student stu) {
		
		String fullName=stu.getFname().concat(stu.getLname());
						stu.setFullName(fullName);
						Student savedStu=repository.save(stu);
		return savedStu;
	}
	@Override
	public void deleteStudent(Integer id) {
		repository.deleteById(id);
		
	}
	@Override
	public Student getStudentById(Integer id) {
		
		return repository.findById(id).get();
	}
	@Override
	public List<Student> getAllStudents() {
		
		return repository.findAll();
	}
	@Override
	public Page<Student> getAllPagination(int pageNum, int pageSize) {
		Pageable pagable=PageRequest.of(pageNum, pageSize);
		return repository.findAll(pagable);
	}
	
	
	

	

}
