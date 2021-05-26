package com.zara.zaratest.controller;

import com.zara.zaratest.dto.PriceResponse;
import com.zara.zaratest.service.PriceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
public final class PriceController {

    private final PriceService priceService;

    public PriceController(final PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public PriceResponse getPrice(
            @RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd-HH.mm.ss") final LocalDateTime date,
            @RequestParam("product_id") final Integer productId,
            @RequestParam("brand_id") final Integer brandId
    ) {
//        PriceResponse response = priceService.getPrice(date, product_id, brand_id);
        return null;
    }
}
