package HW1.controllerTests;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import HW1.controller.BusController;
import HW1.model.Bus;
import HW1.service.BusService;

@WebMvcTest(BusController.class)
public class BusController_WithMockServiceTest {

    @Autowired
    private MockMvc mvc;  

    @MockBean
    private BusService bus_service;

    @Test
    void testSearchBuses() throws Exception{

        Bus bus3 = new Bus(3, "Porto", "Lisboa", "2024-04-12", "20:00", "23:00", 20, 5);
        Bus bus4 = new Bus(4, "Viseu", "Aveiro", "2024-04-12", "18:00", "19:00", 10, 10);

        List<Bus> buses = Arrays.asList(bus3, bus4);

        when(bus_service.getBuses(anyString(), anyString(), anyString())).thenReturn(buses);

        mvc.perform(post("/api/bus")
                .param("origin", "Origin1")
                .param("destination", "Destination1")
                .param("date", "2024-04-09"))
                .andExpect(status().isOk())
                .andExpect(view().name("table"))
                .andExpect(model().attributeExists("buses"))
                .andExpect(model().attribute("buses", buses));

        verify(bus_service, times(1)).getBuses("Origin1", "Destination1", "2024-04-09");

    }

    @Test
    void testConfirmView() throws Exception {

        mvc.perform(get("/")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
    
}
