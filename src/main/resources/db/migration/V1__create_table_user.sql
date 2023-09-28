use aulamatriz;

create table user (
    id BIGINT UNSIGNED AUTO_INCREMENT,
    name varchar(200),
    lastname varchar(200),
    phone_number varchar(15),
    document varchar(20),
    type_document varchar(20),
    PRIMARY KEY(id)
);

ALTER TABLE user
    ADD Email varchar(255);