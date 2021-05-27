package com.zara.zaratest.repository;

import com.zara.zaratest.domain.Price;

import java.time.LocalDateTime;
import java.util.Set;

public interface PriceRepository {

    Set<Price> search(final LocalDateTime date, final Integer productId, final Integer brandId);
}
