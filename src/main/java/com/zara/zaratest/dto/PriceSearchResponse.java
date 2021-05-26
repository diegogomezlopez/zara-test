package com.zara.zaratest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public final class PriceSearchResponse {

    private final Integer productId;
    private final Integer brandId;
    private final Integer priceList;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final BigDecimal price;
    private final String currency;
}
