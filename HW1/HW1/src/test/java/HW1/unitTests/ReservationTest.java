package HW1.unitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import HW1.model.Bus;
import HW1.model.Person;
import HW1.model.Reservation;

@ExtendWith(MockitoExtension.class)
public class ReservationTest {

    @Test
    @DisplayName("Test to reservation because excludes in pom not working")
    void testReservation() {
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

        Reservation reservation = new Reservation();

        reservation.setCreditCardNumber(1234567890123456L);
        reservation.setCreditCardMM(12L);
        reservation.setCreditCardYY(26L);
        reservation.setCreditCardCVV(123L);
        reservation.setPerson(joaquim);
        reservation.setBus(bus4);

        assertEquals(1234567890123456L, reservation.getCreditCardNumber().longValue());
        assertEquals(12L, reservation.getCreditCardMM().longValue());
        assertEquals(26L, reservation.getCreditCardYY().longValue());
        assertEquals(123L, reservation.getCreditCardCVV().longValue());
        assertEquals(joaquim, reservation.getPerson());
        assertEquals(bus4, reservation.getBus());

    }
}
