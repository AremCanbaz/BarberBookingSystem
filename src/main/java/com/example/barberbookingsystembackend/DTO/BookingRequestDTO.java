package com.example.barberbookingsystembackend.DTO;

import java.time.LocalDateTime;
import java.util.Date;

public class BookingRequestDTO {
    private Long customerId;
    private Long employeeId;
    private Long serviceTypeId;
    private LocalDateTime date;

    public BookingRequestDTO() {
    }
    public BookingRequestDTO(Long customerId, Long employeeId, Long serviceTypeId, LocalDateTime date) {
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.serviceTypeId = serviceTypeId;
        this.date = date;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
    public Long getServiceTypeId() {
        return serviceTypeId;
    }
    public void setServiceTypeId(Long serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
