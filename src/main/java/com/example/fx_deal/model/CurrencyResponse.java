package com.example.fx_deal.model;
import java.util.Map;

public class CurrencyResponse {
    private String base;
    private Map<String, String> rates;

    // Getters and setters
    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, String> getRates() {
        return rates;
    }

    public void setRates(Map<String, String> rates) {
        this.rates = rates;
    }
}
