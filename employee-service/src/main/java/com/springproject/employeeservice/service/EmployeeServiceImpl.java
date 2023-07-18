package com.springproject.employeeservice.service;

import com.springproject.employeeservice.dto.APIResponseDto;
import com.springproject.employeeservice.dto.DepartmentDto;
import com.springproject.employeeservice.dto.EmployeeDto;
import com.springproject.employeeservice.entity.Employee;
import com.springproject.employeeservice.exception.ResourceNotFoundException;
import com.springproject.employeeservice.mapper.AutoEmployeeMapper;
import com.springproject.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
//    private RestTemplate restTemplate;
    private WebClient webClient;
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
       // System.out.println("Service:"+employeeDto.getLastName());
        // in case you want to change any propeties in dto and entity after automapper is created,
        //you should delete them becoz they are already generated compiletime and redo it.
        return AutoEmployeeMapper.MAPPER.mapToDto(employeeRepository.save(AutoEmployeeMapper.MAPPER.mapToJpa(employeeDto)));
    }

    @Override
    public APIResponseDto getEmployeeById(UUID id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","id",String.valueOf(id)));
        EmployeeDto employeeDto=AutoEmployeeMapper.MAPPER.mapToDto(employee);
//        ResponseEntity<DepartmentDto> responseEntity=restTemplate.getForEntity("http://localhost:8080/api/departments/code/"+employee.getDepartmentCode(), DepartmentDto.class);
//        DepartmentDto departmentDto=responseEntity.getBody();
          DepartmentDto departmentDto=webClient.get()
                           .uri("http://localhost:8080/api/departments/code/"+employee.getDepartmentCode())
                           .retrieve().bodyToMono(DepartmentDto.class).block();
        APIResponseDto apiResponseDto=new APIResponseDto(departmentDto,employeeDto);
        return apiResponseDto;

    }
}
