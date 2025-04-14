package com.example.barberbookingsystembackend.Controller;

import com.example.barberbookingsystembackend.DTO.CostumerOrEmployeeLoginRequest;
import com.example.barberbookingsystembackend.DTO.EmployeeDTO;
import com.example.barberbookingsystembackend.Entity.Costumer;
import com.example.barberbookingsystembackend.Entity.Employee;
import com.example.barberbookingsystembackend.Service.CostumerService;
import com.example.barberbookingsystembackend.Service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/employee")
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(CostumerController.class);
    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/save")
    public ResponseEntity<String> addemployee(@RequestBody EmployeeDTO employee) {
        logger.info("Saving Employee",employee);
        employeeService.addEmployeeFromDTO(employee);
        logger.info("Employee Saved",employee);
        return ResponseEntity.ok("Employee added successfully");
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CostumerOrEmployeeLoginRequest request) {
        logger.info("Login attempt for: {}", request.getEmail(), " Password", request.getPassword());
        try {
            String token = employeeService.login(request.getEmail(), request.getPassword());
            return ResponseEntity.ok().body(token);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}
