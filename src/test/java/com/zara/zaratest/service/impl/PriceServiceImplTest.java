package com.zara.zaratest.service.impl;

import com.zara.zaratest.domain.Price;
import com.zara.zaratest.dto.PriceSearchRequest;
import com.zara.zaratest.dto.PriceSearchResponse;
import com.zara.zaratest.repository.H2PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceServiceImplTest {

    @InjectMocks
    private PriceServiceImpl priceService;

    @Mock
    private H2PriceRepository repository;

    private final Integer brandId = 1;

    private final Integer productId = 35455;

    private final LocalDateTime date = LocalDateTime.now();

    private Set<Price> prices;

    private PriceSearchRequest request;

    @BeforeEach
    public void init() {
        request = PriceSearchRequest.builder()
                .date(date)
                .brandId(brandId)
                .productId(productId)
                .build();
        prices = new HashSet<>();
        Price price = Price.builder()
                .id(1)
                .productId(productId)
                .brandId(brandId)
                .startDate(date)
                .endDate(date)
                .priceList(1)
                .priority(0)
                .price(BigDecimal.valueOf(40.5))
                .currency("EUR")
                .build();
        prices.add(price);
    }

    @Test
    public void searchPriceByPriority_whenValidRequest_thenReturnPriceSearchResponse() {
        when(repository.search(date, productId, brandId)).thenReturn(prices);
        PriceSearchResponse expectedResponse = PriceSearchResponse.builder()
                .productId(productId)
                .brandId(brandId)
                .priceList(1)
                .startDate(date)
                .endDate(date)
                .price(BigDecimal.valueOf(40.5))
                .currency("EUR")
                .build();
        PriceSearchResponse response = priceService.searchPriceByPriority(request);
        assertEquals(expectedResponse.getProductId(), response.getProductId());
        assertEquals(expectedResponse.getBrandId(), response.getBrandId());
        assertEquals(expectedResponse.getPriceList(), response.getPriceList());
        assertEquals(expectedResponse.getStartDate(), response.getStartDate());
        assertEquals(expectedResponse.getEndDate(), response.getEndDate());
        assertEquals(expectedResponse.getPrice(), response.getPrice());
        assertEquals(expectedResponse.getCurrency(), response.getCurrency());
    }

    @Test
    public void searchPriceByPriority_whenNoRepositoryResults_thenReturnNull() {
        when(repository.search(date, productId, brandId)).thenReturn(Collections.emptySet());
        PriceSearchResponse response = priceService.searchPriceByPriority(request);
        assertNull(response);
    }

    @Test
    public void searchPriceByPriority_whenMultipleMatches_thenReturnMostPriorityOne() {
        Price higherPriorityPrice = Price.builder()
                .id(23)
                .productId(productId)
                .brandId(brandId)
                .startDate(date)
                .endDate(date)
                .priceList(2)
                .priority(3)
                .price(BigDecimal.valueOf(50.7))
                .currency("EUR")
                .build();
        prices.add(higherPriorityPrice);
        when(repository.search(date, productId, brandId)).thenReturn(prices);
        PriceSearchResponse response = priceService.searchPriceByPriority(request);
        assertEquals(higherPriorityPrice.getProductId(), response.getProductId());
        assertEquals(higherPriorityPrice.getBrandId(), response.getBrandId());
        assertEquals(higherPriorityPrice.getPriceList(), response.getPriceList());
        assertEquals(higherPriorityPrice.getStartDate(), response.getStartDate());
        assertEquals(higherPriorityPrice.getEndDate(), response.getEndDate());
        assertEquals(higherPriorityPrice.getPrice(), response.getPrice());
        assertEquals(higherPriorityPrice.getCurrency(), response.getCurrency());
    }

}