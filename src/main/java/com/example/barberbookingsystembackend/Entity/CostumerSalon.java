package com.example.barberbookingsystembackend.Entity;

import jakarta.persistence.*;

@Entity
public class CostumerSalon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Costumer costumer;

    @ManyToOne
    private Salon salon;

    public CostumerSalon() {
    }
    public CostumerSalon(Costumer costumer, Salon salon) {
        this.costumer = costumer;
        this.salon = salon;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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
