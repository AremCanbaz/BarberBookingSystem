package com.example.barberbookingsystembackend.DTO;

public class CostumerOrEmployeeLoginRequest {
    private String email;
    private String password;


    public CostumerOrEmployeeLoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public CostumerOrEmployeeLoginRequest(){}
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
