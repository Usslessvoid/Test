-- ������ ��� �������� ��.

-- My database is hosted on db4free.net. However, I leave this script for create DB. 
-- I was working via phpMyAdmin, it is auto-generated script. 

-- host: db4free.net:3306
-- DB name: random_boy
-- pasword: asdfghjkl





-----------------------------------------------------------
-- version 4.8.3
-- ����: 127.0.0.1:3306
-- ����� ��������: ��� 09 2018 �., 23:11
-- ������ �������: 8.0.12
-- ������ PHP: 7.2.10-0ubuntu0.18.04.1


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- ���� ������: `books_db`
--

-- --------------------------------------------------------

--
-- ��������� ������� `asigns`
--

CREATE TABLE `asigns` (
  `assign_id` int(10) NOT NULL,
  `book_id` int(100) NOT NULL,
  `author_id` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- ������ ������� `asigns`:
--   `author_id`
--       `authors` -> `author_id`
--   `book_id`
--       `books` -> `book_id`
--

--
-- ���� ������ ������� `asigns`
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
-- ��������� ������� `authors`
--

CREATE TABLE `authors` (
  `author_id` int(10) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `birth_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- ���� ������ ������� `authors`
--

INSERT INTO `authors` (`author_id`, `last_name`, `first_name`, `birth_date`) VALUES
(1, '��������', '����', '1984-05-03'),
(3, '����', '������', '1969-09-28'),
(4, '������', '���������', '1799-06-06'),
(5, '�������', '�������', '1987-03-14'),
(6, '��������', '�����', '1969-03-13'),
(7, '�������', '�����', '1965-07-31'),
(8, '���������', '������', '1882-03-31');

-- --------------------------------------------------------

--
-- ��������� ������� `books`
--

CREATE TABLE `books` (
  `book_id` int(10) NOT NULL,
  `book_name` varchar(255) NOT NULL,
  `book_year` int(4) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- ������ ������� `books`:
--

--
-- ���� ������ ������� `books`
--

INSERT INTO `books` (`book_id`, `book_name`, `book_year`, `description`) VALUES
(1, '������', 2011, ''),
(3, '����������� ����������������', 2008, 'I read it\r\n\r\n\r\n(a bit)'),
(4, '��������', 2002, ''),
(5, '������� ������������', 2004, ''),
(6, '�����', 2018, '���'),
(7, '����� ������ � ����������� ������', 1997, '����� � ������ ������ ��� �� ����������'),
(8, '����� ������ � ������ �������', 1998, ''),
(9, '����� ������ � ����� ��������', 1999, '����� ������ � ����� �������� � ������ ����� ����� ������� �� ����� ������� � ����� �������. ������������ � 1999 ����, �������������� � 2004 ����. '),
(10, '��������', 1923, ''),
(11, '�������', 1929, ''),
(12, '������� ������', 1987, '');

--
-- ������� ���������� ������
--

--
-- ������� ������� `asigns`
--
ALTER TABLE `asigns`
  ADD PRIMARY KEY (`assign_id`),
  ADD KEY `author_id` (`author_id`),
  ADD KEY `book_id` (`book_id`);

--
-- ������� ������� `authors`
--
ALTER TABLE `authors`
  ADD PRIMARY KEY (`author_id`);

--
-- ������� ������� `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`book_id`);

--
-- AUTO_INCREMENT ��� ���������� ������
--

--
-- AUTO_INCREMENT ��� ������� `asigns`
--
ALTER TABLE `asigns`
  MODIFY `assign_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT ��� ������� `authors`
--
ALTER TABLE `authors`
  MODIFY `author_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT ��� ������� `books`
--
ALTER TABLE `books`
  MODIFY `book_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- ����������� �������� ����� ����������� ������
--

--
-- ����������� �������� ����� ������� `asigns`
--
ALTER TABLE `asigns`
  ADD CONSTRAINT `asigns_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `authors` (`author_id`),
  ADD CONSTRAINT `asigns_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`book_id`);