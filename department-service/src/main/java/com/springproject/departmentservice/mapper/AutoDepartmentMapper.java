package com.springproject.departmentservice.mapper;

import com.springproject.departmentservice.dto.DepartmentDto;
import com.springproject.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoDepartmentMapper {
    AutoDepartmentMapper MAPPER= Mappers.getMapper(AutoDepartmentMapper.class);
    DepartmentDto mapToDto(Department department);
    Department mapToJpa(DepartmentDto departmentDto);
}
