package com.zara.zaratest.repository;

import com.zara.zaratest.domain.Price;
import com.zara.zaratest.exception.PriceServiceException;
import com.zara.zaratest.util.DateToLocalDateTimeConverter;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Repository
public class H2PriceRepository implements PriceRepository {

    private final Connection connection;

    public H2PriceRepository(final Connection connection) {
        this.connection = connection;
    }

    @Override
    public Set<Price> search(final LocalDateTime date, final Integer productId, final Integer brandId) {
        try {
            Statement statement = connection.createStatement();
            String query = getSearchQuery(date, productId, brandId);
            ResultSet result = statement.executeQuery(query);
            Set<Price> prices = extractPricesFromResultSet(result);
            statement.close();
            return prices;
        } catch (SQLException exception) {
            throw new PriceServiceException(String.format("Error executing query for date: %s, productId: %s, brandId: %s, error: %s", date, productId, brandId, exception.getLocalizedMessage()));
        }
    }

    private String getSearchQuery(final LocalDateTime date, final Integer productId, final Integer brandId) {
        LocalDate localDate = date.toLocalDate();
        LocalTime localTime = date.toLocalTime();
        return "SELECT * FROM PRICES WHERE product_id = " + productId +
                " AND brand_id = " + brandId +
                " AND start_date <= '" + localDate + " " + localTime +
                "' AND end_date >= '" + localDate + " " + localTime + "'";
    }

    private Set<Price> extractPricesFromResultSet(final ResultSet result) throws SQLException {
        Set<Price> prices = new HashSet<>();
        while (result.next()) {
            Price price = Price.builder()
                    .id(result.getInt("id"))
                    .brandId(result.getInt("brand_id"))
                    .startDate(DateToLocalDateTimeConverter.convert(result.getTimestamp("start_date")))
                    .endDate(DateToLocalDateTimeConverter.convert(result.getTimestamp("end_date")))
                    .priceList(result.getInt("price_list"))
                    .productId(result.getInt("product_id"))
                    .priority(result.getInt("priority"))
                    .price(result.getBigDecimal("price"))
                    .currency(result.getString("curr"))
                    .build();
            prices.add(price);
        }
        return prices;
    }
}
