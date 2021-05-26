package com.zara.zaratest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public final class PriceSearchRequest {

    @DateTimeFormat(pattern="yyyy-MM-dd-HH.mm.ss")
    @NotNull
    final LocalDateTime date;

    @NotNull
    final Integer productId;

    @NotNull
    final Integer brandId;
}
