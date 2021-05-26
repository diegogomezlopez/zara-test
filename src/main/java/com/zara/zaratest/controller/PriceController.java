package com.zara.zaratest.controller;

import com.zara.zaratest.dto.PriceSearchRequest;
import com.zara.zaratest.dto.PriceSearchResponse;
import com.zara.zaratest.service.PriceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/prices")
public final class PriceController {

    private final PriceService priceService;

    public PriceController(final PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/search")
    public PriceSearchResponse search(@Valid final PriceSearchRequest request) {
        return priceService.getPrice(request);
    }
}
