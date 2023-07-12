package com.springproject.employeeservice.service;

import com.springproject.employeeservice.dto.EmployeeDto;
import com.springproject.employeeservice.entity.Employee;
import com.springproject.employeeservice.exception.ResourceNotFoundException;
import com.springproject.employeeservice.mapper.AutoEmployeeMapper;
import com.springproject.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
       // System.out.println("Service:"+employeeDto.getLastName());
        // in case you want to change any propeties in dto and entity after automapper is created,
        //you should delete them becoz they are already generated compiletime and redo it.
        return AutoEmployeeMapper.MAPPER.mapToDto(employeeRepository.save(AutoEmployeeMapper.MAPPER.mapToJpa(employeeDto)));
    }

    @Override
    public EmployeeDto getEmployeeById(UUID id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","id",String.valueOf(id)));
        return AutoEmployeeMapper.MAPPER.mapToDto(employee);
    }
}
