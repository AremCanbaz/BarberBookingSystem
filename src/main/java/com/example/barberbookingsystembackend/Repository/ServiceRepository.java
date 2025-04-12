package com.example.barberbookingsystembackend.Repository;

import com.example.barberbookingsystembackend.Entity.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends CrudRepository<Service, Long> {
}
