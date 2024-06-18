CREATE TABLE events (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    description TEXT,
    imgUrl VARCHAR(255),
    isRemote BOOLEAN,
    location VARCHAR(255),
    date VARCHAR(255)
);