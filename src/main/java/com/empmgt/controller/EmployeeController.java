package com.empmgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empmgt.dao.EmployeeDao;
import com.empmgt.exception.ResourceNotFoundException;
import com.empmgt.model.Employee;
import com.empmgt.model.Login;

@RestController
@RequestMapping("/employeeMgt/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	@Autowired
	private EmployeeDao empdao;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return empdao.findAll();
	}
	
	@GetMapping("/employees/{empId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int empId) {
		Employee emp = empdao.findById(empId).orElseThrow(() -> new ResourceNotFoundException(empId+" not available"));
		 return ResponseEntity.ok(emp);
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee emp) {
		return empdao.save(emp);
	}
	
	
	@PutMapping("/employees")
	public ResponseEntity<Employee> updateEmployee( @RequestBody Employee emp) {
		Employee e = empdao.findById(emp.getEmpId()).orElseThrow(() -> new ResourceNotFoundException(emp.getEmpId()+" not available"));
		e.setEmpName(emp.getEmpName());
		e.setEmpDept(emp.getEmpDept());
		
		Employee updatedEmployee = empdao.save(e);
		return ResponseEntity.ok(updatedEmployee);
	}
	@DeleteMapping("/employees/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable  int empId) {
		Employee e = empdao.findById(empId).orElseThrow(() -> new ResourceNotFoundException(empId+" not available"));
		empdao.delete(e);
		return ResponseEntity.ok("Deleted Successfully");
	}
//	@CrossOrigin(origins = "http://localhost:4200/employeeMgt/loginUser")
//	@GetMapping("/loginUser")
//	public ResponseEntity<String> login(@RequestBody Login l){
//		Employee e = empdao.findById(l.getEmpid()).orElse(null);
//		if(e==null || !e.getEmpPass().equals(l.getEmpPass())) {
//			new ResourceNotFoundException(l.getEmpid()+" not available");
//		}
//		return ResponseEntity.ok("Success");
//	}
}