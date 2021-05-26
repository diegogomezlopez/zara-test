package com.zara.zaratest.repository;

import com.zara.zaratest.domain.Price;
import com.zara.zaratest.exception.PriceServiceException;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Repository
public class H2PriceRepository implements PriceRepository {

    private final Connection connection;

    public H2PriceRepository(final Connection connection) {
        this.connection = connection;
    }

    @Override
    public Price search(LocalDateTime date, Integer productId, Integer brandId) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM PRICES";
            ResultSet result = statement.executeQuery(sql);
            Set<Price> prices = new HashSet<>();
            while (result.next()) {
                Price price = Price.builder()
                    .id(result.getInt("id"))
                    .brandId(result.getInt("brand_id"))
                    .startDate(result.getDate("start_date").toLocalDate())
                    .endDate(result.getDate("end_date").toLocalDate())
                    .priceList(result.getInt("price_list"))
                    .productId(result.getInt("product_id"))
                    .priority(result.getInt("priority"))
                    .price(result.getBigDecimal("price"))
                    .currency(result.getString("curr"))
                    .build();
                prices.add(price);
            }
            return prices.iterator().next();
        } catch (SQLException exception) {
            throw new PriceServiceException(String.format("Error executing query for date: %s, productId: %s, brandId: %s", date, productId, brandId));
        }
    }
}
