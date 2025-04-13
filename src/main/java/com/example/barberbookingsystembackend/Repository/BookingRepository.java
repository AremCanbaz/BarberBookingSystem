package com.example.barberbookingsystembackend.Repository;

import com.example.barberbookingsystembackend.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByEmployeeIdAndDateBetween(Long employeeId, LocalDateTime start, LocalDateTime end);
}
