package HW1.service.serviceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

import HW1.service.CurrencyConvService;

@Service
public class CurrencyConvServiceImpl implements CurrencyConvService {

    private static final String CURRENCY_API_URL = "https://api.freecurrencyapi.com/v1";
    private final WebClient webClient;

    private final String apiKey;

    public CurrencyConvServiceImpl(WebClient.Builder webClientBuilder, @Value("${your.api.key}") String apiKey) {
        this.webClient = webClientBuilder.baseUrl(CURRENCY_API_URL).build();
        this.apiKey = apiKey;
    }

    @Override
    @Cacheable(value = "allCurrencies", cacheManager = "cacheManager")
    public Map<String, Object> getAllCurrencies() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/currencies").queryParam("apikey", apiKey).build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                .block();
    }

    @Override
    @Cacheable(value = "exchangeRates", key = "{#from, #to}", cacheManager = "cacheManager")
    public Map<String, Object> getExchange(String from, String to) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/latest").queryParam("apikey", apiKey).queryParam("base_currency", from).queryParam("currencies", to).build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                .block();
    }
}
