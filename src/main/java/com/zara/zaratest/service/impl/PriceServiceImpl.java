package com.zara.zaratest.service.impl;

import com.zara.zaratest.domain.Price;
import com.zara.zaratest.dto.PriceSearchRequest;
import com.zara.zaratest.dto.PriceSearchResponse;
import com.zara.zaratest.repository.H2PriceRepository;
import com.zara.zaratest.repository.PriceRepository;
import com.zara.zaratest.service.PriceService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Set;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository repository;

    public PriceServiceImpl(final H2PriceRepository repository) {
        this.repository = repository;
    }

    @Override
    public PriceSearchResponse getPriceByPriority(final PriceSearchRequest request) {
        Set<Price> prices = repository.search(request.getDate(), request.getProductId(), request.getBrandId());
        if (prices.isEmpty()) {
            return PriceSearchResponse.builder().build();
        }
        return getPriceSearchResponse(prices.stream().max(Comparator.comparing(Price::getPriority))
                .orElse(prices.iterator().next()));
    }

    private PriceSearchResponse getPriceSearchResponse(final Price price) {
        return PriceSearchResponse.builder()
                .productId(price.getProductId())
                .brandId(price.getBrandId())
                .priceList(price.getPriceList())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .price(price.getPrice())
                .currency(price.getCurrency())
                .build();
    }
}
