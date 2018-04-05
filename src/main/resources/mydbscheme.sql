CREATE TABLE user
(
  user_id  INT AUTO_INCREMENT
    PRIMARY KEY,
  login    VARCHAR(30)  NOT NULL,
  password VARCHAR(100) NOT NULL,
  CONSTRAINT user_user_id_uindex
  UNIQUE (user_id),
  CONSTRAINT user_login_uindex
  UNIQUE (login),
  CONSTRAINT user_id
  FOREIGN KEY (user_id) REFERENCES user_info (user_id)
);
CREATE TABLE user_info
(
  user_id      INT         NOT NULL
    PRIMARY KEY,
  lastname     VARCHAR(30) NULL,
  firstname    VARCHAR(30) NULL,
  patronymic   VARCHAR(30) NULL,
  phone_number VARCHAR(20) NULL
);