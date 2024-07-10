-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 10, 2024 at 07:46 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `universitasjawa`
--

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `mhs_id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `nim` varchar(20) NOT NULL,
  `tempat_lahir` varchar(50) NOT NULL,
  `tgl_lahir` varchar(255) NOT NULL,
  `jenis_kelamin` enum('L','P') NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `no_telp` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `prodi_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`mhs_id`, `nama`, `nim`, `tempat_lahir`, `tgl_lahir`, `jenis_kelamin`, `alamat`, `no_telp`, `email`, `prodi_id`) VALUES
(26, 'Ahmad Sutarjo', 'A12 - 59009', 'Sukolilo', '15-05-2000', 'L', 'Pati 002/001', 81123, 'sutarjo@gmail.com', 2);

-- --------------------------------------------------------

--
-- Table structure for table `prodi`
--

CREATE TABLE `prodi` (
  `prodi_id` int(11) NOT NULL,
  `nama_prodi` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `prodi`
--

INSERT INTO `prodi` (`prodi_id`, `nama_prodi`) VALUES
(1, 'Tehnik Informatika'),
(2, 'Sistem Informasi'),
(3, 'Desain Komunikasi Visual'),
(4, 'Animasi'),
(5, 'Ilmu Komunikasi');

-- --------------------------------------------------------

--
-- Table structure for table `sekolah`
--

CREATE TABLE `sekolah` (
  `id` int(11) NOT NULL,
  `asal_sekolah` varchar(100) DEFAULT NULL,
  `tahun_lulus` int(11) DEFAULT NULL,
  `nilai` decimal(5,2) DEFAULT NULL,
  `nim` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sekolah`
--

INSERT INTO `sekolah` (`id`, `asal_sekolah`, `tahun_lulus`, `nilai`, `nim`) VALUES
(1, 'SMA N 1 Sukolilo', 2020, 98.00, 'A12 - 59009');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('admin','user') DEFAULT 'user'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `role`) VALUES
(2, 'admin', 'admin123', 'admin'),
(6, 'A12 - 59009', 'JAWA15-05-2000', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`mhs_id`),
  ADD UNIQUE KEY `nama` (`nama`),
  ADD UNIQUE KEY `nim` (`nim`),
  ADD KEY `prodi_id` (`prodi_id`);

--
-- Indexes for table `prodi`
--
ALTER TABLE `prodi`
  ADD PRIMARY KEY (`prodi_id`);

--
-- Indexes for table `sekolah`
--
ALTER TABLE `sekolah`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nim` (`nim`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `mhs_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `prodi`
--
ALTER TABLE `prodi`
  MODIFY `prodi_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `sekolah`
--
ALTER TABLE `sekolah`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD CONSTRAINT `mahasiswa_ibfk_1` FOREIGN KEY (`prodi_id`) REFERENCES `prodi` (`prodi_id`);

--
-- Constraints for table `sekolah`
--
ALTER TABLE `sekolah`
  ADD CONSTRAINT `sekolah_ibfk_1` FOREIGN KEY (`nim`) REFERENCES `mahasiswa` (`nim`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
