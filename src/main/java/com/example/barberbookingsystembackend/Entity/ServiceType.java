package com.example.barberbookingsystembackend.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    private int durationInMinutes;

    @ManyToOne
    private Salon salon;

    @OneToMany(mappedBy = "serviceType")
    private List<Booking> bookings;
    public ServiceType() {
    }
    public ServiceType(String name, double price, int durationInMinutes, Salon salon) {
        this.name = name;
        this.price = price;
        this.durationInMinutes = durationInMinutes;
        this.salon = salon;

    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getDurationInMinutes() {
        return durationInMinutes;
    }
    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
}

