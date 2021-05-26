package com.zara.zaratest.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class H2Config {

    private static final Logger logger = LoggerFactory.getLogger(H2Config.class);

    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:mem:pricesdb";
    private static final String USER = "sa";
    private static final String PASS = "";

    @Bean
    public Connection connection() {
        try {
            logger.info("Registering JDBC Driver: {}", JDBC_DRIVER);
            Class.forName(JDBC_DRIVER);
            logger.info("Registering JDBC Driver: {}", JDBC_DRIVER);
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException exception) {
            logger.error("Error registering JDBC Driver: {}, {}", JDBC_DRIVER, exception.getLocalizedMessage());
        } catch (SQLException exception) {
            logger.error("Error connecting to database: {}, {}", DB_URL, exception.getLocalizedMessage());
        }
        return null;
    }
}
