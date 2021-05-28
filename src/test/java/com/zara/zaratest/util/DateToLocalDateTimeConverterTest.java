package com.zara.zaratest.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class DateToLocalDateTimeConverterTest {


    @Test
    public void convert_whenDateNotNull_thenReturnLocalDateTime() {
        LocalDateTime result = DateToLocalDateTimeConverter.convert(new Date());
        assertNotNull(result);
    }

    @Test
    public void convert_whenDateNull_thenThrowNullPointer() {
        assertThrows(NullPointerException.class, () -> {
            DateToLocalDateTimeConverter.convert(null);
        });
    }

}