package HW1.unitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import HW1.model.Bus;
import HW1.model.Person;
import HW1.model.Reservation;
import HW1.repository.ReservationRepository;
import HW1.service.serviceImpl.ReservationServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ReservationService_UnitTest {

    @Mock(lenient = true)
    private ReservationRepository reservation_repository;

    @InjectMocks
    private ReservationServiceImpl reservation_service;

    @BeforeEach
    void setUp(){
        
        Bus bus3 = new Bus(3, "Porto", "Lisboa", "2024-04-12", "20:00", "23:00", 20, 5);
        Bus bus4 = new Bus(4, "Viseu", "Aveiro", "2024-04-12", "18:00", "19:00", 10, 10);

        Person maria = new Person(
                1L, 
                "Maria",
                "Joana", 
                "maria.joana@example.com", 
                "1234567890",
                "Rua da Alegria 123", 
                "Viseu", 
                "3660-123", 
                "Portugal" 
        );

        Person joaquim = new Person(
                "Joaquim",
                "Manuel", 
                "joao@gmail.com",
                "9876543210",
                "Rua da Tristeza 321",
                "Porto",
                "4000-123",
                "Portugal"
        );
        joaquim.setPersonId(2L);
        
        Reservation reservation1 = new Reservation();
        reservation1.setId(1L);
        reservation1.setToken(UUID.randomUUID().toString());

        Reservation reservation2 = new Reservation(
            1234567890123456L, 
            12L, 
            25L, 
            123L, 
            maria, 
            bus3        
        );
        reservation2.setId(2L);
        reservation2.setToken(UUID.randomUUID().toString());

        Reservation reservation3 = new Reservation(
            1234567890321654L, 
            11L, 
            24L, 
            132L, 
            joaquim, 
            bus4
        );
        reservation3.setId(3L);
        reservation3.setToken(UUID.randomUUID().toString());

        Mockito.when(reservation_repository.save(reservation1)).thenReturn(reservation1);
        Mockito.when(reservation_repository.save(reservation2)).thenReturn(reservation2);
        Mockito.when(reservation_repository.save(reservation3)).thenReturn(reservation3);
        Mockito.when(reservation_repository.findByToken(reservation1.getToken()))
                .thenReturn(Optional.of(reservation1));
        Mockito.when(reservation_repository.findByToken(reservation2.getToken()))
                .thenReturn(Optional.of(reservation2));
        Mockito.when(reservation_repository.findByToken(reservation3.getToken()))
                .thenReturn(Optional.of(reservation3));
        Mockito.when(reservation_repository.findByToken("invalid_token"))
                .thenReturn(null);
        
    }

    @Test
    @DisplayName("Test makeReservation")
    void testMakeReservation() {
        Reservation reservation = new Reservation();
        String token = reservation_service.makeReservation(reservation);
        verify(reservation_repository).save(eq(reservation));
        assertNotNull(token);
    }

    @Test
    @DisplayName("Test getReservation for valid token")
    void testGetReservationForValidToken() {

        Bus bus4 = new Bus(4, "Viseu", "Aveiro", "2024-04-12", "18:00", "19:00", 10, 10);

        Person joaquim = new Person(
            "Joaquim",
            "Manuel", 
            "joao@gmail.com",
            "9876543210",
            "Rua da Tristeza 321",
            "Porto",
            "4000-123",
            "Portugal"
        );
        joaquim.setPersonId(2L);

        Reservation mock = new Reservation(
            1234567890321654L, 
            11L, 
            24L, 
            132L, 
            joaquim, 
            bus4
        );
        mock.setId(4L);
        mock.setToken(UUID.randomUUID().toString());          

        String token = mock.getToken();
        Reservation reservation = reservation_service.getReservation(token).orElse(null);

        verify(reservation_repository).findByToken(token);
    }

    @Test
    @DisplayName("Test getReservation for invalid token")
    void testGetReservationForInvalidToken() {
        assertEquals(null, reservation_service.getReservation("invalid_token"));
    }
    
}
