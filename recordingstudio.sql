-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Сен 21 2022 г., 03:32
-- Версия сервера: 5.7.39-log
-- Версия PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `recordingstudio`
--

-- --------------------------------------------------------

--
-- Структура таблицы `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Структура таблицы `microfon`
--

CREATE TABLE `microfon` (
  `id` bigint(20) NOT NULL,
  `kolichestvo` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `microfon`
--

INSERT INTO `microfon` (`id`, `kolichestvo`, `name`) VALUES
(1, 3, 'СОЮЗ 017 FET КОНДЕНСАТОРНЫЙ МИКРОФОН'),
(2, 52, 'AKG P120');

-- --------------------------------------------------------

--
-- Структура таблицы `miksherniy_pult`
--

CREATE TABLE `miksherniy_pult` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `tip` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `miksherniy_pult`
--

INSERT INTO `miksherniy_pult` (`id`, `name`, `tip`) VALUES
(1, 'Behringer XENYX QX1002USB', 'Аналоговый'),
(2, 'Yamaha CL1', 'Цифровой');

-- --------------------------------------------------------

--
-- Структура таблицы `monitori`
--

CREATE TABLE `monitori` (
  `id` bigint(20) NOT NULL,
  `kolichestvo` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `monitori`
--

INSERT INTO `monitori` (`id`, `kolichestvo`, `name`) VALUES
(1, 6, 'Fluid Audio C5'),
(2, 2, 'PRESONUS ERIS E3.5 BT'),
(3, 4, 'JBL 305P MKII'),
(4, 2, 'Yamaha STAGEPAS 1K');

-- --------------------------------------------------------

--
-- Структура таблицы `nabor_apparaturi`
--

CREATE TABLE `nabor_apparaturi` (
  `id` bigint(20) NOT NULL,
  `microfon_id` bigint(20) DEFAULT NULL,
  `miksherniypult_id` bigint(20) DEFAULT NULL,
  `monitor_id` bigint(20) DEFAULT NULL,
  `naushniki_id` bigint(20) DEFAULT NULL,
  `po_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `nabor_apparaturi`
--

INSERT INTO `nabor_apparaturi` (`id`, `microfon_id`, `miksherniypult_id`, `monitor_id`, `naushniki_id`, `po_id`) VALUES
(1, 2, 1, 3, 2, 1),
(2, 1, 2, 4, 1, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `naushniki`
--

CREATE TABLE `naushniki` (
  `id` bigint(20) NOT NULL,
  `kolichestvo` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `naushniki`
--

INSERT INTO `naushniki` (`id`, `kolichestvo`, `name`) VALUES
(1, 3, 'Shure SRH1840'),
(2, 5, 'Beyerdynamic DT');

-- --------------------------------------------------------

--
-- Структура таблицы `po`
--

CREATE TABLE `po` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `versiya` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `po`
--

INSERT INTO `po` (`id`, `name`, `versiya`) VALUES
(1, 'FL Studio 20', '217.32.3'),
(2, 'Cubase', '4.293.23');

-- --------------------------------------------------------

--
-- Структура таблицы `raspisaniye`
--

CREATE TABLE `raspisaniye` (
  `id` bigint(20) NOT NULL,
  `dennedeli` varchar(20) DEFAULT NULL,
  `vremya_raboti` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `raspisaniye`
--

INSERT INTO `raspisaniye` (`id`, `dennedeli`, `vremya_raboti`) VALUES
(1, 'Понедельник', '12'),
(2, 'Вторник', '12');

-- --------------------------------------------------------

--
-- Структура таблицы `rol`
--

CREATE TABLE `rol` (
  `user_id` bigint(20) NOT NULL,
  `roli` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `seans`
--

CREATE TABLE `seans` (
  `id` bigint(20) NOT NULL,
  `data_i_vremya` varchar(15) DEFAULT NULL,
  `studia_id` bigint(20) DEFAULT NULL,
  `zayavka_id` bigint(20) DEFAULT NULL,
  `dataivremya` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `seans`
--

INSERT INTO `seans` (`id`, `data_i_vremya`, `studia_id`, `zayavka_id`, `dataivremya`) VALUES
(1, '21.09 01:09', 2, 1, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `studia`
--

CREATE TABLE `studia` (
  `id` bigint(20) NOT NULL,
  `adres` varchar(255) DEFAULT NULL,
  `nabor_apparaturi_id` bigint(20) DEFAULT NULL,
  `raspisaniye_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `studia`
--

INSERT INTO `studia` (`id`, `adres`, `nabor_apparaturi_id`, `raspisaniye_id`) VALUES
(1, 'ул. Грузинский вал, д. 3, ст. 9', 1, 1),
(2, 'ул. Квартал Северный, д. 3, кв. 160', 2, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `familiya` varchar(50) DEFAULT NULL,
  `imya` varchar(50) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `nick` varchar(50) DEFAULT NULL,
  `telephone` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id`, `login`, `password`, `active`, `familiya`, `imya`, `mail`, `nick`, `telephone`) VALUES
(1, 'user1', '$2a$18$9TYHG7wvhxgcudc376IyaOTYT0u8BdrVraeD3W8eumSiG/igY4v2P', b'1', 'fam', 'imyaaaaaa', 'mail.ru', 'falseuser', '88888888888'),
(2, 'admin', '$2a$08$m0tFvsaC8bdHysp7e12splk20V9KN09xFv.qkMusYwcz5zq2bLKu6', b'0', 'qwe', 'sas', 'qwe@mail.ru', 'adminchik', '11111111111'),
(3, 'ttt', '$2a$08$028uDrpXx82aJGmasoinHDoVvNObFIg1Qa3YoO7VXScy3t1yjsri.a', b'0', 'ggg', 'ggg', 'ggg@gmail.com', 'ggg', '22222222222');

-- --------------------------------------------------------

--
-- Структура таблицы `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `roles` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user_role`
--

INSERT INTO `user_role` (`user_id`, `roles`) VALUES
(1, 'USER'),
(1, 'ADMIN'),
(2, 'ADMIN'),
(3, 'USER');

-- --------------------------------------------------------

--
-- Структура таблицы `usluga`
--

CREATE TABLE `usluga` (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `opisanie` varchar(150) DEFAULT NULL,
  `stoimost` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `usluga`
--

INSERT INTO `usluga` (`id`, `name`, `opisanie`, `stoimost`) VALUES
(1, 'Сведение', 'Сведение трека по дорожкам', 3500),
(2, 'Запись', '1 час записи голоса', 2000);

-- --------------------------------------------------------

--
-- Структура таблицы `zayavka`
--

CREATE TABLE `zayavka` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `zayavka`
--

INSERT INTO `zayavka` (`id`, `user_id`, `name`) VALUES
(1, NULL, 'я заявка'),
(2, NULL, 'я тоже');

-- --------------------------------------------------------

--
-- Структура таблицы `zayavka_usluga`
--

CREATE TABLE `zayavka_usluga` (
  `zayavka_id` bigint(20) NOT NULL,
  `usluga_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `zayavka_usluga`
--

INSERT INTO `zayavka_usluga` (`zayavka_id`, `usluga_id`) VALUES
(1, 2),
(2, 1);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `microfon`
--
ALTER TABLE `microfon`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `miksherniy_pult`
--
ALTER TABLE `miksherniy_pult`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `monitori`
--
ALTER TABLE `monitori`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `nabor_apparaturi`
--
ALTER TABLE `nabor_apparaturi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKen4r30doa3ls3c3x6ww52lsg0` (`microfon_id`),
  ADD KEY `FKscekphflw6smin4wfwyhrp4yd` (`miksherniypult_id`),
  ADD KEY `FK8dipbe43kcfor9mbp5ut5wrca` (`monitor_id`),
  ADD KEY `FK8o6mf95wyow67bkdjg9805xta` (`naushniki_id`),
  ADD KEY `FKc26gyjimdwog2br9offxv8u5` (`po_id`);

--
-- Индексы таблицы `naushniki`
--
ALTER TABLE `naushniki`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `po`
--
ALTER TABLE `po`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `raspisaniye`
--
ALTER TABLE `raspisaniye`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `rol`
--
ALTER TABLE `rol`
  ADD KEY `FKd02y17qn9uootkbl9yk98jx1m` (`user_id`);

--
-- Индексы таблицы `seans`
--
ALTER TABLE `seans`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnynqklardjhxghdl5yvmvqbfw` (`studia_id`),
  ADD KEY `FKgro6v0svem4gwysp80x5pdbbs` (`zayavka_id`);

--
-- Индексы таблицы `studia`
--
ALTER TABLE `studia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKksqpb4aakau02nbesbapxu2on` (`nabor_apparaturi_id`),
  ADD KEY `FKmrgcrs4flt158ayyotyt17ciw` (`raspisaniye_id`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `usluga`
--
ALTER TABLE `usluga`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `zayavka`
--
ALTER TABLE `zayavka`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnwa91dis7svr1trfaybxhiqm` (`user_id`);

--
-- Индексы таблицы `zayavka_usluga`
--
ALTER TABLE `zayavka_usluga`
  ADD KEY `FKdwi5dym0n59vb9yfljdqjqsm8` (`usluga_id`),
  ADD KEY `FKld8tjdti9o0vuc55sx0ed6eo0` (`zayavka_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `nabor_apparaturi`
--
ALTER TABLE `nabor_apparaturi`
  ADD CONSTRAINT `FK8dipbe43kcfor9mbp5ut5wrca` FOREIGN KEY (`monitor_id`) REFERENCES `monitori` (`id`),
  ADD CONSTRAINT `FK8o6mf95wyow67bkdjg9805xta` FOREIGN KEY (`naushniki_id`) REFERENCES `naushniki` (`id`),
  ADD CONSTRAINT `FKc26gyjimdwog2br9offxv8u5` FOREIGN KEY (`po_id`) REFERENCES `po` (`id`),
  ADD CONSTRAINT `FKen4r30doa3ls3c3x6ww52lsg0` FOREIGN KEY (`microfon_id`) REFERENCES `microfon` (`id`),
  ADD CONSTRAINT `FKscekphflw6smin4wfwyhrp4yd` FOREIGN KEY (`miksherniypult_id`) REFERENCES `miksherniy_pult` (`id`);

--
-- Ограничения внешнего ключа таблицы `rol`
--
ALTER TABLE `rol`
  ADD CONSTRAINT `FKd02y17qn9uootkbl9yk98jx1m` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Ограничения внешнего ключа таблицы `seans`
--
ALTER TABLE `seans`
  ADD CONSTRAINT `FKgro6v0svem4gwysp80x5pdbbs` FOREIGN KEY (`zayavka_id`) REFERENCES `zayavka` (`id`),
  ADD CONSTRAINT `FKnynqklardjhxghdl5yvmvqbfw` FOREIGN KEY (`studia_id`) REFERENCES `studia` (`id`);

--
-- Ограничения внешнего ключа таблицы `studia`
--
ALTER TABLE `studia`
  ADD CONSTRAINT `FKksqpb4aakau02nbesbapxu2on` FOREIGN KEY (`nabor_apparaturi_id`) REFERENCES `nabor_apparaturi` (`id`),
  ADD CONSTRAINT `FKmrgcrs4flt158ayyotyt17ciw` FOREIGN KEY (`raspisaniye_id`) REFERENCES `raspisaniye` (`id`);

--
-- Ограничения внешнего ключа таблицы `zayavka`
--
ALTER TABLE `zayavka`
  ADD CONSTRAINT `FKnwa91dis7svr1trfaybxhiqm` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Ограничения внешнего ключа таблицы `zayavka_usluga`
--
ALTER TABLE `zayavka_usluga`
  ADD CONSTRAINT `FKdwi5dym0n59vb9yfljdqjqsm8` FOREIGN KEY (`usluga_id`) REFERENCES `usluga` (`id`),
  ADD CONSTRAINT `FKld8tjdti9o0vuc55sx0ed6eo0` FOREIGN KEY (`zayavka_id`) REFERENCES `zayavka` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
