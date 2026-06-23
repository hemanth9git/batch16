package com.tejait.batch16.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch16.model.Employee;
import com.tejait.batch16.service.EmployeeService;

@RestController
@RequestMapping("employee") //Class level path
public class EmployeeController {

	@Autowired
	EmployeeService service;
	@RequestMapping(value="saveEmp",method=RequestMethod.POST) // method level path
	
	//Here we are getting the input data as a JSON format 
	// so for converting the JSON to java we use the @RequestBody annotation 
	//Before the Employee object. It internally converts the JSON to java Object
	//Same like that the java object is converted into the JSON object
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		
		Employee savedEmp=service.saveEmployee(emp);
		return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
		
	}
	
	@PostMapping("updateEmp")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
		Employee updateEmp=service.saveEmployee(emp);
		
		return new ResponseEntity<>(updateEmp, HttpStatus.OK);
	}
	@DeleteMapping("deleteEmp/{id}")
	// Here observe the value  deleteEmp/{id} we have to specify the id in the postman 
	//URL which we want to deletre the id
	public ResponseEntity<String> deleteEmployee( @PathVariable Integer id){
		service.deleteEmployee(id);
		return new ResponseEntity<>("Deleted id :: "+id, HttpStatus.OK);
	}
	@GetMapping("getEmp/{id}")			
	public ResponseEntity<Employee> getByEmployeeId(@PathVariable Integer id){
		Employee empObj=service.getByEmployeeId(id);
		return new ResponseEntity<>(empObj, HttpStatus.OK);
	}
	
	@GetMapping("getAllEmp")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> list=service.getAllEmployees();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("getPages")
	public Page<Employee> pagination(@RequestParam int pageNum,@RequestParam int pageSize){
		return service.getAllPagination(pageNum,pageSize);
	}
	
	@GetMapping("findById")
	public ResponseEntity<List<Employee>> findByDept(@RequestParam String dept){
		List<Employee> list=service.getByDept(dept);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("findByAge")
	public ResponseEntity<List<Employee>> findByAge(@RequestParam Integer age){
		 List<Employee> list =service.getByAge(age);
		 return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("AndOperation")
	public ResponseEntity<List<Employee>> findByAnd(@RequestParam String fname,@RequestParam String lname){
		List<Employee> list=service.findByAnd(fname,lname);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("OrOperation")
	public ResponseEntity<List<Employee>> findByOr(@RequestParam String lname, @RequestParam String fname){
		List<Employee> list =service.getByOr(lname,fname);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("LessThan")
	public ResponseEntity<List<Employee>> findByAgeLess(@RequestParam Integer age){
		
		List<Employee> list =service.getByAgeLess(age);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("LessThanEqual")
	public ResponseEntity<List<Employee>> findByAgeLessEqual(@RequestParam Integer age){
		
		List<Employee> list=service.getByAgeLessEqual(age);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("greaterThan")
	public ResponseEntity<List<Employee>> findBySalaryGreat(@RequestParam Integer salary){
		
		List<Employee> list=service.getBySalaryGreat(salary);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("nameLike")
	public ResponseEntity<List<Employee>> findByNameLike(@RequestParam String name){
		
		List<Employee> list=service.findByNameLike(name);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("nameContains")
	public ResponseEntity<List<Employee>> findByNameContains(@RequestParam String name){
		
		List<Employee> empObj=service.getByNameContains(name);
		return new ResponseEntity<>(empObj, HttpStatus.OK);
	}
	
	@GetMapping("OrderByDesc")
	public ResponseEntity<List<Employee>> findByOrderBy(@RequestParam Integer age){
		
		List<Employee> list=service.getByOrderBy(age);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("OrderByAsc")
	public ResponseEntity<List<Employee>> findByOrderByAsc(@RequestParam Integer age){
		
		List<Employee> list=service.getByOrderByAsc(age);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("dataSorting")
	public ResponseEntity<List<Employee>> dataSorting(@RequestParam String property,@RequestParam String orderType){
		
		List<Employee> sortedList=service.dataSorting(property,orderType);
		return new ResponseEntity<>(sortedList, HttpStatus.OK);
	}
	
	
//	public ResponseEntity<List<Employee>> findByDistinct(@RequestParam String fname,@RequestParam String lname){
//		List<Employee> list=service.getByDistinct(fname,lname);
//		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
//	}
	
	@GetMapping("searchFilters")
	public ResponseEntity<List<Employee>> searchFilter(@RequestParam String empCode,@RequestParam String type){
		List<Employee> list=service.searchFilter(empCode,type);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<List<Employee>> getAllMethod(){
		List<Employee> list=service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
//	@GetMapping("getAllEmps")
//	public ResponseEntity<List<Employee>> getAllEmps(){
//		List<Employee> list=service.getAllEmps();
//		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
//	}
//	
//	@GetMapping("getbyDeptDistinct")
//	public ResponseEntity<List<String>> getByDeptDistinct(){
//		List<String> list=service.getbyDeptDistinct();
//		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
//	}
	
	@GetMapping("search/{searchText}")
	public ResponseEntity<List<Employee>> searchEmployees(@PathVariable String searchText){
		List<Employee> list=service.getBySearch(searchText);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
