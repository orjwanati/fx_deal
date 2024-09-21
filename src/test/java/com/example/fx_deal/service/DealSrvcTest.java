package com.example.fx_deal.service;

import com.example.fx_deal.model.Deal;
import com.example.fx_deal.repository.DealRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class DealSrvcTest {

	@Mock
	private DealRepo dealRepo;

	@InjectMocks
	private DealSrvc dealSrvc;

	private Deal deal;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		deal = new Deal();
		deal.setDealUniqueId("unique-id-123");
		deal.setFromCurrency("USD");
		deal.setToCurrency("EUR");
		deal.setDealAmount(BigDecimal.valueOf(1000.00));
	}

	@Test
	public void testSaveDeal_Success() {
		when(dealRepo.existsByDealUniqueId(deal.getDealUniqueId())).thenReturn(false);

		dealSrvc.saveDeal(deal);

		verify(dealRepo, times(1)).save(deal);
	}

	@Test
	public void testSaveDeal_DuplicateDeal() {
		when(dealRepo.existsByDealUniqueId(deal.getDealUniqueId())).thenReturn(true);

		dealSrvc.saveDeal(deal);

		verify(dealRepo, never()).save(deal);
	}

	@Test
	public void testGetAllDeals_ShouldReturnList() {
		List<Deal> deals = Arrays.asList(deal);
		when(dealRepo.findAll()).thenReturn(deals);

		List<Deal> result = dealSrvc.getAllDeals();

		assertEquals(1, result.size());
		verify(dealRepo, times(1)).findAll();
	}
}
