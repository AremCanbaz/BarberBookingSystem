package com.example.barberbookingsystembackend.Repository;

import com.example.barberbookingsystembackend.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
