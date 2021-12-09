CREATE TABLE `tasks` (
    `id`            BIGINT          PRIMARY KEY AUTO_INCREMENT,
    `name`          VARCHAR(128)    NOT NULL,
    `completed`     BOOLEAN         NOT NULL DEFAULT(0)
);
