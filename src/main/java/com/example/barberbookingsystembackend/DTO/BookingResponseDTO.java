package com.example.barberbookingsystembackend.DTO;

import java.time.LocalDateTime;
import java.util.Date;

public class BookingResponseDTO {
    private Long bookingId;
    private String customerName;
    private String employeeName;
    private String serviceName;
    private LocalDateTime date;

    public BookingResponseDTO(Long bookingId, String customerName, String employeeName, String serviceName, LocalDateTime date) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.employeeName = employeeName;
        this.serviceName = serviceName;
        this.date = date;
    }

    public BookingResponseDTO() {
    }

    public Long getBookingId() {
        return bookingId;
    }
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getServiceName() {
        return serviceName;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
