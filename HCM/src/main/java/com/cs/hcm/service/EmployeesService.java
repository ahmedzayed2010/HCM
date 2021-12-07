package com.cs.hcm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs.hcm.Entity.EmployeeEntity;
import com.cs.hcm.Mapper.EmployeeMapper;
import com.cs.hcm.Repository.EmployeesRepo;
import com.cs.hcm.model.request.EmployeeRequestDto;
import com.cs.hcm.model.response.EmployeesResponseDto;

@Service
public class EmployeesService {

	@Autowired
	EmployeesRepo employeesRepo;

	@Autowired
	EmployeeMapper employeeMapper;

	public List<EmployeesResponseDto> getAllEMployee() {
		List<EmployeeEntity> employees = employeesRepo.findAll();
		return employeeMapper.fromEmployeesEntitytoEmployeesDto(employees);
	}

	public EmployeesResponseDto getEmployeedById(Long id) {
		Optional<EmployeeEntity> Emp = employeesRepo.findById(id);
		if (Emp.isPresent()) {
			return employeeMapper.fromEmployeesEntitytoEmployeesDto(Emp.get());

		}
		return null;
	}

	public List<EmployeesResponseDto> getEmployeesInRangeOfSalary(Double fromValue, Double toValue) {
		List<EmployeeEntity> employees = employeesRepo.findBySalaryBetween(fromValue, toValue);
		return employeeMapper.fromEmployeesEntitytoEmployeesDto(employees);
	}

	public Boolean insertEmployee(EmployeeRequestDto employeeToInsert) {
		try {
			EmployeeEntity Entity  = employeeMapper.fromRequestDtoToEmployeeEntity(employeeToInsert)  ; 
			employeesRepo.save(Entity) ; 
			return true  ;
		}

		catch (Exception e) {
			e.printStackTrace();
		return false  ; 
		}
	
	}

	
	public Boolean deleteEmployee(Long employeeId) {
	
		try {
			
			employeesRepo.deleteById(employeeId);
			return true  ; 
			
		}
		catch(Exception  e) {
			e.printStackTrace();
			return  false  ; 
		}

	}

}
