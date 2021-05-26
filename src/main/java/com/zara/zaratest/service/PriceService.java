package com.zara.zaratest.service;

import com.zara.zaratest.dto.PriceResponse;

import java.time.LocalDateTime;

public interface PriceService {

    PriceResponse getPrice(final LocalDateTime date, final Integer product_id, final Integer brand_id);
}
