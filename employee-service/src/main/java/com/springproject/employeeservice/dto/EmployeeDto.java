package com.springproject.employeeservice.dto;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
}
