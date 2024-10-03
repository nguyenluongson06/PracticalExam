-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 03, 2024 at 03:19 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `herogame`
--

-- --------------------------------------------------------

--
-- Table structure for table `national`
--

CREATE TABLE `national` (
  `NationalId` int(11) NOT NULL,
  `NationalName` varchar(255) DEFAULT NULL,
  `national_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `national`
--

INSERT INTO `national` (`NationalId`, `NationalName`, `national_name`) VALUES
(1, 'Vietnam', ''),
(2, 'USA', ''),
(3, 'Japan', '');

-- --------------------------------------------------------

--
-- Table structure for table `player`
--

CREATE TABLE `player` (
  `PlayerId` int(11) NOT NULL,
  `NationalId` int(11) DEFAULT NULL,
  `PlayerName` varchar(255) DEFAULT NULL,
  `HighScore` int(11) DEFAULT NULL,
  `Level` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `player`
--

INSERT INTO `player` (`PlayerId`, `NationalId`, `PlayerName`, `HighScore`, `Level`) VALUES
(1, 1, 'Player 1', 100, 2),
(2, 2, 'Player 2', 1050, 10),
(3, 3, 'Player 3', 200, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `national`
--
ALTER TABLE `national`
  ADD PRIMARY KEY (`NationalId`);

--
-- Indexes for table `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`PlayerId`),
  ADD KEY `NationalId` (`NationalId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `national`
--
ALTER TABLE `national`
  MODIFY `NationalId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `player`
--
ALTER TABLE `player`
  MODIFY `PlayerId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `player`
--
ALTER TABLE `player`
  ADD CONSTRAINT `player_ibfk_1` FOREIGN KEY (`NationalId`) REFERENCES `national` (`NationalId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
