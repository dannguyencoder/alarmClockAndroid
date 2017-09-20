-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 18, 2017 at 08:59 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cauhoi`
--

-- --------------------------------------------------------

--
-- Table structure for table `cauhoiandroid`
--

CREATE TABLE `cauhoiandroid` (
  `id` int(11) NOT NULL,
  `noidungcauhoi` text NOT NULL,
  `dapanA` text NOT NULL,
  `dapanB` text NOT NULL,
  `dapanC` text NOT NULL,
  `dapanD` text NOT NULL,
  `dapancauhoi` text NOT NULL,
  `mucdo` text NOT NULL,
  `linhvuc` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cauhoiandroid`
--

INSERT INTO `cauhoiandroid` (`id`, `noidungcauhoi`, `dapanA`, `dapanB`, `dapanC`, `dapanD`, `dapancauhoi`, `mucdo`, `linhvuc`) VALUES
(1, 'Kết quả của đoạn code sau là gì:\r\nint a = 0;\r\nint b = 0;\r\nreturn a + b;', '0', '2', '3', '4', 'a', 'de', 'android'),
(2, 'Android có chạy được trên máy thật không ?', 'Có', 'Không', '', '', 'a', 'de', 'android'),
(3, 'Android được dựa trên ngôn ngữ lập trình nào ?', 'HTML', 'Node.js', 'C++', 'Java', 'd', 'trungbinh', 'android'),
(4, 'Dalvik là gì ?', 'LÀ công cụ sửa lỗi code android', 'Là một ứng dụng giúp người dùng đơn giản hóa thao tác', 'Là một máy ảo chạy các ứng dụng android', 'Là tên người sáng lập ra Android', 'c', 'kho', 'android');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cauhoiandroid`
--
ALTER TABLE `cauhoiandroid`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cauhoiandroid`
--
ALTER TABLE `cauhoiandroid`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
