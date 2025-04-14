package com.example.barberbookingsystembackend.DTO;

import java.util.Set;

public class SalonUpdateDTO {
    private Set<Long> salonIdsToAdd;
    private Set<Long> salonIdsToRemove;

    public SalonUpdateDTO(Set<Long> salonIdsToAdd, Set<Long> salonIdsToRemove) {
        this.salonIdsToAdd = salonIdsToAdd;
        this.salonIdsToRemove = salonIdsToRemove;
    }
    public SalonUpdateDTO() {
    }
    public Set<Long> getSalonIdsToAdd() {
        return salonIdsToAdd;
    }
    public void setSalonIdsToAdd(Set<Long> salonIdsToAdd) {
        this.salonIdsToAdd = salonIdsToAdd;
    }
    public Set<Long> getSalonIdsToRemove() {
        return salonIdsToRemove;
    }
    public void setSalonIdsToRemove(Set<Long> salonIdsToRemove) {
        this.salonIdsToRemove = salonIdsToRemove;
    }

}
