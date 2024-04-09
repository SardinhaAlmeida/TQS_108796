package HW1.unitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import HW1.model.Bus;
import HW1.repository.BusRepository;
import HW1.service.serviceImpl.BusServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BusService_UnitTest {

    @Mock(lenient = true)
    private BusRepository bus_repository;

    @InjectMocks
    private BusServiceImpl bus_service;

    @BeforeEach
    void setUp() {

        Bus bus1 = new Bus(1, "Viseu", "Aveiro", "2024-04-12", "20:00", "21:00", 10, 10);
        Bus bus3 = new Bus(3, "Porto", "Lisboa", "2024-04-12", "20:00", "23:00", 20, 5);
        Bus bus4 = new Bus(4, "Viseu", "Aveiro", "2024-04-12", "18:00", "19:00", 10, 10);

        List<Bus> buses = Arrays.asList(bus1, bus3, bus4);
        List<Bus> viseu_aveiro = Arrays.asList(bus1, bus4);

        Mockito.when(bus_repository.findByOriginAndDestinationAndDate("Viseu", "Aveiro", "2024-04-12"))
                .thenReturn(viseu_aveiro);
        Mockito.when(bus_repository.findByOriginAndDestinationAndDate("Lisboa", "Aveiro", "2024-04-11"))
                .thenReturn(null);
        Mockito.when(bus_repository.findByOriginAndDestinationAndDate("Porto", "Lisboa", "2024-04-12"))
                .thenReturn(Arrays.asList(bus3));
        Mockito.when(bus_repository.findByBusNumber(0)).thenReturn(null);
        Mockito.when(bus_repository.findByBusNumber(1)).thenReturn(bus1);
        Mockito.when(bus_repository.findByBusNumber(3)).thenReturn(bus3);
        Mockito.when(bus_repository.findByBusNumber(4)).thenReturn(bus4);
        Mockito.when(bus_repository.findAll()).thenReturn(buses);
    }

    @Test
    @DisplayName("Test getBuses for valid origin, destination and date")
    void testGetBusesForValidOriginDestinationAndDate() {
        List<Bus> buses = bus_service.getBuses("Viseu", "Aveiro", "2024-04-12");
        assertNotNull(buses);
        assertEquals(2, buses.size());
    }

    @Test
    @DisplayName("Test getBuses for invalid origin, destination and date")
    void testGetBusesForInvalidOriginDestinationAndDate() {
        List<Bus> buses = bus_service.getBuses("Lisboa", "Aveiro", "2024-04-11");
        assertEquals(null, buses);
    }

    @Test
    @DisplayName("Test getBuses for invalid origin and destination with valid date")
    void testGetBusesForInvalidOriginAndDestinationWithValidDate() {
        List<Bus> buses = bus_service.getBuses("Lisboa", "Porto", "2024-04-12");
        assertEquals(0, buses.size());
    }

    @Test
    @DisplayName("Test getBuses for valid origin, destination and null date")
    void testGetBusesForValidOriginDestinationAndNullDate() {
        List<Bus> buses = bus_service.getBuses("Viseu", "Aveiro", null);
        assertNotNull(buses);
        assertEquals(0, buses.size());
    }

    @Test
    @DisplayName("Test getBusByBusNumber for valid bus number")
    void testGetBusByBusNumberForValidBusNumber() {
        Bus bus = bus_service.getBusByBusNumber(1);
        assertNotNull(bus);
        assertEquals("Viseu", bus.getOrigin());
        assertEquals("Aveiro", bus.getDestination());
        assertEquals("2024-04-12", bus.getDate());
        assertEquals("20:00", bus.getDepartureTime());
        assertEquals("21:00", bus.getArrivalTime());
        assertEquals(10, bus.getPrice());
        assertEquals(10, bus.getCapacity());
    }

    @Test
    @DisplayName("Test getBusByBusNumber for invalid bus number")
    void testGetBusByBusNumberForInvalidBusNumber() {
        Bus bus = bus_service.getBusByBusNumber(0);
        assertEquals(null, bus);
    }

    @Test
    @DisplayName("Test getAll")
    void testGetAll() {
        List<Bus> buses = bus_service.getAll();
        assertNotNull(buses);
        assertEquals(3, buses.size());
    }

}
