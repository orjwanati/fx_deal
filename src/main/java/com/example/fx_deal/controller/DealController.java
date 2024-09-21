package com.example.fx_deal.controller;


import com.example.fx_deal.model.Currency;
import com.example.fx_deal.model.Deal;
import com.example.fx_deal.repository.DealRepo;
import com.example.fx_deal.service.CurrencySrvc;
import com.example.fx_deal.service.DealSrvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class DealController {
    private final CurrencySrvc currencyService;
    @Autowired
    private DealRepo dealRepo;

    public DealController(CurrencySrvc currencyService) {
        this.currencyService = currencyService;
    }
    @Autowired
    private DealSrvc dealService;

    @GetMapping("createDeal")
    public String showDealForm(Model model) {
        List<Deal> deals = dealRepo.findAll(); // Fetch all deals from the database
        model.addAttribute("deals", deals); // Add the list of deals to the model

        List<Currency> currencies = currencyService.getAllCurrencies();
        model.addAttribute("currencies", currencies);
        return "createDeal";
    }

    @PostMapping("createDeal")
    public String createDeal(
            @RequestParam("fromCurrency") String fromCurrency,
            @RequestParam("toCurrency") String toCurrency,
            @RequestParam("amount") BigDecimal amount,
            Model model) {

        Deal deal = new Deal();
        deal.setFromCurrency(fromCurrency);
        deal.setToCurrency(toCurrency);
        deal.setDealAmount(amount);
        deal.setDealTimestamp(LocalDateTime.now());

        // Save the deal
        dealService.saveDeal(deal);

        model.addAttribute("successMessage", "Deal successfully created!");
        return "createDeal";
    }
}

