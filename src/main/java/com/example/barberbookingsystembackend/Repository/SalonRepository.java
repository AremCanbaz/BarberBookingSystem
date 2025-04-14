package com.example.barberbookingsystembackend.Repository;

import com.example.barberbookingsystembackend.Entity.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Integer> {

    Salon findById(long id);

}
