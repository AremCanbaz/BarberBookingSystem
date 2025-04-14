package com.example.barberbookingsystembackend.Service;

import com.example.barberbookingsystembackend.DTO.SalonDTO;
import com.example.barberbookingsystembackend.Entity.Salon;
import com.example.barberbookingsystembackend.Repository.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalonService {
    @Autowired
    private SalonRepository salonRepository;

    public void addSalon(SalonDTO salonDTO) {
        Salon salon = mapDtoToSalon(salonDTO);
        salonRepository.save(salon);
    }

    private Salon mapDtoToSalon(SalonDTO dto) {
        return new Salon(0, dto.getName(), dto.getAddress(), dto.getCity(),
                dto.getPostalCode(), dto.getPhone(), dto.getEmail());
    }
}
