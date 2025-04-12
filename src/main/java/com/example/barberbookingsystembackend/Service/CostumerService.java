package com.example.barberbookingsystembackend.Service;

import com.example.barberbookingsystembackend.Repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.barberbookingsystembackend.Service.JwtSerivce;

@Service
public class CostumerService {
    @Autowired
    private CostumerRepository costumerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtSerivce jwtSerivce;
}
