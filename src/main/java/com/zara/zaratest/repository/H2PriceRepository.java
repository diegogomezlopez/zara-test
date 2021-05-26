package com.zara.zaratest.repository;

import com.zara.zaratest.domain.Price;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public final class H2PriceRepository implements PriceReposiroty {

    @Override
    public Price search(LocalDateTime date, Integer productId, Integer brandId) {
        return null;
    }
}
