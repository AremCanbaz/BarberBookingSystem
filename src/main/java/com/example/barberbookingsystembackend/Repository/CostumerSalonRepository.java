package com.example.barberbookingsystembackend.Repository;

import com.example.barberbookingsystembackend.Entity.Costumer;
import com.example.barberbookingsystembackend.Entity.CostumerSalon;
import com.example.barberbookingsystembackend.Entity.Salon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerSalonRepository extends JpaRepository<CostumerSalon, Integer> {

    CostumerSalon findByCostumerAndSalon(Costumer costumer, Salon salon);
}
