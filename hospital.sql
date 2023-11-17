-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 17, 2023 at 06:59 AM
-- Server version: 10.4.28-MariaDB-log
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `fecha_turno` varchar(45) NOT NULL,
  `afeccion` varchar(45) NOT NULL,
  `doctorId` int(11) NOT NULL,
  `status` varchar(1500) DEFAULT NULL,
  `hora_turno` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`id`, `userId`, `fecha_turno`, `afeccion`, `doctorId`, `status`, `hora_turno`) VALUES
(7, 1, '2022-11-25', 'Cold', 8, '1. Tab. Ace 1+ 0 + 1 ------ 5days \r\n\r\n2. Syp. Adril 2 (spoon) + 0 + 2 (spoon) ---7days\r\n\r\n3. Tofen 5mg \r\n    0 + 0 + 1\r\n \r\nMeet me again after 4weeks.', '01:23:00'),
(14, 2, '2023-11-07', 'c', 5, 'Pending', '00:00:00'),
(15, 2, 'asd', '123', 5, 'Pending', '00:00:00'),
(16, 2, '2023-11-07', 'asd', 10, 'Pending', '00:00:00'),
(26, 2, '2023-11-04', 'afeccion', 11, 'Pending', '20:40:00'),
(27, 2, '2023-11-30', 'afeccion', 12, 'Pending', '20:00:00'),
(28, 2, '2023-11-04', 'afeccionsddsdsdsdsdsd', 11, 'Pending', '12:25:00');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `id` int(11) NOT NULL,
  `fullName` varchar(80) NOT NULL,
  `dateOfBirth` varchar(80) NOT NULL,
  `qualification` varchar(80) NOT NULL,
  `specialist` varchar(80) NOT NULL,
  `email` varchar(80) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `password` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`id`, `fullName`, `dateOfBirth`, `qualification`, `specialist`, `email`, `phone`, `password`) VALUES
(3, 'Dr. Taimur', '2022-11-11', 'MBBS', 'Orthopedics', 'drtaimur@gmail.com', '01221212111', '1234'),
(4, 'Dr. SRK', '1986-12-12', 'FCPS', 'Cardiology', 'srk@gmail.com', '01770000000', '1234'),
(5, 'Umme Swami Muttu Swami Venu Gopala Aiyara ', '1958-12-12', 'MBBS', 'Dentist', 'ummeswamimuttuswamivenugopalaaiyara@gmail.com', '01221111000', '1234'),
(6, 'Dr. Screw wala', '1955-10-11', 'FCPS', 'Orthopedics', 'drscrewwala@gmail.com', '01221010101', '1234'),
(7, 'Dr. W. John', '2011-11-11', 'MBBS', 'Dentist', 'drw@gmail.com', '01770000000', '1234'),
(8, 'Dr. M', '1985-10-10', 'MBBS', 'Medicine', 'drm@gmail.com', '01770000000', '1234'),
(9, 'Devi Shetti', '1978-01-02', 'MBBS, FCPS', 'Cardiology', 'drdevishetti@gmail.com', '01000041041', '1234'),
(10, 'Dr. Rana Duggabati', '1975-02-05', 'MBBS', 'Pediatrician', 'drranaduggabati@gmail.com', '01221212121', '1234'),
(11, 'Dr. Sahid Kapoor', '1980-02-22', 'MBBS, FCPS', 'Neurologist', 'drsahidkapoor@gmail.com', '01000121001', '1234'),
(12, '12', '12', '12', '12', '12', '', '12');

-- --------------------------------------------------------

--
-- Table structure for table `specialist`
--

CREATE TABLE `specialist` (
  `id` int(11) NOT NULL,
  `specialist_name` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `specialist`
--

INSERT INTO `specialist` (`id`, `specialist_name`) VALUES
(1, 'Dentist'),
(2, 'Dermatologist'),
(3, 'Anesthesiology'),
(4, 'Orthopedics'),
(5, 'Cardiology'),
(6, 'Onkologist'),
(7, 'Medicine'),
(8, 'Medicine'),
(9, 'Neurologist'),
(10, 'Pediatrician'),
(11, 'ENT Specialist');

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

CREATE TABLE `user_details` (
  `id` int(11) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `email` varchar(80) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`id`, `full_name`, `email`, `password`) VALUES
(1, 'luis', 'luis@odonto.com', '123'),
(2, 'odontologo', 'odontologo@odonto.com', '123'),
(3, '123', '123', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `uId_idx` (`userId`),
  ADD KEY `docId_idx` (`doctorId`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `specialist`
--
ALTER TABLE `specialist`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_details`
--
ALTER TABLE `user_details`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `specialist`
--
ALTER TABLE `specialist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `user_details`
--
ALTER TABLE `user_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `docId` FOREIGN KEY (`doctorId`) REFERENCES `doctor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `uId` FOREIGN KEY (`userId`) REFERENCES `user_details` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
