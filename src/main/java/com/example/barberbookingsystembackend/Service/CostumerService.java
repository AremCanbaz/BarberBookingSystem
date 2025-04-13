package com.example.barberbookingsystembackend.Service;

import com.example.barberbookingsystembackend.Entity.Costumer;
import com.example.barberbookingsystembackend.Repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CostumerService {
    @Autowired
    private CostumerRepository costumerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtSerivce;

    public void saveCostumer(Costumer costumer) {
        String encodedPassword = passwordEncoder.encode(costumer.getPassword());
        costumer.setPassword(encodedPassword);
        costumerRepository.save(costumer);
    }

    public String login(String email, String rawPassword) {
        Optional<Costumer> optionalCostumer = Optional.ofNullable(costumerRepository.findCostumerByEmail(email));

        Costumer costumer = optionalCostumer.orElseThrow(() ->
                new RuntimeException("Email-adressen findes ikke"));

        if (!passwordEncoder.matches(rawPassword, costumer.getPassword())) {
            throw new RuntimeException("Forkert adgangskode");
        }

        return jwtSerivce.generateToken(costumer);
    }
}
