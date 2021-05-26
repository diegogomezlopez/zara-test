package com.zara.zaratest.service;

import com.zara.zaratest.dto.PriceSearchRequest;
import com.zara.zaratest.dto.PriceSearchResponse;

public interface PriceService {

    PriceSearchResponse getPrice(final PriceSearchRequest request);
}
