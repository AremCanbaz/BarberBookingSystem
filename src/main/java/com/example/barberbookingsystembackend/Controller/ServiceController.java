package com.example.barberbookingsystembackend.Controller;


import com.example.barberbookingsystembackend.Entity.ServiceType;
import com.example.barberbookingsystembackend.Service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/service")
public class ServiceController {

    private static final Logger logger = Logger.getLogger(ServiceController.class.getName());

    @Autowired
    private ServiceTypeService serviceTypeService;


    @PostMapping("/save")
    public ResponseEntity save(@RequestBody ServiceType serviceType) {
        logger.info("Saving service type: " + serviceType.getName());
        serviceTypeService.addService(serviceType);
        return ResponseEntity.ok("Service saved successfully");
    }
}
