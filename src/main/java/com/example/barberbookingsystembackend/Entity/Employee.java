package com.example.barberbookingsystembackend.Entity;

import com.example.barberbookingsystembackend.Enum.Roles;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique=true)
    private String email;
    private String phone;
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles roles;
    @ManyToOne
    private Salon salon;
    @ManyToMany
    @JoinTable(
            name = "employee_servicetype",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "servicetype_id")
    )
    private List<ServiceType> serviceTypes;
    @OneToMany(mappedBy = "employee")
    private List<Booking> bookings;
    public Employee() {
    }
    public Employee (String firstName, String lastName, String email, String phone, String password, Roles roles, Salon salon){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.roles = roles;
        this.salon = salon;
    }
    public Employee(String firstName, String lastName, String email, String phone, String password, Roles roles, Salon salon, List<ServiceType> serviceTypes, List<Booking> bookings) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.roles = roles;
        this.salon = salon;
        this.serviceTypes = serviceTypes;
        this.bookings = bookings;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Roles getRoles() {
        return roles;
    }
    public void setRoles(Roles roles) {
        this.roles = roles;
    }
    public Salon getSalon() {
        return salon;
    }
    public void setSalon(Salon salon) {
        this.salon = salon;
    }
    public List<ServiceType> getServiceTypes() {
        return serviceTypes;
    }
    public void setServiceTypes(List<ServiceType> serviceTypes) {
        this.serviceTypes = serviceTypes;
    }
    public List<Booking> getBookings() {
        return bookings;
    }
    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
