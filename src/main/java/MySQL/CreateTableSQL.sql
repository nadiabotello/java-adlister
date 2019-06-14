USE adlister_db;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
        id INT UNSIGNED NOT NULL AUTO_INCREMENT,
        username VARCHAR(50) NOT NULL,
        email VARCHAR(100) NOT NULL,
        password VARCHAR(50) NOT NULL,
        PRIMARY KEY (id)
);

INSERT INTO users (username, email, password)
VALUES ('Jake', 'jake@funnydog.com', 'superclingy');


DROP TABLE IF EXISTS ads;

CREATE TABLE ads (
        user_id INT UNSIGNED NOT NULL,
        title VARCHAR(255) NOT NULL,
        description TEXT NOT NULL,
        FOREIGN KEY (user_id)
            REFERENCES users(id)
);

show tables;

describe ads;

describe users;

select * from users;