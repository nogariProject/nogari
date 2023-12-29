DROP TABLE IF EXISTS USER_MDJ;
CREATE TABLE USER_MDJ
(
    id  VARCHAR(1000) NOT NULL,
    pw VARCHAR(100) NOT NULL,
    name   VARCHAR(10),
    nickname   VARCHAR(10),
    age        NUMBER(38),
    address    VARCHAR(25),
    PRIMARY KEY (id)
);