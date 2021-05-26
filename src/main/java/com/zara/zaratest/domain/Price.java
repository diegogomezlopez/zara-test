package com.zara.zaratest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public final class Price {

    private final Integer id;
    private final Integer productId;
    private final Integer brandId;
    private final Integer priceList;
    private final Integer priority;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final BigDecimal price;
    private final String currency;
}
