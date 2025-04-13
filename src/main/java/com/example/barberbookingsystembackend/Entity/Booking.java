package com.example.barberbookingsystembackend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private long id;
    private LocalDateTime date;


    @ManyToOne
    private Employee employee;

    @ManyToOne
    private ServiceType serviceType;

    @ManyToOne
    private Costumer costumer;

    public Booking() {
    }
    public Booking(LocalDateTime date, Employee employee, ServiceType serviceType, Costumer costumer) {
        this.date = date;
        this.employee = employee;
        this.serviceType = serviceType;
        this.costumer = costumer;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public ServiceType getServiceType() {
        return serviceType;
    }
    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
    public Costumer getCostumer() {
        return costumer;
    }
    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }
}
