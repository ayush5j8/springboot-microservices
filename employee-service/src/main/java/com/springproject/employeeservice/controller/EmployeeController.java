package com.springproject.employeeservice.controller;

import com.springproject.employeeservice.dto.EmployeeDto;
import com.springproject.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        //System.out.println("Controller: "+employeeDto.getLastName());
        return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
    }
    @GetMapping("{employee-id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("employee-id") String id){
        return ResponseEntity.ok(employeeService.getEmployeeById(UUID.fromString(id)));
    }
}
