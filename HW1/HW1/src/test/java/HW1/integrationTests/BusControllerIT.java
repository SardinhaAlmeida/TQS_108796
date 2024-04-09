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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.Matchers.*;

import HW1.model.Bus;
import HW1.repository.BusRepository;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class BusControllerIT {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private BusRepository bus_repository;

    @AfterEach
    public void resetDb() {
        bus_repository.deleteAll();
    }

    @BeforeEach
    void setUp() {
        Bus bus1 = new Bus(1, "Viseu", "Aveiro", "2024-04-12", "20:00", "21:00", 10, 10);
        bus_repository.save(bus1);
    }

    @Test
    @DisplayName("Test home endpoint")
    void testHomeEndpoint() throws Exception {
        // Perform a mock HTTP GET request to the home endpoint
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    @DisplayName("Test searchBuses endpoint")
    void testSearchBusesEndpoint() throws Exception {

            // Perform a mock HTTP POST request to the searchBuses endpoint
            mvc.perform(post("/api/bus")
                    .param("origin", "Viseu")
                    .param("destination", "Aveiro")
                    .param("date", "2024-04-12")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                    .andExpect(status().isOk())
                    .andExpect(view().name("table"))
                    .andExpect(model().attributeExists("buses"))
                    .andExpect(model().attribute("buses", hasSize(1)))
                    .andExpect(model().attribute("buses", hasItem(
                            allOf(
                                    hasProperty("busNumber", is(1)),
                                    hasProperty("origin", is("Viseu")),
                                    hasProperty("destination", is("Aveiro")),
                                    hasProperty("date", is("2024-04-12")),
                                    hasProperty("departureTime", is("20:00")),
                                    hasProperty("arrivalTime", is("21:00")),
                                    hasProperty("price", is(10)),
                                    hasProperty("capacity", is(10))))));
    }

}
