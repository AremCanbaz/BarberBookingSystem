package com.example.barberbookingsystembackend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.springframework.lang.Contract;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Service service;

    @ManyToOne
    private Costumer costumer;

}
