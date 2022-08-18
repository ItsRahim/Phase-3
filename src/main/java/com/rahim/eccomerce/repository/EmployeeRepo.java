package com.rahim.eccomerce.repository;

import com.rahim.eccomerce.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
