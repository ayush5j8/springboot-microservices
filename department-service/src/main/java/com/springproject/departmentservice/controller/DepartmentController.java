package com.springproject.departmentservice.controller;

import com.springproject.departmentservice.dto.DepartmentDto;
import com.springproject.departmentservice.mapper.AutoDepartmentMapper;
import com.springproject.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(departmentService.saveDepartment(departmentDto), HttpStatus.CREATED);
    }
    @GetMapping("code/{code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable String code){
        return ResponseEntity.ok(departmentService.getDepartmentByCode(code));
    }
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable String id){
        return ResponseEntity.ok(departmentService.getDepartmentById(UUID.fromString(id)));
    }
}
