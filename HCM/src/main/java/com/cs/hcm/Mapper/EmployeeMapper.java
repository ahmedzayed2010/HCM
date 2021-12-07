package com.cs.hcm.Mapper;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cs.hcm.Entity.EmployeeEntity;
import com.cs.hcm.model.request.EmployeeRequestDto;
import com.cs.hcm.model.response.EmployeesResponseDto;

@Component
public class EmployeeMapper {

	public  EmployeesResponseDto fromEmployeesEntitytoEmployeesDto (EmployeeEntity  emp) {
		
		EmployeesResponseDto dto   = new EmployeesResponseDto() ;
		dto.setEmployeeId(emp.getEmployeeId());
		dto.setFirstName(emp.getFirstName());
		dto.setLastName(emp.getLastName());
		dto.setEmail(emp.getEmail());
		dto.setPhoneNumber(emp.getPhoneNumber());
		dto.setHireDate(emp.getHireDate().toString());
		dto.setJobId(emp.getJobId());
		dto.setSalary(emp.getSalary());
		dto.setCommissionPct(emp.getCommissionPct());
		dto.setDepartmentId(emp.getDepartmentId());
		return dto ; 
	}
	
	public List<EmployeesResponseDto> fromEmployeesEntitytoEmployeesDto(List<EmployeeEntity>  employeeEntityList) {
	List<EmployeesResponseDto> employeesResponseList  = new ArrayList<>()  ;
		for (EmployeeEntity  emp  :employeeEntityList) {
			employeesResponseList.add(fromEmployeesEntitytoEmployeesDto(emp)) ;
		}
		return employeesResponseList;
	}

	public EmployeeEntity fromRequestDtoToEmployeeEntity(EmployeeRequestDto employeeToInsert) {
		EmployeeEntity entity =  new EmployeeEntity() ; 
	
		entity.setFirstName(employeeToInsert.getFirstName());
		entity.setLastName(employeeToInsert.getLastName());
		entity.setEmail(employeeToInsert.getEmail());
		entity.setPhoneNumber(employeeToInsert.getPhoneNumber());
	    Date hireDate=Date.valueOf(employeeToInsert.getHireDate());
		entity.setHireDate(hireDate);
		entity.setJobId(employeeToInsert.getJobId());
		entity.setSalary(employeeToInsert.getSalary());
		entity.setCommissionPct(employeeToInsert.getCommissionPct());
		entity.setDepartmentId(employeeToInsert.getDepartmentId());
		
		return entity;
	}

}
