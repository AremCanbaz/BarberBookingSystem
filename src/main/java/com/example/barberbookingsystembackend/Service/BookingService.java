package com.example.barberbookingsystembackend.Service;

import com.example.barberbookingsystembackend.DTO.BookingRequestDTO;
import com.example.barberbookingsystembackend.DTO.BookingResponseDTO;
import com.example.barberbookingsystembackend.Entity.Booking;
import com.example.barberbookingsystembackend.Entity.Costumer;
import com.example.barberbookingsystembackend.Entity.Employee;
import com.example.barberbookingsystembackend.Entity.ServiceType;
import com.example.barberbookingsystembackend.Repository.BookingRepository;
import com.example.barberbookingsystembackend.Repository.CostumerRepository;
import com.example.barberbookingsystembackend.Repository.EmployeeRepository;
import com.example.barberbookingsystembackend.Repository.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private CostumerRepository costumerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public BookingResponseDTO createBooking(BookingRequestDTO dto) {
        Costumer costumer = costumerRepository.findById(dto.getCustomerId()).orElseThrow();
        Employee employee = employeeRepository.findById(dto.getEmployeeId()).orElseThrow();
        ServiceType serviceType = serviceTypeRepository.findById(dto.getServiceTypeId()).orElseThrow();

        Booking booking = new Booking();
        booking.setCostumer(costumer);
        booking.setEmployee(employee);
        booking.setServiceType(serviceType);
        booking.setDate(dto.getDate());

        Booking saved = bookingRepository.save(booking);

        return new BookingResponseDTO(
                saved.getId(),
                costumer.getFirstName() + " " + costumer.getLastName(),
                employee.getFirstName() + " " + employee.getLastName(),
                serviceType.getName(),
                saved.getDate()
        );
    }

    // f.eks. hente bookinger på en given dag for en frisør
    public List<BookingResponseDTO> getBookingsForEmployeeOnDate(Long employeeId, LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(LocalTime.MAX);

        List<Booking> bookings = bookingRepository.findByEmployeeIdAndDateBetween(employeeId, startOfDay, endOfDay);

        return bookings.stream()
                .map(this::mapToResponseDTO) // map til BookingResponseDTO
                .collect(Collectors.toList());
    }

    private BookingResponseDTO mapToResponseDTO(Booking booking) {
        return new BookingResponseDTO(
                booking.getId(),
                booking.getCostumer().getFirstName() + " " + booking.getCostumer().getLastName(),
                booking.getEmployee().getFirstName() + " " + booking.getEmployee().getLastName(),
                booking.getServiceType().getName(),
                booking.getDate() // direkte brug af LocalDateTime
        );
    }
}

