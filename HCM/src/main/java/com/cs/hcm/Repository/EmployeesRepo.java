package com.cs.hcm.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cs.hcm.Entity.EmployeeEntity;

@Repository
public interface EmployeesRepo extends JpaRepository<EmployeeEntity, Long> {  
 List<EmployeeEntity> findBySalaryBetween(Double fromValue, Double toValue) ; 
}
