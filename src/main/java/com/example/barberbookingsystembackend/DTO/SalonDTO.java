package com.example.barberbookingsystembackend.DTO;


public class SalonDTO {
    private String name;
    private String address;
    private String city;
    private int postalcode;
    private String phone;
    private String email;
    public SalonDTO() {}

    public SalonDTO(String name, String address, String city, int postalcode, String phone, String email) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.postalcode = postalcode;
        this.phone = phone;
        this.email = email;
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
        return postalcode;
    }
    public void setPostalCode(int postalcode) {
        this.postalcode = postalcode;
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

}
