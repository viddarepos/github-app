CREATE TABLE IF NOT EXISTS `word`
(
    `id`    BIGINT       NOT NULL AUTO_INCREMENT,
    `term`  VARCHAR(255) NOT NULL,
    `score` DOUBLE       NOT NULL,
    `positive_count` BIGINT NOT NULL,
    `negative_count` BIGINT NOT NULL,
    PRIMARY KEY (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
