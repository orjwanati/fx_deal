package com.example.fx_deal.service;

import com.example.fx_deal.model.Deal;
import com.example.fx_deal.repository.DealRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DealSrvc {
    private static final Logger logger = LoggerFactory.getLogger(DealSrvc.class);

    @Autowired
    private DealRepo dealRepo;

    public void saveDeal(Deal deal) {
        logger.info("Saving deal");
        try{
        if (!dealRepo.existsByDealUniqueId(deal.getDealUniqueId())) {
            dealRepo.save(deal);
        }
        } catch (Exception e) {
                logger.error("Error saving deal", e);
        }
    }

    public List<Deal> getAllDeals() {
        logger.info("Fetching deal");

        return dealRepo.findAll();
    }
}
