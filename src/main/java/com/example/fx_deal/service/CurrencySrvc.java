package com.example.fx_deal.service;
import com.example.fx_deal.model.Currency;
import com.example.fx_deal.model.CurrencyResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencySrvc {
    private static final String CURRENCY_API_URL = "https://api.exchangerate-api.com/v4/latest/USD"; // Example API
    private static final Logger logger = LoggerFactory.getLogger(CurrencySrvc.class);

    public List<Currency> getAllCurrencies() {

        logger.info("Fetching all currencies");

        RestTemplate restTemplate = new RestTemplate();
        try {
            CurrencyResponse response = restTemplate.getForObject(CURRENCY_API_URL, CurrencyResponse.class);
            return response.getRates().entrySet().stream()
                    .map(entry -> new Currency(entry.getKey(), entry.getValue()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("Error fetching currencies", e);
            return new ArrayList<>(0);
        }
    }
}
