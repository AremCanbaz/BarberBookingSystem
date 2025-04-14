package com.example.barberbookingsystembackend.Controller;

import com.example.barberbookingsystembackend.DTO.SalonDTO;
import com.example.barberbookingsystembackend.Entity.Salon;
import com.example.barberbookingsystembackend.Service.SalonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/salon")
public class SalonController {
    private static final Logger logger = LoggerFactory.getLogger(SalonController.class);
    @Autowired
    SalonService salonService;

    @PostMapping("/save")
    public ResponseEntity<String> addSalon(@RequestBody SalonDTO dto) {
        salonService.addSalon(dto);
        logger.info("Salon saved");
        return ResponseEntity.ok("Salon saved");
    }

}
