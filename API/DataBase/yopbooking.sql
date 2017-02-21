-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mar 21 Février 2017 à 07:12
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
-- Structure de la table `event`
--

CREATE TABLE `event` (
  `id` int(11) NOT NULL,
  `title` varchar(120) NOT NULL,
  `user_id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `hour` tinyint(2) NOT NULL,
  `address` varchar(120) NOT NULL,
  `zipcode` int(5) NOT NULL,
  `city` varchar(120) NOT NULL,
  `comment` varchar(250) NOT NULL,
  `creationDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `event`
--

INSERT INTO `event` (`id`, `title`, `user_id`, `date`, `hour`, `address`, `zipcode`, `city`, `comment`, `creationDate`) VALUES
(1, 'Soirée LAN', 1, '2017-02-17', 23, '8 rue du clavier', 29250, 'St pol de léon', 'Apportez vos boissons les mecs !!! ', '2017-02-09'),
(2, 'Soirée gears4', 2, '2017-02-22', 22, '2 rue de la manette', 29200, 'Brest', 'Ouais', '2017-02-09'),
(3, 'Chips party', 1, '2017-02-24', 22, 'rue de la chips', 29600, 'montroulez', 'ça cwaque !', '2017-02-13'),
(12, 'event', 3, '2017-02-23', 16, 'rue de nekfeu', 75000, 'paname frate', 'wesh les frate!', '2017-02-16'),
(13, 'test', 12, '2017-02-24', 12, 'rue du test', 99999, 'testVille', 'je fais des tests', '2017-02-23'),
(20, 'Soiree pizza', 3, NULL, 20, 'avenue de la tagliatelle', 12345, 'Frateville', 'andiamo les frate !', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `registration`
--

CREATE TABLE `registration` (
  `id` int(11) NOT NULL,
  `id_event` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `firstname` varchar(120) NOT NULL,
  `lastname` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `firstname`, `lastname`) VALUES
(1, 'RiCo', 'Pouet'),
(2, 'Stal', 'Badass'),
(3, 'Giovanni', '1836'),
(4, 'azer', 'ty'),
(5, 'lulu', 'foufou'),
(6, 'nico', 'caca'),
(7, 'tanguy', 'jez'),
(8, 'erwan', 'minecraft'),
(9, 'tof', 'tennis'),
(10, 'gwégwé', 'lachatte'),
(11, 'remi', 'satan'),
(12, 'lionel', 'lechef'),
(13, 'j-p', 'vermouth');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`id`),
  ADD KEY `organisator_id` (`user_id`);

--
-- Index pour la table `registration`
--
ALTER TABLE `registration`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_event` (`id_event`),
  ADD KEY `id_user` (`id_user`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `event`
--
ALTER TABLE `event`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT pour la table `registration`
--
ALTER TABLE `registration`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `event_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `registration`
--
ALTER TABLE `registration`
  ADD CONSTRAINT `registration_ibfk_1` FOREIGN KEY (`id_event`) REFERENCES `event` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `registration_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
