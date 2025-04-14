package com.example.barberbookingsystembackend.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime date;


    @ManyToOne
    private Employee employee;

    @ManyToOne
    private ServiceType serviceType;

    @ManyToOne
    private Costumer costumer;

    @ManyToOne
    private Salon salon;

    public Booking() {
    }
    public Booking(LocalDateTime date, Employee employee, ServiceType serviceType, Costumer costumer, Salon salon) {
        this.date = date;
        this.employee = employee;
        this.serviceType = serviceType;
        this.costumer = costumer;
        this.salon = salon;
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
    public Salon getSalon() {
        return salon;
    }
    public void setSalon(Salon salon) {
        this.salon = salon;
    }
}
