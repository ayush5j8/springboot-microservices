package com.springproject.departmentservice.repository;

import com.springproject.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartmentRepository extends JpaRepository<Department, UUID> {
 Department findByDepartmentCode(String departmentCode);
}
