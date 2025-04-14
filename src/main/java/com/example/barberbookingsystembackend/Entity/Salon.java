package com.example.barberbookingsystembackend.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String city;
    private int postalCode;
    private String phone;
    private String email;

    @OneToMany(mappedBy = "salon")
    private List<Employee> employees;

    @OneToMany(mappedBy = "salon")
    private List<ServiceType> serviceTypes;;

    @OneToMany(mappedBy = "salon")
    private List<CostumerSalon> costumerSalons;
    public Salon() {}
    public Salon(long id, String name, String address, String city, int postalCode, String phone, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.phone = phone;
        this.email = email;
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public int getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    public List<ServiceType> getServiceTypes() {
        return serviceTypes;
    }
    public void setServiceTypes(List<ServiceType> serviceTypes) {
        this.serviceTypes = serviceTypes;
    }
    public List<CostumerSalon> getCostumerSalons() {
        return costumerSalons;
    }
    public void setCostumerSalons(List<CostumerSalon> costumerSalons) {
        this.costumerSalons = costumerSalons;
    }



}
