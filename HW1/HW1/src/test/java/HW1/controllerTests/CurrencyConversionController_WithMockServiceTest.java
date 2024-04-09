package HW1.controllerTests;

import HW1.controller.CurrencyConversionController;
import HW1.service.CurrencyConvService;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;


@WebMvcTest(CurrencyConversionController.class)
public class CurrencyConversionController_WithMockServiceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CurrencyConvService currencyConversion_service;

    @Test
    void testGetAllCurrencies() throws Exception {

        Map<String, Object> currencies = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> eurCurrency = new HashMap<>();
        eurCurrency.put("symbol", "€");
        eurCurrency.put("name", "Euro");
        eurCurrency.put("symbol_native", "€");
        eurCurrency.put("decimal_digits", 2);
        eurCurrency.put("rounding", 0);
        eurCurrency.put("code", "EUR");
        eurCurrency.put("name_plural", "Euros");
        eurCurrency.put("type", "fiat");
        data.put("EUR", eurCurrency);
        currencies.put("data", data);

        when(currencyConversion_service.getAllCurrencies()).thenReturn(currencies);

        mvc.perform(get("/api/currencies")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.EUR").exists());
        
        verify(currencyConversion_service, times(1)).getAllCurrencies();
    }

    @Test
    public void testGetExchange() throws Exception {
        String fromCurrency = "EUR";
        String toCurrency = "USD";
    
        Map<String, Object> exchangeRates = new HashMap<>();
        Map<String, Object> data = new HashMap<>();

        data.put("USD", 1.0862243414);
        exchangeRates.put("data", data);
    
        when(currencyConversion_service.getExchange(fromCurrency, toCurrency)).thenReturn(exchangeRates);
    
        mvc.perform(get("/api/exchange")
                .param("from", fromCurrency)
                .param("to", toCurrency)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) 
                .andExpect(jsonPath("$.data." + toCurrency).value(1.0862243414)); 
    
        verify(currencyConversion_service, times(1)).getExchange(fromCurrency, toCurrency);
    }
    
}

