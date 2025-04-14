    package com.example.barberbookingsystembackend.Entity;

    import jakarta.persistence.*;

    import java.util.List;

    @Entity
    public class Costumer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String firstName;
        private String lastName;
        @Column(unique=true)
        private String email;
        private String phone;
        private String password;

        @OneToMany(mappedBy = "costumer")
        private List<Booking> bookings;

        @OneToMany(mappedBy = "costumer")
        private List<CostumerSalon> salonRelation;



        public Costumer() {
        }
        public Costumer(String firstName, String lastName, String email, String phone, String password) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phone = phone;
            this.password = password;
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
        public List<Booking> getBookings() {
            return bookings;
        }
        public void setBookings(List<Booking> bookings) {
            this.bookings = bookings;
        }
        public List<CostumerSalon> getSalonRelation() {
            return salonRelation;
        }
        public void setSalonRelation(List<CostumerSalon> salonRelation) {
            this.salonRelation = salonRelation;
        }
    }
