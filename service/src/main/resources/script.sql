CREATE TABLE users
(
    id         BIGSERIAL PRIMARY KEY,
    login      VARCHAR(128) NOT NULL UNIQUE,
    first_name VARCHAR(256) NOT NULL,
    last_name  VARCHAR(256),
    birthday   DATE,
    e_mail     VARCHAR(256) NOT NULL UNIQUE,
    role       VARCHAR(64),
    address    VARCHAR(256),
    password   VARCHAR(256)
);

CREATE TABLE black_list
(
    id             BIGSERIAL PRIMARY KEY,
    user_id        INT          NOT NULL,
    reason         VARCHAR(128) NOT NULL,
    description    VARCHAR(256),
    block_time     TIMESTAMP    NOT NULL,
    block_duration TIMESTAMP    NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE promo_code
(
    id              BIGSERIAL PRIMARY KEY,
    code            VARCHAR(256) NOT NULL UNIQUE,
    discount        INT          NOT NULL,
    expiration_date TIMESTAMP    NOT NULL
);

CREATE TABLE promo_code_usage
(
    id            BIGSERIAL PRIMARY KEY,
    user_id       INT NOT NULL,
    promo_code_id INT NOT NULL UNIQUE,
    usage_date    TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (promo_code_id) REFERENCES promo_code (id)
);


CREATE TABLE product
(
    id          BIGSERIAL PRIMARY KEY,
    category    VARCHAR(64),
    name        VARCHAR(128)  NOT NULL,
    description VARCHAR(256),
    price       NUMERIC(5, 2) NOT NULL,
    status      VARCHAR(64)   NOT NULL,
    image       VARCHAR(128)
);


CREATE TABLE orders
(
    id      BIGSERIAL PRIMARY KEY,
    user_id INT     NOT NULL,
    price   DECIMAL NOT NULL,
    cart_id INT     NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE order_items
(
    id         BIGSERIAL PRIMARY KEY,
    order_id   INT       NOT NULL UNIQUE REFERENCES orders (id),
    product_id INT       NOT NULL UNIQUE REFERENCES product (id),
    quantity   INT       NOT NULL,
    price      DECIMAL(7, 2),
    created_at TIMESTAMP NOT NULL
);