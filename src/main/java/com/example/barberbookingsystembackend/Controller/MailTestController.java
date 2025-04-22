package com.example.barberbookingsystembackend.Controller;
import com.example.barberbookingsystembackend.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/testmail")
public class MailTestController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send")
    public ResponseEntity<String> sendTestMail() {
        emailService.sendSimpleEmail(
                "arem_canbaz@icloud.com",
                "Testmail fra BarberBookingSystem",
                "Hej! Dette er en test e-mail"
        );
        return ResponseEntity.ok("E-mail sendt!");
    }
}

