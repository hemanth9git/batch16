package com.tejait.batch16.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tejait.batch16.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	//@Repository annotation will tells the java that this is the repository interface
	//without the annotation the java dont know that this is the repository class
	// So to understand that we use the annotations everywhere
	
	//JPA performs operations on entity but not on table
	//insert into Employee values(?,?,?,?); - JPQL (or) HQL
	//insert into employee_b16 values(?,?,?,?,?,?);
	
	public List<Employee> findByDept(String dept);
	public List<Employee> findByAge(Integer age);
	public List<Employee> findBySalaryBetween(Integer age1,Integer age2);
	public List<Employee> findByFnameAndLname(String fname,String lname);
	public List<Employee> findByLnameOrFname(String lname,String fname);
	public List<Employee> findByAgeLessThan(Integer age);
	
	public List<Employee> findByAgeLessThanEqual(Integer age);
	public List<Employee> findBySalaryGreaterThan(Integer age);
											//%25Data%25 like this we have to pass the 
									//parameter value
	public List<Employee> findByFullnameLike(String name);
	
	//This is the advanced version of the like method
	// We did not want to pass the %25 encoder for searching the subString
	public List<Employee> findByFullnameContaining(String name);
	
	//It will give the records of age = input value and order by last name in 
	//descending order
	public List<Employee> findByAgeOrderByLnameDesc(Integer age);
	
	public List<Employee> findByAgeOrderByLname(Integer age);
	
	//public List<Employee> findDistinctBylnameAndfname(String fname,String lname);
	
	//-------------SearchFilters---------------
	public List<Employee> findByEmpCodeStartingWith(String empCode);
	public List<Employee> findByEmpCodeEndingWith(String empCode);
	public List<Employee> findByEmpCodeContaining(String empCode);
	public List<Employee> findByEmpCodeNotContaining(String empCode);
	public List<Employee> findByEmpCode(String empCode);
	public List<Employee> findByEmpCodeNot(String empCode);
	//-------------SearchFilters---------------
	
	//If we want to execute the sql queries we use @query() annotation and directly write the queries
	//inside the @Query() annotation
	@Query("select e from Employee e")//Used to write and execute the JPA queries 
	public List<Employee> getAll();
	
//	@Query(value="select * from employee_b16",nativeQuery = true)
//	public List<Employee> getAllEmps();
//	
//	@Query("select e from Employee e where dept=?1")
//	public List<Employee> getByDept(String dept); //?1 bind with the first parameter 
//	//of the below method
//	
//	@Query("select e from Employee where e.dept=:department")
//	public List<Employee> findByDeptData(@Param("department") String dept);
//	
//	@Query("select e from Employee e where fname=?1 and lname=?2")
//	public List<Employee> findByFirstNameAndLastName(String fname,String lname);
//	
//	//Distinct query
//	@Query("select distinct(e.dept) from Employee e ")
//	public List<String> getDistinctDepartment();
	
	@Query("select e from Employee e where concat(e.dept,e.fname,e.fullname,e.lname,e.age,e.salary,e.empCode) like %?1%")
	public List<Employee> searchEngine(String SearchText);
	
	
	
	
}
