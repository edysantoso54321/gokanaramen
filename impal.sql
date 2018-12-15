-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 06 Des 2018 pada 03.19
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
  `id_customer` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(20) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `nomer_telp` varchar(13) DEFAULT NULL,
  `jenis_kelamin` char(1) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `agama` varchar(10) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  PRIMARY KEY (`id_customer`),
  KEY `customer_fk1` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data untuk tabel `customer`
--

INSERT INTO `customer` (`id_customer`, `nama`, `alamat`, `nomer_telp`, `jenis_kelamin`, `email`, `agama`, `username`) VALUES
(1, 'a', 'a', '081515279743', 'L', 'a', 'Islam', 'a');

-- --------------------------------------------------------

--
-- Struktur dari tabel `detiltransaksi`
--

CREATE TABLE IF NOT EXISTS `detiltransaksi` (
  `id_transaksi` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `Jumlah_barang` varchar(20) DEFAULT NULL,
  `Total_harga` mediumtext,
  `Status_pesan` varchar(20) DEFAULT NULL,
  KEY `DetilTransaksi_fk1` (`id_transaksi`),
  KEY `DetilTransaksi_fk2` (`id_menu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `detiltransaksi`
--

INSERT INTO `detiltransaksi` (`id_transaksi`, `id_menu`, `Jumlah_barang`, `Total_harga`, `Status_pesan`) VALUES
(2, 1, NULL, NULL, NULL);

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
  `id_pegawai` int(11) NOT NULL,
  `Status` varchar(20) DEFAULT NULL,
  KEY `kehadiran_fk1` (`id_pegawai`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `menu`
--

CREATE TABLE IF NOT EXISTS `menu` (
  `id_menu` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(20) DEFAULT NULL,
  `harga` mediumtext,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_menu`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data untuk tabel `menu`
--

INSERT INTO `menu` (`id_menu`, `nama`, `harga`, `status`) VALUES
(1, 'ikan', '10000', 'ada');

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
  `id_pegawai` int(11) NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `stok_barang`
--

CREATE TABLE IF NOT EXISTS `stok_barang` (
  `Id_barang` int(11) NOT NULL AUTO_INCREMENT,
  `Nama_barang` varchar(20) DEFAULT NULL,
  `Status` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`Id_barang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE IF NOT EXISTS `transaksi` (
  `id_transaksi` int(11) NOT NULL AUTO_INCREMENT,
  `id_customer` int(11) NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_transaksi`),
  KEY `transaksi_fk1` (`id_customer`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_customer`, `status`) VALUES
(1, 1, 'lunas'),
(2, 1, 'lunas');

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
('a', 'a', 'c'),
('admin', 'admin', 'a'),
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
