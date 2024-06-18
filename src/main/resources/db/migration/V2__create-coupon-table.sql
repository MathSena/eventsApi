CREATE TABLE coupons (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    discount INT,
    date VARCHAR(255),
    event_id BIGINT,
    FOREIGN KEY (event_id) REFERENCES events(id)
);

