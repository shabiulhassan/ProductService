CREATE TABLE category
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE jt_mentor
(
    id BIGINT NOT NULL,
    avg_rating DOUBLE NULL,
    CONSTRAINT pk_jt_mentor PRIMARY KEY (id)
);

CREATE TABLE jt_student
(
    id BIGINT NOT NULL,
    psp DOUBLE NULL,
    CONSTRAINT pk_jt_student PRIMARY KEY (id)
);

CREATE TABLE jt_ta
(
    id                     BIGINT NOT NULL,
    total_questions_solved INT    NOT NULL,
    CONSTRAINT pk_jt_ta PRIMARY KEY (id)
);

CREATE TABLE jt_user
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_jt_user PRIMARY KEY (id)
);

CREATE TABLE msc_mentor
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    avg_rating DOUBLE NULL,
    CONSTRAINT pk_msc_mentor PRIMARY KEY (id)
);

CREATE TABLE msc_student
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    psp DOUBLE NULL,
    CONSTRAINT pk_msc_student PRIMARY KEY (id)
);

CREATE TABLE msc_ta
(
    id                     BIGINT AUTO_INCREMENT NOT NULL,
    name                   VARCHAR(255) NULL,
    email                  VARCHAR(255) NULL,
    total_questions_solved INT NOT NULL,
    CONSTRAINT pk_msc_ta PRIMARY KEY (id)
);

CREATE TABLE price
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    currency VARCHAR(255) NULL,
    value    INT NOT NULL,
    CONSTRAINT pk_price PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    price_id      BIGINT NULL,
    image         VARCHAR(255) NULL,
    category_id   BIGINT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE st_user
(
    id                     BIGINT AUTO_INCREMENT NOT NULL,
    user_tye               INT NULL,
    name                   VARCHAR(255) NULL,
    email                  VARCHAR(255) NULL,
    psp DOUBLE NULL,
    total_questions_solved INT NOT NULL,
    avg_rating DOUBLE NULL,
    CONSTRAINT pk_st_user PRIMARY KEY (id)
);

CREATE TABLE tpc_mentor
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    avg_rating DOUBLE NULL,
    CONSTRAINT pk_tpc_mentor PRIMARY KEY (id)
);

CREATE TABLE tpc_student
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    psp DOUBLE NULL,
    CONSTRAINT pk_tpc_student PRIMARY KEY (id)
);

CREATE TABLE tpc_ta
(
    id                     BIGINT NOT NULL,
    name                   VARCHAR(255) NULL,
    email                  VARCHAR(255) NULL,
    total_questions_solved INT    NOT NULL,
    CONSTRAINT pk_tpc_ta PRIMARY KEY (id)
);

CREATE TABLE tpc_user
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_user PRIMARY KEY (id)
);

ALTER TABLE category
    ADD CONSTRAINT uc_category_name UNIQUE (name);

ALTER TABLE jt_mentor
    ADD CONSTRAINT FK_JT_MENTOR_ON_ID FOREIGN KEY (id) REFERENCES jt_user (id);

ALTER TABLE jt_student
    ADD CONSTRAINT FK_JT_STUDENT_ON_ID FOREIGN KEY (id) REFERENCES jt_user (id);

ALTER TABLE jt_ta
    ADD CONSTRAINT FK_JT_TA_ON_ID FOREIGN KEY (id) REFERENCES jt_user (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_PRICE FOREIGN KEY (price_id) REFERENCES price (id);