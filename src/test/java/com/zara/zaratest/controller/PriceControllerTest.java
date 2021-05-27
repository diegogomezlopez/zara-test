package com.zara.zaratest.controller;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.config.ParamConfig.UpdateStrategy.REPLACE;
import static io.restassured.config.ParamConfig.paramConfig;
import static io.restassured.config.RestAssuredConfig.config;
import static org.hamcrest.Matchers.equalTo;

class PriceControllerTest {

    private static final String SEARCH_ENDPOINT_URL = "/prices/search";

    //FROM HERE YOU CAN FIND THE EXPECTED 5 TESTS OF THE ZARA TEST
    @Test
    public void search_whenCase1_thenResponse1() {
        given()
                .config(config().paramConfig(paramConfig().queryParamsUpdateStrategy(REPLACE)))
                .queryParam("date", "2020-06-14-10.00.00")
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
        .when()
                .get(SEARCH_ENDPOINT_URL)
        .then()
                .statusCode(200)
                .body(
                        "productId", equalTo(35455),
                        "brandId",  equalTo(1),
                        "priceList", equalTo(1),
                        "startDate", equalTo("2020-06-14T00:00:00"),
                        "endDate", equalTo("2020-12-31T23:59:59"),
                        "price", equalTo(35.5F),
                        "currency", equalTo("EUR")
                );
    }

    @Test
    public void search_whenCase2_thenResponse2() {
        given()
                .config(config().paramConfig(paramConfig().queryParamsUpdateStrategy(REPLACE)))
                .queryParam("date", "2020-06-14-16.00.00")
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
        .when()
                .get(SEARCH_ENDPOINT_URL)
        .then()
                .statusCode(200)
                .body(
                        "productId", equalTo(35455),
                        "brandId",  equalTo(1),
                        "priceList", equalTo(2),
                        "startDate", equalTo("2020-06-14T15:00:00"),
                        "endDate", equalTo("2020-06-14T18:30:00"),
                        "price", equalTo(25.45F),
                        "currency", equalTo("EUR")
                );
    }

    @Test
    public void search_whenCase3_thenResponse3() {
        given()
                .config(config().paramConfig(paramConfig().queryParamsUpdateStrategy(REPLACE)))
                .queryParam("date", "2020-06-14-21.00.00")
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
        .when()
                .get(SEARCH_ENDPOINT_URL)
        .then()
                .statusCode(200)
                .body(
                        "productId", equalTo(35455),
                        "brandId",  equalTo(1),
                        "priceList", equalTo(1),
                        "startDate", equalTo("2020-06-14T00:00:00"),
                        "endDate", equalTo("2020-12-31T23:59:59"),
                        "price", equalTo(35.50F),
                        "currency", equalTo("EUR")
                );
    }

    @Test
    public void search_whenCase4_thenResponse4() {
        given()
                .config(config().paramConfig(paramConfig().queryParamsUpdateStrategy(REPLACE)))
                .queryParam("date", "2020-06-15-10.00.00")
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
        .when()
                .get(SEARCH_ENDPOINT_URL)
        .then()
                .statusCode(200)
                .body(
                        "productId", equalTo(35455),
                        "brandId",  equalTo(1),
                        "priceList", equalTo(3),
                        "startDate", equalTo("2020-06-15T00:00:00"),
                        "endDate", equalTo("2020-06-15T11:00:00"),
                        "price", equalTo(30.50F),
                        "currency", equalTo("EUR")
                );
    }

    @Test
    public void search_whenCase5_thenResponse5() {
        given()
                .config(config().paramConfig(paramConfig().queryParamsUpdateStrategy(REPLACE)))
                .queryParam("date", "2020-06-16-21.00.00")
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
        .when()
                .get(SEARCH_ENDPOINT_URL)
        .then()
                .statusCode(200)
                .body(
                        "productId", equalTo(35455),
                        "brandId",  equalTo(1),
                        "priceList", equalTo(4),
                        "startDate", equalTo("2020-06-15T16:00:00"),
                        "endDate", equalTo("2020-12-31T23:59:59"),
                        "price", equalTo(38.95F),
                        "currency", equalTo("EUR")
                );
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void search_whenDateAboveLastEndDate_thenReturnEmpty() {
        given()
                .config(config().paramConfig(paramConfig().queryParamsUpdateStrategy(REPLACE)))
                .queryParam("date", "2021-06-16-21.00.00")
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
        .when()
                .get(SEARCH_ENDPOINT_URL)
        .then()
                .statusCode(200)
                .body(equalTo(""));
    }

    @Test
    public void search_whenDateBelowFirstStartDate_thenReturnEmpty() {
        given()
                .config(config().paramConfig(paramConfig().queryParamsUpdateStrategy(REPLACE)))
                .queryParam("date", "2019-06-16-21.00.00")
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
        .when()
                .get(SEARCH_ENDPOINT_URL)
        .then()
                .statusCode(200)
                .body(equalTo(""));
    }
}