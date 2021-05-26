package com.zara.zaratest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public final class PriceResponse {

    private final Integer productId;
    private final Integer brandId;
    private final Integer priceList;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Double price;
    private final String currency;
}
