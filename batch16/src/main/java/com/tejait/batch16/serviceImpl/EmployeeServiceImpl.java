package com.tejait.batch16.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tejait.batch16.constants.SearchFilters;
import com.tejait.batch16.model.Employee;
import com.tejait.batch16.repository.EmployeeRepository;
import com.tejait.batch16.service.EmployeeService;

@Service
//The @Service annotation helps java to understand that this is the service class
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired  //injecting the repositary in  the service implementation
	EmployeeRepository repositary;
	@Override
	public Employee saveEmployee(Employee emp) {
		
		//We have to write the business logic in this method
		//The logis is giving the full name by combining the first and last names
		
		String fullName=emp.getFname().concat(" "+emp.getLname());
						emp.setFullname(fullName);
						
		return repositary.save(emp);
	}
	@Override
	public void deleteEmployee(Integer id) {
		repositary.deleteById(id);
		
	}
	@Override
	public Employee getByEmployeeId(Integer id) {
		return repositary.findById(id).get();
	}
	@Override
	public List<Employee> getAllEmployees() {
		return repositary.findAll();
	}
	@Override
	public Page<Employee> getAllPagination(int pageNum, int pageSize) {
		Pageable pagabale=PageRequest.of(pageNum, pageSize);
		return repositary.findAll(pagabale);
	}
	@Override
	public List<Employee> getByDept(String dept) {
		
		return repositary.findByDept(dept);
	}
	@Override
	public List<Employee> getByAge(Integer age) {
		
		return repositary.findByAge(age);
	}
	@Override
	public List<Employee> findByAnd(String fname, String lname) {
		
		return repositary.findByFnameAndLname(fname, lname);
	}
	@Override
	public List<Employee> getByOr(String lname, String fname) {
		
		return repositary.findByLnameOrFname(lname, fname);
	}
	@Override
	public List<Employee> getByAgeLess(Integer age) {
		
		return repositary.findByAgeLessThan(age);
	}
	@Override
	public List<Employee> getByAgeLessEqual(Integer age) {
		
		return repositary.findByAgeLessThanEqual(age);
	}
	@Override
	public List<Employee> getBySalaryGreat(Integer salary) {
		
		return repositary.findBySalaryGreaterThan(salary);
	}
	@Override
	public List<Employee> findByNameLike(String name) {
		
		return repositary.findByFullnameLike(name);
	}
	@Override
	public List<Employee> getByNameContains(String name) {
		
		return repositary.findByFullnameContaining(name);
	}
	@Override
	public List<Employee> getByOrderBy(Integer age) {
		
		return repositary.findByAgeOrderByLnameDesc(age);
	}
	@Override
	public List<Employee> getByOrderByAsc(Integer age) {
		
		return repositary.findByAgeOrderByLname(age);
	}
	@Override
	public List<Employee> dataSorting(String property, String orderType) {
		
		if(orderType.equalsIgnoreCase("DESC")) {
			return repositary.findAll(Sort.by(Direction.DESC, property));
		}
		return repositary.findAll(Sort.by(Direction.ASC, property));
	}
//	@Override
//	public List<Employee> getByDistinct(String fname, String lname) {
//		
//		return repositary.findDistinctBylnameAndfname(fname, lname);
//	}
	@Override
	public List<Employee> searchFilter(String empCode, String type) {
		
		List<Employee> list=null;
		switch(type) {
		case SearchFilters.START_WITH:
					list=repositary.findByEmpCodeStartingWith(empCode);
				break;
		case SearchFilters.END_WITH:
					list=repositary.findByEmpCodeEndingWith(empCode);
				break;
		case SearchFilters.CONTAINS:
					list=repositary.findByEmpCodeContaining(empCode);
				break;
		case SearchFilters.NOT_CONTAINS:
					list=repositary.findByEmpCodeNotContaining(empCode);
				break;
		case SearchFilters.EQUALS:
					list=repositary.findByEmpCode(empCode);
				break;
		case SearchFilters.NOT_EQUALS:
					list=repositary.findByEmpCodeNot(empCode);
				break;
			default:
				throw new IllegalArgumentException("Invalid Arguement");
		}
		return list;
	}
	@Override
	public List<Employee> getAll() {
		
		return repositary.getAll();
	}
//	@Override
//	public List<Employee> getAllEmps() {
//		
//		return repositary.getAllEmps();
//	}
//	@Override
//	public List<String> getbyDeptDistinct() {
//		return repositary.getDistinctDepartment();
//	}
	@Override
	public List<Employee> getBySearch(String searchText) {
		
		return repositary.searchEngine(searchText);
	}

}
