DROP TABLE IF EXISTS prices;

CREATE TABLE prices (
  ID INT AUTO_INCREMENT PRIMARY KEY,
  BRAND_ID INT NOT NULL,
  START_DATE TIMESTAMP NOT NULL,
  END_DATE TIMESTAMP NOT NULL,
  PRICE_LIST INT NOT NULL,
  PRODUCT_ID INT NOT NULL,
  PRIORITY INT NOT NULL,
  PRICE DECIMAL NOT NULL,
  CURR VARCHAR(3) NOT NULL
);

INSERT INTO prices (BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES
                   (1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR'),
                   (1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR'),
                   (1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR'),
                   (1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');