package com.springproject.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class APIResponseDto {
    private DepartmentDto departmentDto;
    private EmployeeDto employeeDto;
}
