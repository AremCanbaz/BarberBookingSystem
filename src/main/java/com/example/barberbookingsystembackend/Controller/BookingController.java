package com.example.barberbookingsystembackend.Controller;

import com.example.barberbookingsystembackend.DTO.BookingRequestDTO;
import com.example.barberbookingsystembackend.DTO.BookingResponseDTO;
import com.example.barberbookingsystembackend.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody BookingRequestDTO dto) {
        return ResponseEntity.ok(bookingService.createBooking(dto));
    }

    @GetMapping("/employee/{id}/date/{date}")
    public ResponseEntity<List<BookingResponseDTO>> getBookings(
            @PathVariable Long id,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return ResponseEntity.ok(bookingService.getBookingsForEmployeeOnDate(id, date));
    }
}

