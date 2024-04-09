package HW1.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HW1.service.CurrencyConvService;

@RestController
@RequestMapping("/api")
public class CurrencyConversionController {

    @Autowired
    private CurrencyConvService currencyConvService;

    @GetMapping("/currencies")
    public ResponseEntity<Map<String, Object>> getAllCurrencies() {
        Map<String, Object> currencies = currencyConvService.getAllCurrencies();
        return ResponseEntity.ok(currencies);
    }

    @GetMapping("/exchange")
    public ResponseEntity<Map<String, Object>> getExchange(@RequestParam String from, @RequestParam String to) {
        Map<String, Object> exchange = currencyConvService.getExchange(from, to);
        return ResponseEntity.ok(exchange);
    }

}