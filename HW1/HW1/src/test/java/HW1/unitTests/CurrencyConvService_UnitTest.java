package HW1.unitTests;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import HW1.service.serviceImpl.CurrencyConvServiceImpl;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CurrencyConvService_UnitTest {

    private MockWebServer mockWebServer;
    private CurrencyConvServiceImpl currency_service;

    @BeforeEach
    public void setup() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
        WebClient.Builder webClientBuilder = WebClient.builder().baseUrl(mockWebServer.url("/").toString());
        currency_service = new CurrencyConvServiceImpl(webClientBuilder, "fca_live_9aY7p7AAwwpAbk6CHHmnFj4VAeTNwyBhJ0GGgst8");
    }

    @AfterEach
    void tearDown() throws IOException {
        mockWebServer.shutdown();
    }


    @Test
    @DisplayName("Test getAllCurrencies")
    void testGetAllCurrencies() throws InterruptedException {
        String jsonResponse = "{ \"data\": { \"EUR\": { \"symbol\": \"€\", \"name\": \"Euro\", \"symbol_native\": \"€\", \"decimal_digits\": 2, \"rounding\": 0, \"code\": \"EUR\", \"name_plural\": \"Euros\", \"type\": \"fiat\" } } }";
    
        mockWebServer.enqueue(new MockResponse()
                .setBody(jsonResponse)
                .addHeader("Content-Type", "application/json"));
    
        Map<String, Object> result = currency_service.getAllCurrencies();
    
        assertNotNull(result);
        assertTrue(result.containsKey("data"));
    
        Map<String, Object> eurInfo = ((Map<String, Object>) result.get("data"));
        assertNotNull(eurInfo);
        Map<String, Object> eurInfo2 = ((Map<String, Object>) eurInfo.get("EUR"));
        assertNotNull(eurInfo2);
        assertEquals("€", eurInfo2.get("symbol"));
        assertEquals("Euro", eurInfo2.get("name"));
        assertEquals("€", eurInfo2.get("symbol_native"));
        assertEquals(2, eurInfo2.get("decimal_digits"));
        assertEquals(0, eurInfo2.get("rounding"));
        assertEquals("EUR", eurInfo2.get("code"));
        assertEquals("Euros", eurInfo2.get("name_plural"));
        assertEquals("fiat", eurInfo2.get("type"));
    }
    

    @Test
    @DisplayName("Test getExchange")
    void testGetExchange() throws InterruptedException {
        String jsonResponse = "{\"data\": {\"EUR\": 0.9206201352}}";
    
        mockWebServer.enqueue(new MockResponse()
                .setBody(jsonResponse)
                .addHeader("Content-Type", "application/json"));
    
        Map<String, Object> result = currency_service.getExchange("USD", "EUR");
    
        assertTrue(result.containsKey("data"));
        assertEquals(0.9206201352, ((Map<String, Object>) result.get("data")).get("EUR"));
    }
    
}

