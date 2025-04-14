package com.example.barberbookingsystembackend.Service;

import com.example.barberbookingsystembackend.DTO.CostumerDTO;
import com.example.barberbookingsystembackend.Entity.Costumer;
import com.example.barberbookingsystembackend.Entity.CostumerSalon;
import com.example.barberbookingsystembackend.Entity.Salon;
import com.example.barberbookingsystembackend.Repository.CostumerRepository;
import com.example.barberbookingsystembackend.Repository.CostumerSalonRepository;
import com.example.barberbookingsystembackend.Repository.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CostumerService {
    @Autowired
    private CostumerRepository costumerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtSerivce;

    @Autowired
    private SalonRepository salonRepository;

    @Autowired
    private CostumerSalonRepository costumerSalonRepository;

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

    public void updateSalonsForCostumer(Long costumerId, Set<Long> salonIdsToAdd, Set<Long> salonIdsToRemove) {
        Optional<Costumer> costumerOptional = costumerRepository.findById(costumerId);

        // Hvis kunden ikke findes, kast en fejl
        if (costumerOptional.isEmpty()) {
            throw new RuntimeException("Kunden findes ikke");
        }

        Costumer costumer = costumerOptional.get();

        // Tilføj de ønskede saloner
        for (Long salonId : salonIdsToAdd) {
            Optional<Salon> salonOptional = Optional.ofNullable(salonRepository.findById(salonId));
            salonOptional.ifPresent(salon -> {
                CostumerSalon costumerSalon = new CostumerSalon(costumer, salon);
                costumerSalonRepository.save(costumerSalon); // Tilføj salon-relationen til database
            });
        }

        // Fjern de ønskede saloner
        for (Long salonId : salonIdsToRemove) {
            Optional<Salon> salonOptional = Optional.ofNullable(salonRepository.findById(salonId));
            salonOptional.ifPresent(salon -> {
                CostumerSalon costumerSalon = costumerSalonRepository.findByCostumerAndSalon(costumer, salon);
                if (costumerSalon != null) {
                    costumerSalonRepository.delete(costumerSalon); // Fjern salon-relationen fra database
                }
            });
        }
    }
}
