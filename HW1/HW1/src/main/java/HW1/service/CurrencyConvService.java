package HW1.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface CurrencyConvService {

    public Map<String, Object> getAllCurrencies();
    public Map<String, Object> getExchange(String from, String to);
}
