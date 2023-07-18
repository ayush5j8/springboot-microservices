package com.springproject.employeeservice.service;

import com.springproject.employeeservice.dto.APIResponseDto;
import com.springproject.employeeservice.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(UUID id);
}
