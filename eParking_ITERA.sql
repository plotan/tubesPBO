-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 06, 2017 at 08:50 AM
-- Server version: 5.7.18-0ubuntu0.16.04.1
-- PHP Version: 7.0.15-0ubuntu0.16.04.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eParking_ITERA`
--

-- --------------------------------------------------------

--
-- Table structure for table `kendaraan`
--

CREATE TABLE `kendaraan` (
  `id` int(100) NOT NULL,
  `jenis` varchar(20) NOT NULL,
  `tarif_jam_pertama` double NOT NULL,
  `tarif_jam_berikut` double NOT NULL,
  `kapasitas` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kendaraan`
--

INSERT INTO `kendaraan` (`id`, `jenis`, `tarif_jam_pertama`, `tarif_jam_berikut`, `kapasitas`) VALUES
(1, 'Motor', 500, 900, 200),
(2, 'Mobil', 5000, 1500, 50);

-- --------------------------------------------------------

--
-- Table structure for table `parkir_kendaraan`
--

CREATE TABLE `parkir_kendaraan` (
  `tiket` int(100) NOT NULL,
  `nopol` varchar(10) NOT NULL,
  `jenis` enum('Motor','Mobil') NOT NULL,
  `waktu_masuk` datetime NOT NULL,
  `waktu_keluar` datetime DEFAULT NULL,
  `durasi` varchar(20) DEFAULT NULL,
  `total_tarif` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `parkir_kendaraan`
--

INSERT INTO `parkir_kendaraan` (`tiket`, `nopol`, `jenis`, `waktu_masuk`, `waktu_keluar`, `durasi`, `total_tarif`, `status`) VALUES
(115, 'H3LL', 'Motor', '2017-04-24 05:00:38', '2017-04-24 05:01:05', '0 Jam 0 Menit', '1000.0', 'Tidak Parkir'),
(116, 'L3RKUD', 'Mobil', '2017-04-24 05:20:11', '2017-04-24 19:19:40', '13 Jam 59 Menit', '18000.0', 'Tidak Parkir'),
(117, 'K1TING', 'Mobil', '2017-04-24 19:55:30', '2017-04-28 13:08:54', '29 Jam 13 Menit', '34000.0', 'Tidak Parkir'),
(118, 'BRE34658', 'Mobil', '2017-04-27 12:28:05', '2017-04-27 12:28:30', '0 Jam 0 Menit', '5000.0', 'Tidak Parkir'),
(119, 'ASD', 'Mobil', '2017-04-28 13:17:31', '2017-04-28 13:36:15', '0 Jam 0 Menit', '5000.0', 'Tidak Parkir'),
(120, 'AW', 'Motor', '2017-04-28 13:25:12', '2017-04-28 15:03:42', '0 Jam 0 Menit', '2000.0', 'Tidak Parkir'),
(121, 'SEVAK', 'Mobil', '2017-04-28 13:29:36', '2017-04-28 13:30:46', '0 Jam 1 Menit', '5000.0', 'Tidak Parkir'),
(122, 'AWAD', 'Mobil', '2017-04-28 13:32:17', '2017-04-28 13:34:38', '0 Jam 2 Menit', '5000.0', 'Tidak Parkir'),
(123, 'ASD', 'Mobil', '2017-04-28 13:35:27', '2017-04-28 13:36:15', '0 Jam 0 Menit', '5000.0', 'Tidak Parkir'),
(124, 'KUDA', 'Motor', '2017-04-28 13:39:54', '2017-04-28 13:40:39', '0 Jam 0 Menit', '2000.0', 'Tidak Parkir'),
(125, 'MNA', 'Mobil', '2017-04-28 13:47:13', '2017-04-28 13:51:06', '0 Jam 3 Menit', '5000.0', 'Tidak Parkir'),
(126, 'KA', 'Mobil', '2017-04-28 13:53:03', '2017-04-28 13:53:27', '0 Jam 0 Menit', '5000.0', 'Tidak Parkir'),
(127, 'ASDDF', 'Mobil', '2017-04-28 13:55:50', '2017-04-28 13:57:10', '0 Jam 1 Menit', '5000.0', 'Tidak Parkir'),
(128, 'KAA', 'Motor', '2017-04-28 13:57:31', '2017-04-28 14:06:49', '0 Jam 9 Menit', '2000.0', 'Tidak Parkir'),
(129, 'SEMVAK', 'Motor', '2017-04-28 14:08:34', '2017-04-28 14:18:07', '0 Jam 9 Menit', '2000.0', 'Tidak Parkir'),
(130, 'EA', 'Mobil', '2017-04-28 14:20:47', '2017-04-28 14:22:20', '0 Jam 1 Menit', '5000.0', 'Tidak Parkir'),
(131, 'J', 'Motor', '2017-04-28 14:35:00', '2017-04-28 14:35:59', '0 Jam 0 Menit', '2000.0', 'Tidak Parkir'),
(132, 'SEMPAK', 'Mobil', '2017-04-28 14:48:47', '2017-04-28 14:49:51', '0 Jam 1 Menit', '5000.0', 'Tidak Parkir'),
(133, 'AA', 'Mobil', '2017-04-28 14:50:28', '2017-05-01 22:56:57', '0 Jam 1 Menit', '5000.0', 'Tidak Parkir'),
(134, 'SA', 'Motor', '2017-04-28 14:54:39', '2017-04-28 14:56:08', '0 Jam 1 Menit', '2000.0', 'Tidak Parkir'),
(135, 'AWW', 'Mobil', '2017-04-28 14:58:03', '2017-04-28 15:01:20', '0 Jam 3 Menit', '5000.0', 'Tidak Parkir'),
(136, 'AW', 'Motor', '2017-04-28 15:02:57', '2017-04-28 15:03:42', '0 Jam 0 Menit', '2000.0', 'Tidak Parkir'),
(137, 'ASDASDA', 'Mobil', '2017-04-28 23:49:30', '2017-04-28 23:52:05', '0 Jam 2 Menit', '5000.0', 'Tidak Parkir'),
(138, '1', 'Motor', '2017-05-01 10:29:30', '2017-05-01 10:30:59', '0 Jam 1 Menit', '1000.0', 'Tidak Parkir'),
(139, 'A', 'Mobil', '2017-05-01 10:30:22', '2017-05-03 16:32:49', '41 Jam 34 Menit', '62500.0', 'Tidak Parkir'),
(140, 'A', 'Mobil', '2017-05-01 22:19:47', '2017-05-03 16:32:49', '41 Jam 34 Menit', '62500.0', 'Tidak Parkir'),
(141, 'B', 'Motor', '2017-05-01 22:29:58', '2017-05-01 22:33:54', '0 Jam 3 Menit', '1500.0', 'Tidak Parkir'),
(142, 'AA', 'Mobil', '2017-05-01 22:52:47', '2017-05-01 22:56:57', '0 Jam 1 Menit', '5000.0', 'Tidak Parkir'),
(143, 'AA', 'Mobil', '2017-05-01 22:54:58', '2017-05-01 22:56:57', '0 Jam 1 Menit', '5000.0', 'Tidak Parkir'),
(144, 'A', 'Motor', '2017-05-01 22:58:46', '2017-05-03 16:32:49', '41 Jam 34 Menit', '62500.0', 'Tidak Parkir'),
(145, 'SEDRFTGYH', 'Mobil', '2017-05-03 16:31:17', '2017-05-03 16:32:19', '0 Jam 1 Menit', '5000.0', 'Tidak Parkir');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(4) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `hak_akses` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `nama`, `username`, `password`, `hak_akses`) VALUES
(1, 'Ari Bambang', 'bambang', 'bambang', 'Admin'),
(2, 'Putra Abi', 'abi', 'abi', 'Petugas'),
(3, 'Benyamin Tupang', 'benstep', 'benstep', 'Petugas');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kendaraan`
--
ALTER TABLE `kendaraan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `parkir_kendaraan`
--
ALTER TABLE `parkir_kendaraan`
  ADD PRIMARY KEY (`tiket`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kendaraan`
--
ALTER TABLE `kendaraan`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `parkir_kendaraan`
--
ALTER TABLE `parkir_kendaraan`
  MODIFY `tiket` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=146;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
