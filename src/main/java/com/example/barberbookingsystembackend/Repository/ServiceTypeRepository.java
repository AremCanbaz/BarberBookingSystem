package com.example.barberbookingsystembackend.Repository;

import com.example.barberbookingsystembackend.Entity.ServiceType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepository extends CrudRepository<ServiceType, Long> {


}
