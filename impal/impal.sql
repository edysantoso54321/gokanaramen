-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 14 Nov 2018 pada 07.46
-- Versi Server: 5.6.16
-- PHP Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `impal`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `id_customer` varchar(5) NOT NULL,
  `nama` varchar(20) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `nomer_telp` varchar(13) DEFAULT NULL,
  `jenis_kelamin` char(1) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `agama` varchar(10) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  PRIMARY KEY (`id_customer`),
  KEY `customer_fk1` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `customer`
--

INSERT INTO `customer` (`id_customer`, `nama`, `alamat`, `nomer_telp`, `jenis_kelamin`, `email`, `agama`, `username`) VALUES
('11110', 'Hanif', 'Semarang', '081234362643', 'L', 'hanifrifki46@yahoo.com', 'Islam', 'Hanif0'),
('11111', 'Arif', 'Cirebon', '087824431645', 'L', 'Arifrh01@gmail.com', 'Islam', 'Arifh01'),
('11112', 'Edy', 'Surabaya', '082231546557', 'L', 'edysantoso@gmail.com', 'Islam', 'Edy12345'),
('11113', 'Gandhi', 'Batam', '08253146548', 'L', 'gandhia@gmail.com', 'Islam', 'Gandhim123'),
('11114', 'Cum', 'Cirebon', '08985878752', 'P', 'anniscum@gmail.com', 'Islam', 'Chumaedah012');

-- --------------------------------------------------------

--
-- Struktur dari tabel `detiltransaksi`
--

CREATE TABLE IF NOT EXISTS `detiltransaksi` (
  `id_transaksi` varchar(5) NOT NULL,
  `id_menu` varchar(5) NOT NULL,
  `Jumlah_barang` varchar(20) DEFAULT NULL,
  `Total_harga` mediumtext,
  `Status_pesan` varchar(20) DEFAULT NULL,
  KEY `DetilTransaksi_fk1` (`id_transaksi`),
  KEY `DetilTransaksi_fk2` (`id_menu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `gaji`
--

CREATE TABLE IF NOT EXISTS `gaji` (
  `Bulan` varchar(20) NOT NULL DEFAULT '',
  `Username` varchar(20) NOT NULL,
  `Jumlah_gaji` mediumtext,
  PRIMARY KEY (`Bulan`),
  KEY `gaji_fk1` (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `gaji`
--

INSERT INTO `gaji` (`Bulan`, `Username`, `Jumlah_gaji`) VALUES
('Agustus', 'Reza01', '2500000'),
('Desember;s', 'Reza01', '2000000'),
('November', 'Reza01', '2500000'),
('Oktober', 'Reza01', '2500000'),
('September', 'Reza01', '2500000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kehadiran`
--

CREATE TABLE IF NOT EXISTS `kehadiran` (
  `Tgl_Bln_Thn` date DEFAULT NULL,
  `id_pegawai` varchar(5) NOT NULL,
  `Status` varchar(20) DEFAULT NULL,
  KEY `kehadiran_fk1` (`id_pegawai`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kehadiran`
--

INSERT INTO `kehadiran` (`Tgl_Bln_Thn`, `id_pegawai`, `Status`) VALUES
('2018-07-01', 'P101', 'Hadir'),
('2018-07-01', 'P102', 'Hadir'),
('2018-07-01', 'P103', 'Hadir'),
('2018-07-01', 'P104', 'Hadir'),
('2018-07-01', 'P105', 'Hadir');

-- --------------------------------------------------------

--
-- Struktur dari tabel `menu`
--

CREATE TABLE IF NOT EXISTS `menu` (
  `id_menu` varchar(5) NOT NULL,
  `nama` varchar(20) DEFAULT NULL,
  `harga` mediumtext,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_menu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `menu`
--

INSERT INTO `menu` (`id_menu`, `nama`, `harga`, `status`) VALUES
('A410', 'Dendeng Gepuk', '10000', 'Tersedia'),
('A415', 'Ayam Bakar', '7000', 'Habis'),
('A422', 'Ayam Goreng', '7000', 'Tersedia'),
('A435', 'Sayur Asem', '8000', 'Tersedia'),
('A848', 'Nasi Putih', '8000', 'Tersedia');

-- --------------------------------------------------------

--
-- Struktur dari tabel `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `Id_message` varchar(5) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Message` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id_message`),
  KEY `message_fk1` (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `message`
--

INSERT INTO `message` (`Id_message`, `Username`, `Message`) VALUES
('M101', 'Hanif0', 'Restaurant nyaman dan makanannya pun berkualitas'),
('M102', 'Arifh01', 'Rstaurant sangat rapih'),
('M103', 'Edy12345', 'Restaurant nyaman untuk tempat ngodskuy'),
('M104', 'Gandhim123', 'Enak buat nongskuy'),
('M105', 'Chumaedah012', 'Restaurant yang dapat memberikan sebuah ide dalam tugas');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pegawai`
--

CREATE TABLE IF NOT EXISTS `pegawai` (
  `id_pegawai` varchar(5) NOT NULL,
  `nama` varchar(20) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `jenis_kelamin` char(1) DEFAULT NULL,
  `nomer_telp` varchar(13) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `jabatan` varchar(10) DEFAULT NULL,
  `agama` varchar(10) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  PRIMARY KEY (`id_pegawai`),
  KEY `pegawai_fk1` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `nama`, `alamat`, `jenis_kelamin`, `nomer_telp`, `email`, `jabatan`, `agama`, `username`) VALUES
('P101', 'Reza', 'Bekasi', 'L', '081675872102', 'reza@gmail.com', 'Kasir', 'Islam', 'Reza01'),
('P102', 'Diaz', 'Sukabumi', 'L', '081234567811', 'diaz@gmail.com', 'Koki', 'Islam', 'Diaz02'),
('P103', 'Irvan', 'Bogor', 'L', '087824431645', 'irvan@gmail.com', 'Pelayan', 'Islam', 'Irvan03'),
('P104', 'Ncis', 'Kaliurang', 'P', '089777888102', 'ncis@gmail.com', 'Koki', 'Islam', 'Ncis04'),
('P105', 'Cenjay', 'Bekasi', 'L', '0881112223334', 'cenjay@gmail.com', 'Pelayan', 'Islam', 'Cenjay05');

-- --------------------------------------------------------

--
-- Struktur dari tabel `stok_barang`
--

CREATE TABLE IF NOT EXISTS `stok_barang` (
  `Id_barang` varchar(5) NOT NULL,
  `Nama_barang` varchar(20) DEFAULT NULL,
  `Status` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`Id_barang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE IF NOT EXISTS `transaksi` (
  `id_transaksi` varchar(5) NOT NULL,
  `id_customer` varchar(5) NOT NULL,
  `tgl_transaksi` date DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_transaksi`),
  KEY `transaksi_fk1` (`id_customer`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_customer`, `tgl_transaksi`, `status`) VALUES
('TR01', '11110', '2018-02-12', 'Lunas'),
('TR02', '11110', '2018-02-13', 'Lunas'),
('TR03', '11112', '2018-02-14', 'Lunas'),
('TR04', '11111', '2018-02-14', 'Lunas'),
('TR05', '11111', '2018-02-15', 'Lunas');

-- --------------------------------------------------------

--
-- Struktur dari tabel `userpass`
--

CREATE TABLE IF NOT EXISTS `userpass` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `status` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `userpass`
--

INSERT INTO `userpass` (`username`, `password`, `status`) VALUES
('Arifh01', '1234ar', 'C'),
('Cenjay05', 'Cenjay999', 'P'),
('Chumaedah012', 'Chumaedah99', 'C'),
('Diaz02', 'Diaz98', 'P'),
('Edy12345', 'Edy001', 'C'),
('Gandhim123', 'Gabdhimm', 'C'),
('Hanif0', 'hanif98', 'C'),
('Irvan03', 'Irvan10', 'P'),
('Ncis04', 'Ncis98', 'P'),
('Reza01', 'Reza01', 'P');

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_fk1` FOREIGN KEY (`username`) REFERENCES `userpass` (`username`) ON DELETE CASCADE;

--
-- Ketidakleluasaan untuk tabel `detiltransaksi`
--
ALTER TABLE `detiltransaksi`
  ADD CONSTRAINT `DetilTransaksi_fk1` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`) ON DELETE CASCADE,
  ADD CONSTRAINT `DetilTransaksi_fk2` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`id_menu`) ON DELETE CASCADE;

--
-- Ketidakleluasaan untuk tabel `gaji`
--
ALTER TABLE `gaji`
  ADD CONSTRAINT `gaji_fk1` FOREIGN KEY (`Username`) REFERENCES `userpass` (`username`) ON DELETE CASCADE;

--
-- Ketidakleluasaan untuk tabel `kehadiran`
--
ALTER TABLE `kehadiran`
  ADD CONSTRAINT `kehadiran_fk1` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`) ON DELETE CASCADE;

--
-- Ketidakleluasaan untuk tabel `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `message_fk1` FOREIGN KEY (`Username`) REFERENCES `userpass` (`username`) ON DELETE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  ADD CONSTRAINT `pegawai_fk1` FOREIGN KEY (`username`) REFERENCES `userpass` (`username`) ON DELETE CASCADE;

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_fk1` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_customer`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
