DROP TABLE IF EXISTS user_record;

CREATE TABLE user_record (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(60),
    email VARCHAR(60),
    userType VARCHAR(60)
);