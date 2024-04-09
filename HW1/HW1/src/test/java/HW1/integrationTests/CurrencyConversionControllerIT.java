package HW1.integrationTests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class CurrencyConversionControllerIT {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Test getAllCurencies endpoint")
    void testGetAllCurrencies() throws Exception {
        mvc.perform(get("/api/currencies")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.size()").value(33));
    }

    @Test
    @DisplayName("Test getExchange endpoint")
    void testGetExchange() throws Exception {
        String fromCurrency = "USD";
        String toCurrency = "EUR";
    
        mvc.perform(get("/api/exchange")
                .param("from", fromCurrency)
                .param("to", toCurrency)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data." + toCurrency).exists())
                .andExpect(jsonPath("$.data." + toCurrency).isNumber());

    }
}
