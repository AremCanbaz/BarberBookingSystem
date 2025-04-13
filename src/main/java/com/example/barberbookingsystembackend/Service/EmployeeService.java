package com.example.barberbookingsystembackend.Service;

import com.example.barberbookingsystembackend.Entity.Employee;
import com.example.barberbookingsystembackend.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;


    public void addEmployee(Employee employee) {
        String encodedPassword = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encodedPassword);
        employeeRepository.save(employee);
    }

    public String login(String email, String password) {
        Optional<Employee> optionalEmployee = Optional.ofNullable(employeeRepository.findEmployeeByEmail(email));

        Employee employee = optionalEmployee.orElseThrow(() ->
            new RuntimeException("Email-adressen findes ikke"));

        if (!passwordEncoder.matches(password, employee.getPassword())) {
            throw new RuntimeException("Wrong password");
        }
        return jwtService.generateToken(employee);
    }


}
