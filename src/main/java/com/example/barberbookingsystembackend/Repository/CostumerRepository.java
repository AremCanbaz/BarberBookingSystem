package com.example.barberbookingsystembackend.Repository;

import com.example.barberbookingsystembackend.Entity.Costumer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostumerRepository extends CrudRepository<Costumer, Long> {
}
