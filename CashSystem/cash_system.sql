-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2018 at 05:12 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cash_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `item_id` int(11) NOT NULL,
  `item_code` int(11) NOT NULL,
  `item_name` varchar(255) NOT NULL,
  `item_prize` int(11) NOT NULL,
  `item_qty` int(11) NOT NULL,
  `item_discount` int(11) NOT NULL,
  `item_date` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`item_id`, `item_code`, `item_name`, `item_prize`, `item_qty`, `item_discount`, `item_date`) VALUES
(1, 1, 'Pen', 1200, 100, 100, '2017-12-11 21:05:23'),
(2, 2, 'Pencil', 500, 100, 0, '2017-12-12 11:28:45'),
(3, 3, 'Eraser', 500, 50, 0, '2017-12-12 11:30:47'),
(22, 6, 'Phone Cover', 1500, 6, 100, '2018-04-18 13:14:01'),
(5, 5, 'Calculators', 25000, 30, 3000, '2017-12-12 11:49:02');

-- --------------------------------------------------------

--
-- Table structure for table `items_sold`
--

CREATE TABLE `items_sold` (
  `items_id` int(11) NOT NULL,
  `items_code` int(11) NOT NULL,
  `items_name` varchar(255) NOT NULL,
  `items_prize` int(11) NOT NULL,
  `items_qty` int(11) NOT NULL,
  `items_discount` int(11) NOT NULL,
  `items_date` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `items_sold`
--

INSERT INTO `items_sold` (`items_id`, `items_code`, `items_name`, `items_prize`, `items_qty`, `items_discount`, `items_date`) VALUES
(1, 3, 'Eraser', 500, 5, 0, '2017-12-22 21:26:01'),
(2, 1, 'Pen', 1200, 10, 100, '2017-12-22 21:26:01'),
(3, 5, 'Calculators', 25000, 1, 3000, '2017-12-22 21:26:01');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`item_id`),
  ADD UNIQUE KEY `item_code` (`item_code`);

--
-- Indexes for table `items_sold`
--
ALTER TABLE `items_sold`
  ADD PRIMARY KEY (`items_id`),
  ADD UNIQUE KEY `items_code` (`items_code`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `items`
--
ALTER TABLE `items`
  MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT for table `items_sold`
--
ALTER TABLE `items_sold`
  MODIFY `items_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
