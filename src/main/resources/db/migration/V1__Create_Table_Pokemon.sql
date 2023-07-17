CREATE TABLE `pokemon` (
    `id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(80) NOT NULL,
    `description` varchar(120) NOT NULL,
    `type` varchar(80) NOT NULL,
    `hp` int NOT NULL,
    `attack` int NOT NULL,
    `defense` int NOT NULL,
    `sp_Atk` int NOT NULL,
    `sp_Def` int NOT NULL,
    `speed` int NOT NULL,
    PRIMARY KEY (`id`)
);