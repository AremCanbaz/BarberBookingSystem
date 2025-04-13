package com.example.barberbookingsystembackend.Service;

import com.example.barberbookingsystembackend.Entity.ServiceType;
import com.example.barberbookingsystembackend.Repository.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService {

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    public void addService(ServiceType serviceType) {
        serviceTypeRepository.save(serviceType);
    }
    public List<ServiceType> getAllServiceTypes() {
        return (List<ServiceType>) serviceTypeRepository.findAll();
    }


}
