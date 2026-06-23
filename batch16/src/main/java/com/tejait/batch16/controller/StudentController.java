package com.tejait.batch16.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch16.model.Student;
import com.tejait.batch16.service.StudentService;





@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	StudentService service;
	
	@RequestMapping(value="saveEmp",method = RequestMethod.POST)
	public ResponseEntity<Student> saveStudent(@RequestBody Student stu){
		Student savedStudent=service.saveStudent(stu);
		return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="updateStu",method = RequestMethod.PUT)
	public ResponseEntity<Student> updateEmployee(@RequestBody Student stu){
		
		Student updateStu=service.saveStudent(stu);
		return new ResponseEntity<Student>(updateStu, HttpStatus.OK);
	}
	
	@RequestMapping(value="deleteStu/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
		service.deleteStudent(id);
		return new ResponseEntity<String>("Deleted Student id : "+id, HttpStatus.OK);
	}
	
	@RequestMapping(value="getStu/{roll_Number}",method = RequestMethod.GET)
	public ResponseEntity<Student> getStudentById(@PathVariable Integer roll_Number){
		Student stuObj=service.getStudentById(roll_Number);
		return new ResponseEntity<Student>(stuObj, HttpStatus.OK);
	}
	
	@RequestMapping(value="getAllStu",method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> list=service.getAllStudents();
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}
	
	public Page<Student> pagination(@RequestParam int pageNum,@RequestParam int pageSize){
		
		Page<Student> page=service.getAllPagination(pageNum,pageSize);
		return page;
	}
	
	
	
	
}
