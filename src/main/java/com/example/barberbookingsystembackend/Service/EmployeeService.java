package com.example.barberbookingsystembackend.Service;

import com.example.barberbookingsystembackend.DTO.EmployeeDTO;
import com.example.barberbookingsystembackend.Entity.Employee;
import com.example.barberbookingsystembackend.Entity.Salon;
import com.example.barberbookingsystembackend.Repository.EmployeeRepository;
import com.example.barberbookingsystembackend.Repository.SalonRepository;
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

    @Autowired
    SalonRepository salonRepository;


    public void addEmployeeFromDTO(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setPassword(passwordEncoder.encode(dto.getPassword()));
        employee.setRoles(dto.getRoles());

        // Hent og tilknyt salon hvis ID er medsendt
        if (dto.getSalonId() != null) {
            Salon salon = salonRepository.findById(dto.getSalonId());
            employee.setSalon(salon);
        }

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
