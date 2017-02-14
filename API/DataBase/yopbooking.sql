-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mar 14 Février 2017 à 15:53
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `yopbooking`
--

-- --------------------------------------------------------

--
-- Structure de la table `events`
--

CREATE TABLE `events` (
  `id` int(11) NOT NULL,
  `title` varchar(120) NOT NULL,
  `organisator_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `hour` tinyint(2) NOT NULL,
  `adress` varchar(120) NOT NULL,
  `zipcode` int(5) NOT NULL,
  `city` varchar(120) NOT NULL,
  `comment` varchar(250) NOT NULL,
  `creationDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `events`
--

INSERT INTO `events` (`id`, `title`, `organisator_id`, `date`, `hour`, `adress`, `zipcode`, `city`, `comment`, `creationDate`) VALUES
(1, 'Soirée LAN', 1, '2017-02-17', 23, '8 rue du clavier', 29250, 'St pol de léon', 'Apportez vos boissons les mecs !!! ', '2017-02-09'),
(2, 'Soirée gears4', 2, '2017-02-22', 22, '2 rue de la manette', 29200, 'Brest', 'Ouais', '2017-02-09'),
(3, 'Chips party', 1, '2017-02-24', 22, 'rue de la chips', 29600, 'montroulez', 'ça cwaque !', '2017-02-13');

-- --------------------------------------------------------

--
-- Structure de la table `organisators`
--

CREATE TABLE `organisators` (
  `id` int(11) NOT NULL,
  `firstname` varchar(120) NOT NULL,
  `lastname` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `organisators`
--

INSERT INTO `organisators` (`id`, `firstname`, `lastname`) VALUES
(1, 'RiCo', 'Pouet'),
(2, 'Stal', 'Badass');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`),
  ADD KEY `organisator_id` (`organisator_id`);

--
-- Index pour la table `organisators`
--
ALTER TABLE `organisators`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `events`
--
ALTER TABLE `events`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `organisators`
--
ALTER TABLE `organisators`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `events`
--
ALTER TABLE `events`
  ADD CONSTRAINT `events_ibfk_1` FOREIGN KEY (`organisator_id`) REFERENCES `organisators` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
