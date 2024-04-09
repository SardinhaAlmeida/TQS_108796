package HW1.integrationTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import HW1.model.Bus;
import HW1.model.Person;
import HW1.model.Reservation;
import HW1.repository.BusRepository;
import HW1.repository.PersonRepository;
import HW1.repository.ReservationRepository;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class ReservationControllerIT {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private BusRepository bus_repository;

    @Autowired
    private PersonRepository person_repository;

    @Autowired
    private ReservationRepository reservation_repository;

    private Bus bus3;
    private Person jose;

    @AfterEach
    void resetDb() {
        reservation_repository.deleteAll();
        person_repository.deleteAll();
        bus_repository.deleteAll();
    }

    @BeforeEach
    void setUp() {

        bus3 = new Bus(3, "Porto", "Lisboa", "2024-04-12", "20:00", "23:00", 20, 5);
        bus3 = bus_repository.save(bus3);

        jose = new Person(
                3L,
                "José",
                "Manel",
                "jose.manel@example.com",
                "1234565243",
                "Rua da Alegria 123",
                "Viseu",
                "3660-123",
                "Portugal");
        jose = person_repository.save(jose);

    }

    @Test
    @DisplayName("Test fillData endpoint")
    void testFillDataEndpoint() throws Exception {

        // Perform a mock HTTP POST request to the fillData endpoint
        mvc.perform(post("/api/details")
                .param("busNumber", "3")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andExpect(view().name("personal"))
                .andExpect(model().attributeExists("bus"));

    }

    @Test
    @DisplayName("Test bookReservation endpoint")
    void testBookReservationEndpoint() throws Exception {

        // Perform a mock HTTP POST request to the bookReservation endpoint
        mvc.perform(post("/api/reservation")
                .param("creditCardNumber", "1234567890")
                .param("creditCardMM", "12")
                .param("creditCardYY", "24")
                .param("creditCardCVV", "123")
                .param("busNumber", "3")
                .param("personId", "3")
                .param("name", "José")
                .param("surname", "Manel")
                .param("email", "jose.manel@example.com")
                .param("phoneNumber", "1234565243")
                .param("address", "Rua da Alegria 123")
                .param("city", "Viseu")
                .param("postalCode", "3660-123")
                .param("country", "Portugal")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andExpect(view().name("reservation"))
                .andExpect(model().attributeExists("token"));
    }

    @Test
    @DisplayName("Test getReservations endpoint")
    void testGetReservationsEndpoint() throws Exception {
        mvc.perform(post("/api/reservation/check")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andExpect(view().name("check"));
    }

    @Test
    @DisplayName("Test getReservations endpoint with valid token")
    void testGetReservationsEndpointWithValidToken() throws Exception {
        Reservation reservation2 = new Reservation(
            1234567890123456L, 
            12L, 
            25L, 
            123L, 
            jose, 
            bus3        
        );
        reservation2.setToken(UUID.randomUUID().toString());

        reservation_repository.save(reservation2);
    
        String validToken = reservation2.getToken();
        mvc.perform(get("/api/reservation/check")
                .param("token", validToken)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", notNullValue()));
    }
    
    @Test
    @DisplayName("Test getReservations endpoint with invalid token")
    void testGetReservationsEndpointWithInvalidToken() throws Exception {
    
        String invalidToken = "123";
        mvc.perform(get("/api/reservation/check")
                .param("token", invalidToken)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isNotFound()); 
        }

}
