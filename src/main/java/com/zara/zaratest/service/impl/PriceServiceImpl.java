package com.zara.zaratest.service.impl;

import com.zara.zaratest.dto.PriceResponse;
import com.zara.zaratest.service.PriceService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceServiceImpl implements PriceService {

    @Override
    public PriceResponse getPrice(final LocalDateTime date, final Integer product_id, final Integer brand_id) {
        return null;
    }
}
