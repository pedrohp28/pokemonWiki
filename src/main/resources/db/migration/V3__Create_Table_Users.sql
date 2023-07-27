CREATE TABLE `users` (
    `id` bigint(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `login` varchar(255) NOT NULL UNIQUE,
    `password` varchar(255) NOT NULL,
    `role` varchar(30) NOT NULL
);