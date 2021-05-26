package com.zara.zaratest.repository;

import com.zara.zaratest.domain.Price;

import java.time.LocalDateTime;

public interface PriceReposiroty {

    Price search(final LocalDateTime date, final Integer productId, final Integer brandId);
}
