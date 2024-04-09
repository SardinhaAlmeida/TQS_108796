package HW1.controllerTests;

import HW1.controller.ReservationController;
import HW1.model.Bus;
import HW1.model.Person;
import HW1.model.Reservation;
import HW1.service.BusService;
import HW1.service.PersonService;
import HW1.service.ReservationService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.notNullValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@WebMvcTest(ReservationController.class)
public class ReservationController_WithMockServiceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ReservationService reservation_service;

    @MockBean
    private BusService bus_service;

    @MockBean
    private PersonService person_service;

    private Bus bus4;
    private Person jose;
    private Reservation reservation;

    @BeforeEach
    void setUp() {
        bus4 = new Bus(4, "Porto", "Lisboa", "2024-04-12", "20:00", "23:00", 20, 5);

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

        reservation = new Reservation(
                1234567890123456L,
                12L,
                25L,
                123L,
                jose,
                bus4);
        reservation.setId(1L);
        reservation.setToken("validToken");

    }

    @Test
    @DisplayName("Test fillData")
    void testFillData() throws Exception {

        when(bus_service.getBusByBusNumber(4)).thenReturn(bus4);

        mvc.perform(post("/api/details")
                .param("busNumber", "4")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("personal"))
                .andExpect(model().attributeExists("bus"))
                .andExpect(model().attribute("bus", bus4));

        verify(bus_service, times(1)).getBusByBusNumber(4);

    }

    @Test
    @DisplayName("Test checkView")
    void testCheckView() throws Exception {

        mvc.perform(post("/api/reservation/check")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andExpect(view().name("check"));
    }


    @Test
    @DisplayName("Test bookReservation")
    void testBookReservation() throws Exception {
        // Mocking the PersonService to return a saved person
        when(person_service.savePerson(any(Person.class))).thenReturn(jose);

        // Mocking the BusService to return a bus
        when(bus_service.getBusByBusNumber(4)).thenReturn(bus4);

        // Mocking the ReservationService to return a token
        when(reservation_service.makeReservation(any(Reservation.class))).thenReturn("validToken");

        mvc.perform(post("/api/reservation")
                .param("creditCardNumber", "1234567890")
                .param("creditCardMM", "12")
                .param("creditCardYY", "25")
                .param("creditCardCVV", "123")
                .param("busNumber", "4")
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
                .andExpect(model().attributeExists("token"))
                .andExpect(model().attribute("token", "validToken"));

        verify(person_service, times(1)).savePerson(any(Person.class));
        verify(bus_service, times(2)).getBusByBusNumber(4);
        verify(reservation_service, times(1)).makeReservation(any(Reservation.class));
    }

    @Test
    @DisplayName("Test getReservation with valid token")
    void testGetReservationWithValidToken() throws Exception {

        when(reservation_service.getReservation("validToken")).thenReturn(Optional.of(reservation));

        mvc.perform(get("/api/reservation/check")
                .param("token", "validToken")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", notNullValue()));

        verify(reservation_service, times(1)).getReservation("validToken");
    }

    @Test
    @DisplayName("Test getReservation with invalid token")
    void testGetReservationWithInvalidToken() throws Exception {

        when(reservation_service.getReservation(anyString())).thenReturn(Optional.empty());

        mvc.perform(get("/api/reservation/check")
                .param("token", "invalidToken")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(reservation_service, times(1)).getReservation("invalidToken");
    }

}