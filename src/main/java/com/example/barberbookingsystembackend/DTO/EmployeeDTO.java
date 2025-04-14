package com.example.barberbookingsystembackend.DTO;

import com.example.barberbookingsystembackend.Enum.Roles;

public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private Roles roles;
    private Long salonId;
    public EmployeeDTO() {}
    public EmployeeDTO(String firstName, String lastName, String email, String phone, String password, Roles roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.roles = roles;

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
    public Long getSalonId() {
        return salonId;
    }
    public void setSalonId(Long salonId) {
        this.salonId = salonId;
    }
}
