-- -----------------------------------------------------
-- Create schema lab-asm31
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `simple-fullstack`;

CREATE SCHEMA `simple-fullstack`;
USE `simple-fullstack`;

-- -----------------------------------------------------
-- Create user
-- -----------------------------------------------------
DROP USER IF EXISTS 'simplefullstack'@'localhost';
CREATE USER 'simplefullstack'@'localhost' IDENTIFIED BY 'simplefullstack';

GRANT ALL PRIVILEGES ON `simple-fullstack`.* TO 'simplefullstack'@'localhost';

-- -----------------------------------------------------
-- Create tables and insert information
-- -----------------------------------------------------
DROP TABLE if EXISTS `machines`;
create table machines
(
    id                int unsigned auto_increment,
    name              varchar(255) not null,
    short_description varchar(255) not null,
    long_description  text         not null,
    image_url         varchar(255) null,
    quantity          int          not null,
    published_date    date         not null,
    primary key (id),
    unique key (id)
);


INSERT INTO `simple-fullstack`.machines (name, short_description, long_description, image_url, quantity, published_date)
VALUES ('Machine1', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit',
        'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat.',
        '/common/machines-image/i285978589337195389._rsw480h360_szw480h360_.jpg', 1, '2020-02-25');

INSERT INTO `simple-fullstack`.machines (name, short_description, long_description, image_url, quantity, published_date)
VALUES ('Machine2', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit',
        'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat.',
        '/common/machines-image/i285978589337195392._rsw480h360_szw480h360_.jpg', 3, '2020-02-27');

INSERT INTO `simple-fullstack`.machines (name, short_description, long_description, image_url, quantity, published_date)
VALUES ('Machine3', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit',
        'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat.',
        '/common/machines-image/i285978589337195397._rsw480h360_szw480h360_.jpg', 5, '2020-03-10');

INSERT INTO `simple-fullstack`.machines (name, short_description, long_description, image_url, quantity, published_date)
VALUES ('Machine4', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit',
        'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat.',
        '/common/machines-image/i285978589337195403._rsw480h360_szw480h360_.jpg', 2, '2020-03-15');

INSERT INTO `simple-fullstack`.machines (name, short_description, long_description, image_url, quantity, published_date)
VALUES ('Machine5', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit',
        'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat.',
        '/common/machines-image/i285978589337195406._rsw480h360_szw480h360_.jpg', 1, '2020-03-25');

INSERT INTO `simple-fullstack`.machines (name, short_description, long_description, image_url, quantity, published_date)
VALUES ('Machine6', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit',
        'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat.',
        '/common/machines-image/i285978589337195414._rsw480h360_szw480h360_.jpg', 3, '2020-05-11');

INSERT INTO `simple-fullstack`.machines (name, short_description, long_description, image_url, quantity, published_date)
VALUES ('Machine7', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit',
        'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat.',
        '/common/machines-image/i285978589337195392._rsw480h360_szw480h360_.jpg', 0, '2020-07-11');

INSERT INTO `simple-fullstack`.machines (name, short_description, long_description, image_url, quantity, published_date)
VALUES ('Machine8', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit',
        'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat.',
        '/common/machines-image/i285978589337195397._rsw480h360_szw480h360_.jpg', 0, '2020-01-11');


DROP TABLE if EXISTS `client_submissions`;
create table client_submissions
(
    id               int unsigned auto_increment,
    name             varchar(255) not null,
    email            varchar(255) not null,
    message          text         not null,
    submit_date_time datetime     not null,
    primary key (id),
    unique key (id)
);