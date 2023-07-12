package com.springproject.departmentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id; // in mysql uuid is saved as blob hence we have BIN_TO_UUID(ID) or UUID_TO_BIN(ID) for any operation
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
