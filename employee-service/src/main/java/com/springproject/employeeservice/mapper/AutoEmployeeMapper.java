package com.springproject.employeeservice.mapper;

import com.springproject.employeeservice.dto.EmployeeDto;
import com.springproject.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoEmployeeMapper {
    AutoEmployeeMapper MAPPER= Mappers.getMapper(AutoEmployeeMapper.class);
    EmployeeDto mapToDto(Employee employee);
    Employee mapToJpa(EmployeeDto employeeDto);
}
