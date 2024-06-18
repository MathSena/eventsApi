CREATE TABLE addresses (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    street VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    country VARCHAR(255),
    zipCode VARCHAR(255),
    event_id BIGINT,
    FOREIGN KEY (event_id) REFERENCES events(id)
);