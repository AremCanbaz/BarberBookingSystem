package com.example.barberbookingsystembackend;

import com.example.barberbookingsystembackend.Controller.BookingController;
import com.example.barberbookingsystembackend.DTO.BookingResponseDTO;
import com.example.barberbookingsystembackend.Entity.Costumer;
import com.example.barberbookingsystembackend.Service.BookingService;
import com.example.barberbookingsystembackend.Service.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookingController.class)
public class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingService bookingService;

    private JwtService jwtService;
    private String jwtToken;

    @BeforeEach
    void setUp() {
        // Mock Costumer
        Costumer mockCostumer = new Costumer();
        mockCostumer.setId(1L);
        mockCostumer.setEmail("test@example.com");
        mockCostumer.setFirstName("John");

        // Initialiser JwtService og sæt SECRET_KEY
        jwtService = new JwtService();
        String base64Key = java.util.Base64.getEncoder().encodeToString("hemmelignøglehemmelignøgle".getBytes());
        ReflectionTestUtils.setField(jwtService, "SECRET_KEY", base64Key);

        // Generér token
        jwtToken = jwtService.generateToken(mockCostumer);
    }

    @Test
    public void testGetBookingsWithJwt() throws Exception {
        Long employeeId = 1L;
        LocalDate date = LocalDate.of(2025, 10, 15);

        BookingResponseDTO booking = new BookingResponseDTO();
        booking.setEmployeeName("John");
        booking.setCustomerName("Tester");
        booking.setServiceName("Klipning");
        booking.setDate(LocalDateTime.of(2025, 10, 15, 10, 0));

        when(bookingService.getBookingsForEmployeeOnDate(employeeId, date))
                .thenReturn(Collections.singletonList(booking));

        mockMvc.perform(get("/bookings/employee/1/date/2025-10-15")
                        .header("Authorization", "Bearer " + jwtToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].employeeName").value("John"))
                .andExpect(jsonPath("$[0].customerName").value("Tester"))
                .andExpect(jsonPath("$[0].serviceName").value("Klipning"));
    }
}
