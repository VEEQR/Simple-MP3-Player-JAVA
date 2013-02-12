-- phpMyAdmin SQL Dump
-- version 2.11.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 12, 2013 at 10:37 PM
-- Server version: 5.0.51
-- PHP Version: 5.2.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `Musik`
--

-- --------------------------------------------------------

--
-- Table structure for table `daftarmusik`
--

CREATE TABLE IF NOT EXISTS `daftarmusik` (
  `id` int(11) NOT NULL auto_increment,
  `nama_lagu` varchar(50) NOT NULL,
  `lokasi_lagu` varchar(300) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `daftarmusik`
--

INSERT INTO `daftarmusik` (`id`, `nama_lagu`, `lokasi_lagu`) VALUES
(2, 'Eagles - Hotel California (Live).mp3', 'D:\\Entertainment\\Lagu\\Barat\\Eagles - Hotel California (Live).mp3'),
(4, 'OST SuckSeed.mp3', 'D:\\Entertainment\\Lagu\\Other song\\OST SuckSeed.mp3');
