-- Скрипт для создания БД.

-- My database is hosted on db4free.net. However, I leave this script for create DB. 
-- I was working via phpMyAdmin, it is auto-generated script. 

-- host: db4free.net:3306
-- DB name: random_boy
-- pasword: asdfghjkl





-----------------------------------------------------------
-- version 4.8.3
-- Хост: 127.0.0.1:3306
-- Время создания: Окт 09 2018 г., 23:11
-- Версия сервера: 8.0.12
-- Версия PHP: 7.2.10-0ubuntu0.18.04.1


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- База данных: `books_db`
--

-- --------------------------------------------------------

--
-- Структура таблицы `asigns`
--

CREATE TABLE `asigns` (
  `assign_id` int(10) NOT NULL,
  `book_id` int(100) NOT NULL,
  `author_id` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- ССЫЛКИ ТАБЛИЦЫ `asigns`:
--   `author_id`
--       `authors` -> `author_id`
--   `book_id`
--       `books` -> `book_id`
--

--
-- Дамп данных таблицы `asigns`
--

INSERT INTO `asigns` (`assign_id`, `book_id`, `author_id`) VALUES
(1, 3, 3),
(2, 1, 1),
(3, 5, 3),
(5, 1, 4),
(6, 4, 6),
(7, 4, 5),
(8, 6, 6),
(9, 7, 7),
(10, 8, 7),
(11, 9, 7),
(12, 11, 8),
(13, 10, 8),
(16, 12, 4);

-- --------------------------------------------------------

--
-- Структура таблицы `authors`
--

CREATE TABLE `authors` (
  `author_id` int(10) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `birth_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Дамп данных таблицы `authors`
--

INSERT INTO `authors` (`author_id`, `last_name`, `first_name`, `birth_date`) VALUES
(1, 'Андерсон', 'Ганс', '1984-05-03'),
(3, 'Блох', 'Джошуш', '1969-09-28'),
(4, 'Пушкин', 'Александр', '1799-06-06'),
(5, 'Малахов', 'Генадий', '1987-03-14'),
(6, 'Малышева', 'Елена', '1969-03-13'),
(7, 'Роулинг', 'Джоан', '1965-07-31'),
(8, 'Чуковский', 'Корней', '1882-03-31');

-- --------------------------------------------------------

--
-- Структура таблицы `books`
--

CREATE TABLE `books` (
  `book_id` int(10) NOT NULL,
  `book_name` varchar(255) NOT NULL,
  `book_year` int(4) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- ССЫЛКИ ТАБЛИЦЫ `books`:
--

--
-- Дамп данных таблицы `books`
--

INSERT INTO `books` (`book_id`, `book_name`, `book_year`, `description`) VALUES
(1, 'Сказки', 2011, ''),
(3, 'Эффективное программирование', 2008, 'I read it\r\n\r\n\r\n(a bit)'),
(4, 'Здоровье', 2002, ''),
(5, 'Системы радиодоступа', 2004, ''),
(6, 'Диеты', 2018, 'омг'),
(7, 'Гарри Поттер и философский камень', 1997, 'Может и стоило писать все на английском'),
(8, 'Гарри Поттер и Тайная комната', 1998, ''),
(9, 'Гарри Поттер и узник Азкабана', 1999, 'Гарри Поттер и узник Азкабана — третья книга Джоан Роулинг из серии романов о Гарри Поттере. Опубликована в 1999 году, экранизирована в 2004 году. '),
(10, 'Мойдодыр', 1923, ''),
(11, 'Айболит', 1929, ''),
(12, 'Евгений Онегин', 1987, '');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `asigns`
--
ALTER TABLE `asigns`
  ADD PRIMARY KEY (`assign_id`),
  ADD KEY `author_id` (`author_id`),
  ADD KEY `book_id` (`book_id`);

--
-- Индексы таблицы `authors`
--
ALTER TABLE `authors`
  ADD PRIMARY KEY (`author_id`);

--
-- Индексы таблицы `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`book_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `asigns`
--
ALTER TABLE `asigns`
  MODIFY `assign_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT для таблицы `authors`
--
ALTER TABLE `authors`
  MODIFY `author_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT для таблицы `books`
--
ALTER TABLE `books`
  MODIFY `book_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `asigns`
--
ALTER TABLE `asigns`
  ADD CONSTRAINT `asigns_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `authors` (`author_id`),
  ADD CONSTRAINT `asigns_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`book_id`);