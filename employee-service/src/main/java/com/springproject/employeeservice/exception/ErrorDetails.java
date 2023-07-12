package com.springproject.employeeservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
    private LocalDateTime timestamp;
    private String errorMessage;
    private String errorPath;
    private String errorCode;
}
