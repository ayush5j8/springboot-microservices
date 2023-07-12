package com.springproject.departmentservice.service;

import com.springproject.departmentservice.dto.DepartmentDto;

import java.util.UUID;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(String code);
    DepartmentDto getDepartmentById(UUID id);
}
