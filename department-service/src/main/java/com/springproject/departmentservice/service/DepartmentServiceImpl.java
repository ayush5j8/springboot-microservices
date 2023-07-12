package com.springproject.departmentservice.service;

import com.springproject.departmentservice.dto.DepartmentDto;
import com.springproject.departmentservice.entity.Department;
import com.springproject.departmentservice.exception.ResourceNotFoundException;
import com.springproject.departmentservice.mapper.AutoDepartmentMapper;
import com.springproject.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //convert Dto to Jpa entity
        Department savedDepartMent=departmentRepository.save(AutoDepartmentMapper.MAPPER.mapToJpa(departmentDto));
        return AutoDepartmentMapper.MAPPER.mapToDto(savedDepartMent);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department=departmentRepository.findByDepartmentCode(code);
        if(department==null) throw new ResourceNotFoundException("Department","code",String.valueOf(code));
        return AutoDepartmentMapper.MAPPER.mapToDto(department);
    }
    @Override
    public DepartmentDto getDepartmentById(UUID id) {
        Department department=departmentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Department","id",String.valueOf(id)));
        return AutoDepartmentMapper.MAPPER.mapToDto(department);
    }
}
