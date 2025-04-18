package com.example.barberbookingsystembackend.Repository;

import com.example.barberbookingsystembackend.Entity.Costumer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CostumerRepository extends CrudRepository<Costumer, Long> {

    Costumer findCostumerByEmail(String email);
}
