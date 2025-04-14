package com.example.barberbookingsystembackend.Controller;

import com.example.barberbookingsystembackend.DTO.CostumerOrEmployeeLoginRequest;
import com.example.barberbookingsystembackend.Entity.Costumer;
import com.example.barberbookingsystembackend.DTO.SalonUpdateDTO;
import com.example.barberbookingsystembackend.Service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/costumer")
public class CostumerController {
    private static final Logger logger = LoggerFactory.getLogger(CostumerController.class);
    @Autowired
    private CostumerService costumerService;


    @PostMapping("/save")
    public ResponseEntity<String> addCostumer(@RequestBody Costumer costumer) {
        logger.info("Saving Costumer", costumer);
        costumerService.saveCostumer(costumer);
        logger.info("Costumer Saved", costumer);
        return ResponseEntity.ok("Costumer added successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CostumerOrEmployeeLoginRequest request) {
        logger.info("Login attempt for: {}", request.getEmail());
        try {
            String token = costumerService.login(request.getEmail(), request.getPassword());
            return ResponseEntity.ok().body(token);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    @PostMapping("/updateSalons/{costumerId}")
    public ResponseEntity<String> updateSalonsForCostumer(@PathVariable Long costumerId, @RequestBody SalonUpdateDTO request) {
        try {
            costumerService.updateSalonsForCostumer(costumerId, request.getSalonIdsToAdd(), request.getSalonIdsToRemove());
            return ResponseEntity.ok("Salons updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
