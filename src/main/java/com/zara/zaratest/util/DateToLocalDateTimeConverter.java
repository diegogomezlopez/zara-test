package com.zara.zaratest.util;

import java.time.LocalDateTime;
import java.util.Date;

public final class DateToLocalDateTimeConverter {

    public static LocalDateTime convert(final Date date) {
        return new java.sql.Timestamp(
                date.getTime()).toLocalDateTime();
    }
}
