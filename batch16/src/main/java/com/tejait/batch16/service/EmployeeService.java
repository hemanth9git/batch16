package com.tejait.batch16.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tejait.batch16.model.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee emp);

	public void deleteEmployee(Integer id);

	public Employee getByEmployeeId(Integer id);

	public List<Employee> getAllEmployees();

	public Page<Employee> getAllPagination(int pageNum, int pageSize);

	public List<Employee> getByDept(String dept);

	public List<Employee> getByAge(Integer age);

	public List<Employee> findByAnd(String fname, String lname);

	public List<Employee> getByOr(String lname, String fname);

	public List<Employee> getByAgeLess(Integer age);

	public List<Employee> getByAgeLessEqual(Integer age);

	public List<Employee> getBySalaryGreat(Integer salary);

	public List<Employee> findByNameLike(String name);

	public List<Employee> getByNameContains(String name);

	public List<Employee> getByOrderBy(Integer age);

	public List<Employee> getByOrderByAsc(Integer age);

	public List<Employee> dataSorting(String property, String orderType);

	public List<Employee> searchFilter(String empCode, String type);

	public List<Employee> getAll();
//
//	public List<Employee> getAllEmps();
//
//	public List<String> getbyDeptDistinct();

	public List<Employee> getBySearch(String searchText);

	public Boolean existsById(Integer id);

	//public List<Employee> getByDistinct(String fname, String lname);
}
