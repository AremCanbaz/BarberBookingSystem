package com.example.barberbookingsystembackend.Repository;

import com.example.barberbookingsystembackend.Entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
