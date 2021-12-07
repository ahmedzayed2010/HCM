package com.cs.hcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cs.hcm.model.request.EmployeeRequestDto;

import com.cs.hcm.model.response.EmployeesResponseDto;
import com.cs.hcm.service.EmployeesService;
import java.util.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/employee")
public class EmployeesController {

	@Autowired
	EmployeesService employeesService;

	@GetMapping("/getAllEmployees")

	public List<EmployeesResponseDto> getALlEmployees() {
		return  employeesService.getAllEMployee();
	}
	
	@GetMapping("/getEmployee/{employeeId}" )
	public EmployeesResponseDto  getEmployeedById(@PathVariable(name = "employeeId") Long Id) {	
	return 	employeesService.getEmployeedById(Id) ; 
	}
	
	@GetMapping("/getEmployeesInRangeOfSalary" )
	public List<EmployeesResponseDto> getEmployeesInRangeOfSalary(@RequestHeader Double fromValue , @RequestHeader Double toValue ){
		return  employeesService.getEmployeesInRangeOfSalary( fromValue  ,  toValue )  ; 
		
	}
	@PostMapping("/insertEmployee" )
	public Boolean  insertEmployee(@RequestBody EmployeeRequestDto  employeeToInsert ) {
		
		return  employeesService.insertEmployee(employeeToInsert)  ; 
		 
	}
	
	@DeleteMapping("/deleteEmployee")
	public  Boolean  deleteEmployee  (@RequestParam Long EmployeeId) {
		return employeesService.deleteEmployee(EmployeeId)  ; 
		
		
	}

	

}
