--liquibase formatted sql

--changeset svdev:1
CREATE TABLE "users"
(
    id         BIGSERIAL PRIMARY KEY,
    login      VARCHAR(128) NOT NULL UNIQUE,
    first_name VARCHAR(256) NOT NULL,
    last_name  VARCHAR(256),
    birthday   DATE,
    role       VARCHAR(64),
    address    VARCHAR(256),
    password   VARCHAR(256)
);
--rollback DROP TABLE "users"

--changeset svdev:2
CREATE TABLE black_list
(
    id             BIGSERIAL PRIMARY KEY,
    user_id        BIGINT       NOT NULL,
    reason         VARCHAR(128) NOT NULL,
    description    VARCHAR(256),
    block_time     TIMESTAMP    NOT NULL,
    block_duration TIMESTAMP    NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);
--rollback DROP TABLE black_list


--changeset svdev:3
CREATE TABLE promo_code
(
    id              BIGSERIAL PRIMARY KEY,
    code            VARCHAR(256) NOT NULL UNIQUE,
    discount        INT          NOT NULL,
    created_at      TIMESTAMP    NOT NULL,
    expiration_date TIMESTAMP    NOT NULL
);
--rollback DROP TABLE promo_code


--changeset svdev:4
CREATE TABLE promo_code_usage
(
    id            BIGSERIAL PRIMARY KEY,
    user_id       BIGINT NOT NULL,
    promo_code_id BIGINT    NOT NULL UNIQUE,
    usage_date    DATE,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (promo_code_id) REFERENCES promo_code (id)
);
--rollback DROP TABLE promo_code_usage


--changeset svdev:5
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
--rollback DROP TABLE product

--changeset svdev:6
CREATE TABLE orders
(
    id      BIGSERIAL PRIMARY KEY,
    user_id BIGINT       NOT NULL,
    price   DECIMAL      NOT NULL,
    status  VARCHAR(128) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);
--rollback DROP TABLE orders

--changeset svdev:7
CREATE TABLE order_items
(
    id         BIGSERIAL PRIMARY KEY,
    order_id   BIGINT    NOT NULL UNIQUE REFERENCES orders (id),
    product_id BIGINT    NOT NULL UNIQUE REFERENCES product (id),
    quantity   INT       NOT NULL,
    price      DECIMAL(7, 2),
    created_at TIMESTAMP NOT NULL
);
--rollback DROP TABLE order_items

ALTER TABLE orders
    DROP COLUMN price;

ALTER TABLE orders
    ADD COLUMN price DECIMAL NOT NULL;
ALTER TABLE order_items
    DROP COLUMN price;

ALTER TABLE order_items
    ADD COLUMN price NUMERIC NOT NULL;