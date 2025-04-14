package com.example.barberbookingsystembackend.DTO;

import java.util.List;

public class CostumerDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private List<Long> salonIds;

    public CostumerDTO(String firstName, String lastName, String email, String phone, String password, List<Long> salonIds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.salonIds = salonIds;
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
    public List<Long> getSalonIds() {
        return salonIds;
    }
    public void setSalonIds(List<Long> salonIds) {
        this.salonIds = salonIds;
    }
}
