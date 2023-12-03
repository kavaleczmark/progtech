-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2023. Dec 03. 04:17
-- Kiszolgáló verziója: 10.4.27-MariaDB
-- PHP verzió: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `wumpus`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `maps`
--

CREATE TABLE `maps` (
  `ID` int(12) NOT NULL,
  `name` varchar(128) NOT NULL,
  `size` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `maps`
--

INSERT INTO `maps` (`ID`, `name`, `size`) VALUES
(4, 'test', 6),
(10, 'bigmap', 20);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `objects`
--

CREATE TABLE `objects` (
  `ID` int(12) NOT NULL,
  `mapID` int(12) NOT NULL,
  `type` varchar(128) NOT NULL,
  `x` int(12) NOT NULL,
  `y` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `objects`
--

INSERT INTO `objects` (`ID`, `mapID`, `type`, `x`, `y`) VALUES
(1, 4, 'WALL', 0, 0),
(2, 4, 'WALL', 0, 1),
(3, 4, 'WALL', 0, 2),
(4, 4, 'WALL', 0, 3),
(5, 4, 'WALL', 0, 4),
(6, 4, 'WALL', 0, 5),
(7, 4, 'WALL', 1, 0),
(8, 4, 'EMPTY', 1, 1),
(9, 4, 'EMPTY', 1, 2),
(10, 4, 'EMPTY', 1, 3),
(11, 4, 'EMPTY', 1, 4),
(12, 4, 'WALL', 1, 5),
(13, 4, 'WALL', 2, 0),
(14, 4, 'EMPTY', 2, 1),
(15, 4, 'WUMPUS', 2, 2),
(16, 4, 'GOLD', 2, 3),
(17, 4, 'EMPTY', 2, 4),
(18, 4, 'WALL', 2, 5),
(19, 4, 'WALL', 3, 0),
(20, 4, 'HERO|E', 3, 1),
(21, 4, 'EMPTY', 3, 2),
(22, 4, 'EMPTY', 3, 3),
(23, 4, 'PIT', 3, 4),
(24, 4, 'WALL', 3, 5),
(25, 4, 'WALL', 4, 0),
(26, 4, 'EMPTY', 4, 1),
(27, 4, 'EMPTY', 4, 2),
(28, 4, 'EMPTY', 4, 3),
(29, 4, 'EMPTY', 4, 4),
(30, 4, 'WALL', 4, 5),
(31, 4, 'WALL', 5, 0),
(32, 4, 'WALL', 5, 1),
(33, 4, 'WALL', 5, 2),
(34, 4, 'WALL', 5, 3),
(35, 4, 'WALL', 5, 4),
(36, 4, 'WALL', 5, 5),
(37, 5, 'WALL', 0, 0),
(38, 5, 'WALL', 0, 1),
(39, 5, 'WALL', 0, 2),
(40, 5, 'WALL', 0, 3),
(41, 5, 'WALL', 0, 4),
(42, 5, 'WALL', 0, 5),
(43, 5, 'WALL', 1, 0),
(44, 5, 'EMPTY', 1, 1),
(45, 5, 'EMPTY', 1, 2),
(46, 5, 'EMPTY', 1, 3),
(47, 5, 'WALL', 1, 4),
(48, 5, 'WALL', 1, 5),
(49, 5, 'WALL', 2, 0),
(50, 5, 'EMPTY', 2, 1),
(51, 5, 'WUMPUS', 2, 2),
(52, 5, 'GOLD', 2, 3),
(53, 5, 'EMPTY', 2, 4),
(54, 5, 'WALL', 2, 5),
(55, 5, 'WALL', 3, 0),
(56, 5, 'HERO|E', 3, 1),
(57, 5, 'EMPTY', 3, 2),
(58, 5, 'EMPTY', 3, 3),
(59, 5, 'PIT', 3, 4),
(60, 5, 'WALL', 3, 5),
(61, 5, 'WALL', 4, 0),
(62, 5, 'EMPTY', 4, 1),
(63, 5, 'EMPTY', 4, 2),
(64, 5, 'EMPTY', 4, 3),
(65, 5, 'EMPTY', 4, 4),
(66, 5, 'WALL', 4, 5),
(67, 5, 'WALL', 5, 0),
(68, 5, 'WALL', 5, 1),
(69, 5, 'WALL', 5, 2),
(70, 5, 'WALL', 5, 3),
(71, 5, 'WALL', 5, 4),
(72, 5, 'WALL', 5, 5),
(73, 6, 'WALL', 0, 0),
(74, 6, 'WALL', 0, 1),
(75, 6, 'WALL', 0, 2),
(76, 6, 'WALL', 0, 3),
(77, 6, 'WALL', 0, 4),
(78, 6, 'WALL', 0, 5),
(79, 6, 'WALL', 1, 0),
(80, 6, 'EMPTY', 1, 1),
(81, 6, 'EMPTY', 1, 2),
(82, 6, 'EMPTY', 1, 3),
(83, 6, 'EMPTY', 1, 4),
(84, 6, 'WALL', 1, 5),
(85, 6, 'WALL', 2, 0),
(86, 6, 'EMPTY', 2, 1),
(87, 6, 'WUMPUS', 2, 2),
(88, 6, 'WALL', 2, 3),
(89, 6, 'EMPTY', 2, 4),
(90, 6, 'WALL', 2, 5),
(91, 6, 'WALL', 3, 0),
(92, 6, 'HERO|E', 3, 1),
(93, 6, 'EMPTY', 3, 2),
(94, 6, 'EMPTY', 3, 3),
(95, 6, 'PIT', 3, 4),
(96, 6, 'WALL', 3, 5),
(97, 6, 'WALL', 4, 0),
(98, 6, 'EMPTY', 4, 1),
(99, 6, 'EMPTY', 4, 2),
(100, 6, 'GOLD', 4, 3),
(101, 6, 'EMPTY', 4, 4),
(102, 6, 'WALL', 4, 5),
(103, 6, 'WALL', 5, 0),
(104, 6, 'WALL', 5, 1),
(105, 6, 'WALL', 5, 2),
(106, 6, 'WALL', 5, 3),
(107, 6, 'WALL', 5, 4),
(108, 6, 'WALL', 5, 5),
(109, 7, 'WALL', 0, 0),
(110, 7, 'WALL', 0, 1),
(111, 7, 'WALL', 0, 2),
(112, 7, 'WALL', 0, 3),
(113, 7, 'WALL', 0, 4),
(114, 7, 'WALL', 0, 5),
(115, 7, 'WALL', 0, 6),
(116, 7, 'WALL', 0, 7),
(117, 7, 'WALL', 1, 0),
(118, 7, 'EMPTY', 1, 1),
(119, 7, 'EMPTY', 1, 2),
(120, 7, 'EMPTY', 1, 3),
(121, 7, 'EMPTY', 1, 4),
(122, 7, 'EMPTY', 1, 5),
(123, 7, 'EMPTY', 1, 6),
(124, 7, 'WALL', 1, 7),
(125, 7, 'WALL', 2, 0),
(126, 7, 'HERO|E', 2, 1),
(127, 7, 'EMPTY', 2, 2),
(128, 7, 'GOLD', 2, 3),
(129, 7, 'EMPTY', 2, 4),
(130, 7, 'EMPTY', 2, 5),
(131, 7, 'EMPTY', 2, 6),
(132, 7, 'WALL', 2, 7),
(133, 7, 'WALL', 3, 0),
(134, 7, 'EMPTY', 3, 1),
(135, 7, 'EMPTY', 3, 2),
(136, 7, 'EMPTY', 3, 3),
(137, 7, 'WUMPUS', 3, 4),
(138, 7, 'EMPTY', 3, 5),
(139, 7, 'EMPTY', 3, 6),
(140, 7, 'WALL', 3, 7),
(141, 7, 'WALL', 4, 0),
(142, 7, 'EMPTY', 4, 1),
(143, 7, 'EMPTY', 4, 2),
(144, 7, 'EMPTY', 4, 3),
(145, 7, 'EMPTY', 4, 4),
(146, 7, 'EMPTY', 4, 5),
(147, 7, 'EMPTY', 4, 6),
(148, 7, 'WALL', 4, 7),
(149, 7, 'WALL', 5, 0),
(150, 7, 'EMPTY', 5, 1),
(151, 7, 'EMPTY', 5, 2),
(152, 7, 'EMPTY', 5, 3),
(153, 7, 'WALL', 5, 4),
(154, 7, 'EMPTY', 5, 5),
(155, 7, 'EMPTY', 5, 6),
(156, 7, 'WALL', 5, 7),
(157, 7, 'WALL', 6, 0),
(158, 7, 'EMPTY', 6, 1),
(159, 7, 'EMPTY', 6, 2),
(160, 7, 'EMPTY', 6, 3),
(161, 7, 'EMPTY', 6, 4),
(162, 7, 'EMPTY', 6, 5),
(163, 7, 'EMPTY', 6, 6),
(164, 7, 'WALL', 6, 7),
(165, 7, 'WALL', 7, 0),
(166, 7, 'WALL', 7, 1),
(167, 7, 'WALL', 7, 2),
(168, 7, 'WALL', 7, 3),
(169, 7, 'WALL', 7, 4),
(170, 7, 'WALL', 7, 5),
(171, 7, 'WALL', 7, 6),
(172, 7, 'WALL', 7, 7),
(173, 8, 'WALL', 0, 0),
(174, 8, 'WALL', 0, 1),
(175, 8, 'WALL', 0, 2),
(176, 8, 'WALL', 0, 3),
(177, 8, 'WALL', 0, 4),
(178, 8, 'WALL', 0, 5),
(179, 8, 'WALL', 1, 0),
(180, 8, 'EMPTY', 1, 1),
(181, 8, 'EMPTY', 1, 2),
(182, 8, 'EMPTY', 1, 3),
(183, 8, 'EMPTY', 1, 4),
(184, 8, 'WALL', 1, 5),
(185, 8, 'WALL', 2, 0),
(186, 8, 'EMPTY', 2, 1),
(187, 8, 'WUMPUS', 2, 2),
(188, 8, 'GOLD', 2, 3),
(189, 8, 'EMPTY', 2, 4),
(190, 8, 'WALL', 2, 5),
(191, 8, 'WALL', 3, 0),
(192, 8, 'PIT', 3, 1),
(193, 8, 'EMPTY', 3, 2),
(194, 8, 'EMPTY', 3, 3),
(195, 8, 'PIT', 3, 4),
(196, 8, 'WALL', 3, 5),
(197, 8, 'WALL', 4, 0),
(198, 8, 'EMPTY', 4, 1),
(199, 8, 'EMPTY', 4, 2),
(200, 8, 'EMPTY', 4, 3),
(201, 8, 'EMPTY', 4, 4),
(202, 8, 'WALL', 4, 5),
(203, 8, 'WALL', 5, 0),
(204, 8, 'WALL', 5, 1),
(205, 8, 'WALL', 5, 2),
(206, 8, 'WALL', 5, 3),
(207, 8, 'WALL', 5, 4),
(208, 8, 'WALL', 5, 5),
(209, 9, 'WALL', 0, 0),
(210, 9, 'WALL', 0, 1),
(211, 9, 'WALL', 0, 2),
(212, 9, 'WALL', 0, 3),
(213, 9, 'WALL', 0, 4),
(214, 9, 'WALL', 0, 5),
(215, 9, 'WALL', 1, 0),
(216, 9, 'EMPTY', 1, 1),
(217, 9, 'EMPTY', 1, 2),
(218, 9, 'EMPTY', 1, 3),
(219, 9, 'EMPTY', 1, 4),
(220, 9, 'WALL', 1, 5),
(221, 9, 'WALL', 2, 0),
(222, 9, 'EMPTY', 2, 1),
(223, 9, 'EMPTY', 2, 2),
(224, 9, 'WUMPUS', 2, 3),
(225, 9, 'EMPTY', 2, 4),
(226, 9, 'WALL', 2, 5),
(227, 9, 'WALL', 3, 0),
(228, 9, 'EMPTY', 3, 1),
(229, 9, 'EMPTY', 3, 2),
(230, 9, 'EMPTY', 3, 3),
(231, 9, 'EMPTY', 3, 4),
(232, 9, 'WALL', 3, 5),
(233, 9, 'WALL', 4, 0),
(234, 9, 'HERO|E', 4, 1),
(235, 9, 'EMPTY', 4, 2),
(236, 9, 'EMPTY', 4, 3),
(237, 9, 'EMPTY', 4, 4),
(238, 9, 'WALL', 4, 5),
(239, 9, 'WALL', 5, 0),
(240, 9, 'WALL', 5, 1),
(241, 9, 'WALL', 5, 2),
(242, 9, 'WALL', 5, 3),
(243, 9, 'WALL', 5, 4),
(244, 9, 'WALL', 5, 5),
(245, 10, 'WALL', 0, 0),
(246, 10, 'WALL', 0, 1),
(247, 10, 'WALL', 0, 2),
(248, 10, 'WALL', 0, 3),
(249, 10, 'WALL', 0, 4),
(250, 10, 'WALL', 0, 5),
(251, 10, 'WALL', 0, 6),
(252, 10, 'WALL', 0, 7),
(253, 10, 'WALL', 0, 8),
(254, 10, 'WALL', 0, 9),
(255, 10, 'WALL', 0, 10),
(256, 10, 'WALL', 0, 11),
(257, 10, 'WALL', 0, 12),
(258, 10, 'WALL', 0, 13),
(259, 10, 'WALL', 0, 14),
(260, 10, 'WALL', 0, 15),
(261, 10, 'WALL', 0, 16),
(262, 10, 'WALL', 0, 17),
(263, 10, 'WALL', 0, 18),
(264, 10, 'WALL', 0, 19),
(265, 10, 'WALL', 1, 0),
(266, 10, 'EMPTY', 1, 1),
(267, 10, 'EMPTY', 1, 2),
(268, 10, 'EMPTY', 1, 3),
(269, 10, 'EMPTY', 1, 4),
(270, 10, 'EMPTY', 1, 5),
(271, 10, 'EMPTY', 1, 6),
(272, 10, 'EMPTY', 1, 7),
(273, 10, 'EMPTY', 1, 8),
(274, 10, 'EMPTY', 1, 9),
(275, 10, 'EMPTY', 1, 10),
(276, 10, 'EMPTY', 1, 11),
(277, 10, 'EMPTY', 1, 12),
(278, 10, 'EMPTY', 1, 13),
(279, 10, 'EMPTY', 1, 14),
(280, 10, 'EMPTY', 1, 15),
(281, 10, 'EMPTY', 1, 16),
(282, 10, 'EMPTY', 1, 17),
(283, 10, 'EMPTY', 1, 18),
(284, 10, 'WALL', 1, 19),
(285, 10, 'WALL', 2, 0),
(286, 10, 'EMPTY', 2, 1),
(287, 10, 'EMPTY', 2, 2),
(288, 10, 'EMPTY', 2, 3),
(289, 10, 'EMPTY', 2, 4),
(290, 10, 'EMPTY', 2, 5),
(291, 10, 'EMPTY', 2, 6),
(292, 10, 'EMPTY', 2, 7),
(293, 10, 'EMPTY', 2, 8),
(294, 10, 'EMPTY', 2, 9),
(295, 10, 'EMPTY', 2, 10),
(296, 10, 'EMPTY', 2, 11),
(297, 10, 'EMPTY', 2, 12),
(298, 10, 'EMPTY', 2, 13),
(299, 10, 'EMPTY', 2, 14),
(300, 10, 'EMPTY', 2, 15),
(301, 10, 'EMPTY', 2, 16),
(302, 10, 'EMPTY', 2, 17),
(303, 10, 'EMPTY', 2, 18),
(304, 10, 'WALL', 2, 19),
(305, 10, 'WALL', 3, 0),
(306, 10, 'EMPTY', 3, 1),
(307, 10, 'EMPTY', 3, 2),
(308, 10, 'EMPTY', 3, 3),
(309, 10, 'EMPTY', 3, 4),
(310, 10, 'EMPTY', 3, 5),
(311, 10, 'EMPTY', 3, 6),
(312, 10, 'EMPTY', 3, 7),
(313, 10, 'EMPTY', 3, 8),
(314, 10, 'EMPTY', 3, 9),
(315, 10, 'EMPTY', 3, 10),
(316, 10, 'EMPTY', 3, 11),
(317, 10, 'EMPTY', 3, 12),
(318, 10, 'EMPTY', 3, 13),
(319, 10, 'EMPTY', 3, 14),
(320, 10, 'EMPTY', 3, 15),
(321, 10, 'EMPTY', 3, 16),
(322, 10, 'EMPTY', 3, 17),
(323, 10, 'EMPTY', 3, 18),
(324, 10, 'WALL', 3, 19),
(325, 10, 'WALL', 4, 0),
(326, 10, 'EMPTY', 4, 1),
(327, 10, 'EMPTY', 4, 2),
(328, 10, 'EMPTY', 4, 3),
(329, 10, 'EMPTY', 4, 4),
(330, 10, 'EMPTY', 4, 5),
(331, 10, 'EMPTY', 4, 6),
(332, 10, 'EMPTY', 4, 7),
(333, 10, 'EMPTY', 4, 8),
(334, 10, 'EMPTY', 4, 9),
(335, 10, 'EMPTY', 4, 10),
(336, 10, 'EMPTY', 4, 11),
(337, 10, 'EMPTY', 4, 12),
(338, 10, 'EMPTY', 4, 13),
(339, 10, 'EMPTY', 4, 14),
(340, 10, 'EMPTY', 4, 15),
(341, 10, 'EMPTY', 4, 16),
(342, 10, 'WUMPUS', 4, 17),
(343, 10, 'EMPTY', 4, 18),
(344, 10, 'WALL', 4, 19),
(345, 10, 'WALL', 5, 0),
(346, 10, 'HERO|E', 5, 1),
(347, 10, 'EMPTY', 5, 2),
(348, 10, 'EMPTY', 5, 3),
(349, 10, 'EMPTY', 5, 4),
(350, 10, 'EMPTY', 5, 5),
(351, 10, 'EMPTY', 5, 6),
(352, 10, 'EMPTY', 5, 7),
(353, 10, 'EMPTY', 5, 8),
(354, 10, 'EMPTY', 5, 9),
(355, 10, 'EMPTY', 5, 10),
(356, 10, 'EMPTY', 5, 11),
(357, 10, 'EMPTY', 5, 12),
(358, 10, 'EMPTY', 5, 13),
(359, 10, 'EMPTY', 5, 14),
(360, 10, 'EMPTY', 5, 15),
(361, 10, 'EMPTY', 5, 16),
(362, 10, 'EMPTY', 5, 17),
(363, 10, 'EMPTY', 5, 18),
(364, 10, 'WALL', 5, 19),
(365, 10, 'WALL', 6, 0),
(366, 10, 'EMPTY', 6, 1),
(367, 10, 'EMPTY', 6, 2),
(368, 10, 'GOLD', 6, 3),
(369, 10, 'EMPTY', 6, 4),
(370, 10, 'EMPTY', 6, 5),
(371, 10, 'EMPTY', 6, 6),
(372, 10, 'EMPTY', 6, 7),
(373, 10, 'EMPTY', 6, 8),
(374, 10, 'EMPTY', 6, 9),
(375, 10, 'EMPTY', 6, 10),
(376, 10, 'EMPTY', 6, 11),
(377, 10, 'EMPTY', 6, 12),
(378, 10, 'EMPTY', 6, 13),
(379, 10, 'EMPTY', 6, 14),
(380, 10, 'EMPTY', 6, 15),
(381, 10, 'EMPTY', 6, 16),
(382, 10, 'EMPTY', 6, 17),
(383, 10, 'EMPTY', 6, 18),
(384, 10, 'WALL', 6, 19),
(385, 10, 'WALL', 7, 0),
(386, 10, 'EMPTY', 7, 1),
(387, 10, 'EMPTY', 7, 2),
(388, 10, 'EMPTY', 7, 3),
(389, 10, 'EMPTY', 7, 4),
(390, 10, 'EMPTY', 7, 5),
(391, 10, 'EMPTY', 7, 6),
(392, 10, 'EMPTY', 7, 7),
(393, 10, 'EMPTY', 7, 8),
(394, 10, 'EMPTY', 7, 9),
(395, 10, 'EMPTY', 7, 10),
(396, 10, 'EMPTY', 7, 11),
(397, 10, 'EMPTY', 7, 12),
(398, 10, 'EMPTY', 7, 13),
(399, 10, 'EMPTY', 7, 14),
(400, 10, 'EMPTY', 7, 15),
(401, 10, 'EMPTY', 7, 16),
(402, 10, 'EMPTY', 7, 17),
(403, 10, 'EMPTY', 7, 18),
(404, 10, 'WALL', 7, 19),
(405, 10, 'WALL', 8, 0),
(406, 10, 'EMPTY', 8, 1),
(407, 10, 'EMPTY', 8, 2),
(408, 10, 'EMPTY', 8, 3),
(409, 10, 'EMPTY', 8, 4),
(410, 10, 'EMPTY', 8, 5),
(411, 10, 'EMPTY', 8, 6),
(412, 10, 'EMPTY', 8, 7),
(413, 10, 'EMPTY', 8, 8),
(414, 10, 'EMPTY', 8, 9),
(415, 10, 'EMPTY', 8, 10),
(416, 10, 'EMPTY', 8, 11),
(417, 10, 'EMPTY', 8, 12),
(418, 10, 'EMPTY', 8, 13),
(419, 10, 'EMPTY', 8, 14),
(420, 10, 'EMPTY', 8, 15),
(421, 10, 'EMPTY', 8, 16),
(422, 10, 'EMPTY', 8, 17),
(423, 10, 'EMPTY', 8, 18),
(424, 10, 'WALL', 8, 19),
(425, 10, 'WALL', 9, 0),
(426, 10, 'EMPTY', 9, 1),
(427, 10, 'EMPTY', 9, 2),
(428, 10, 'EMPTY', 9, 3),
(429, 10, 'EMPTY', 9, 4),
(430, 10, 'EMPTY', 9, 5),
(431, 10, 'EMPTY', 9, 6),
(432, 10, 'EMPTY', 9, 7),
(433, 10, 'EMPTY', 9, 8),
(434, 10, 'EMPTY', 9, 9),
(435, 10, 'EMPTY', 9, 10),
(436, 10, 'EMPTY', 9, 11),
(437, 10, 'EMPTY', 9, 12),
(438, 10, 'EMPTY', 9, 13),
(439, 10, 'EMPTY', 9, 14),
(440, 10, 'EMPTY', 9, 15),
(441, 10, 'EMPTY', 9, 16),
(442, 10, 'EMPTY', 9, 17),
(443, 10, 'EMPTY', 9, 18),
(444, 10, 'WALL', 9, 19),
(445, 10, 'WALL', 10, 0),
(446, 10, 'EMPTY', 10, 1),
(447, 10, 'EMPTY', 10, 2),
(448, 10, 'EMPTY', 10, 3),
(449, 10, 'EMPTY', 10, 4),
(450, 10, 'EMPTY', 10, 5),
(451, 10, 'EMPTY', 10, 6),
(452, 10, 'EMPTY', 10, 7),
(453, 10, 'EMPTY', 10, 8),
(454, 10, 'EMPTY', 10, 9),
(455, 10, 'EMPTY', 10, 10),
(456, 10, 'EMPTY', 10, 11),
(457, 10, 'EMPTY', 10, 12),
(458, 10, 'EMPTY', 10, 13),
(459, 10, 'EMPTY', 10, 14),
(460, 10, 'EMPTY', 10, 15),
(461, 10, 'EMPTY', 10, 16),
(462, 10, 'EMPTY', 10, 17),
(463, 10, 'EMPTY', 10, 18),
(464, 10, 'WALL', 10, 19),
(465, 10, 'WALL', 11, 0),
(466, 10, 'EMPTY', 11, 1),
(467, 10, 'EMPTY', 11, 2),
(468, 10, 'EMPTY', 11, 3),
(469, 10, 'EMPTY', 11, 4),
(470, 10, 'EMPTY', 11, 5),
(471, 10, 'EMPTY', 11, 6),
(472, 10, 'EMPTY', 11, 7),
(473, 10, 'EMPTY', 11, 8),
(474, 10, 'EMPTY', 11, 9),
(475, 10, 'EMPTY', 11, 10),
(476, 10, 'EMPTY', 11, 11),
(477, 10, 'EMPTY', 11, 12),
(478, 10, 'EMPTY', 11, 13),
(479, 10, 'EMPTY', 11, 14),
(480, 10, 'EMPTY', 11, 15),
(481, 10, 'EMPTY', 11, 16),
(482, 10, 'EMPTY', 11, 17),
(483, 10, 'EMPTY', 11, 18),
(484, 10, 'WALL', 11, 19),
(485, 10, 'WALL', 12, 0),
(486, 10, 'EMPTY', 12, 1),
(487, 10, 'EMPTY', 12, 2),
(488, 10, 'EMPTY', 12, 3),
(489, 10, 'EMPTY', 12, 4),
(490, 10, 'EMPTY', 12, 5),
(491, 10, 'EMPTY', 12, 6),
(492, 10, 'EMPTY', 12, 7),
(493, 10, 'EMPTY', 12, 8),
(494, 10, 'EMPTY', 12, 9),
(495, 10, 'EMPTY', 12, 10),
(496, 10, 'EMPTY', 12, 11),
(497, 10, 'WUMPUS', 12, 12),
(498, 10, 'EMPTY', 12, 13),
(499, 10, 'EMPTY', 12, 14),
(500, 10, 'EMPTY', 12, 15),
(501, 10, 'EMPTY', 12, 16),
(502, 10, 'EMPTY', 12, 17),
(503, 10, 'EMPTY', 12, 18),
(504, 10, 'WALL', 12, 19),
(505, 10, 'WALL', 13, 0),
(506, 10, 'EMPTY', 13, 1),
(507, 10, 'PIT', 13, 2),
(508, 10, 'EMPTY', 13, 3),
(509, 10, 'EMPTY', 13, 4),
(510, 10, 'EMPTY', 13, 5),
(511, 10, 'EMPTY', 13, 6),
(512, 10, 'EMPTY', 13, 7),
(513, 10, 'EMPTY', 13, 8),
(514, 10, 'EMPTY', 13, 9),
(515, 10, 'EMPTY', 13, 10),
(516, 10, 'EMPTY', 13, 11),
(517, 10, 'EMPTY', 13, 12),
(518, 10, 'EMPTY', 13, 13),
(519, 10, 'EMPTY', 13, 14),
(520, 10, 'EMPTY', 13, 15),
(521, 10, 'EMPTY', 13, 16),
(522, 10, 'EMPTY', 13, 17),
(523, 10, 'EMPTY', 13, 18),
(524, 10, 'WALL', 13, 19),
(525, 10, 'WALL', 14, 0),
(526, 10, 'EMPTY', 14, 1),
(527, 10, 'EMPTY', 14, 2),
(528, 10, 'EMPTY', 14, 3),
(529, 10, 'EMPTY', 14, 4),
(530, 10, 'EMPTY', 14, 5),
(531, 10, 'EMPTY', 14, 6),
(532, 10, 'EMPTY', 14, 7),
(533, 10, 'EMPTY', 14, 8),
(534, 10, 'EMPTY', 14, 9),
(535, 10, 'EMPTY', 14, 10),
(536, 10, 'EMPTY', 14, 11),
(537, 10, 'EMPTY', 14, 12),
(538, 10, 'EMPTY', 14, 13),
(539, 10, 'EMPTY', 14, 14),
(540, 10, 'EMPTY', 14, 15),
(541, 10, 'EMPTY', 14, 16),
(542, 10, 'EMPTY', 14, 17),
(543, 10, 'EMPTY', 14, 18),
(544, 10, 'WALL', 14, 19),
(545, 10, 'WALL', 15, 0),
(546, 10, 'EMPTY', 15, 1),
(547, 10, 'EMPTY', 15, 2),
(548, 10, 'EMPTY', 15, 3),
(549, 10, 'EMPTY', 15, 4),
(550, 10, 'EMPTY', 15, 5),
(551, 10, 'EMPTY', 15, 6),
(552, 10, 'EMPTY', 15, 7),
(553, 10, 'EMPTY', 15, 8),
(554, 10, 'EMPTY', 15, 9),
(555, 10, 'EMPTY', 15, 10),
(556, 10, 'EMPTY', 15, 11),
(557, 10, 'EMPTY', 15, 12),
(558, 10, 'EMPTY', 15, 13),
(559, 10, 'EMPTY', 15, 14),
(560, 10, 'EMPTY', 15, 15),
(561, 10, 'EMPTY', 15, 16),
(562, 10, 'EMPTY', 15, 17),
(563, 10, 'EMPTY', 15, 18),
(564, 10, 'WALL', 15, 19),
(565, 10, 'WALL', 16, 0),
(566, 10, 'EMPTY', 16, 1),
(567, 10, 'EMPTY', 16, 2),
(568, 10, 'EMPTY', 16, 3),
(569, 10, 'EMPTY', 16, 4),
(570, 10, 'EMPTY', 16, 5),
(571, 10, 'WUMPUS', 16, 6),
(572, 10, 'EMPTY', 16, 7),
(573, 10, 'EMPTY', 16, 8),
(574, 10, 'EMPTY', 16, 9),
(575, 10, 'EMPTY', 16, 10),
(576, 10, 'EMPTY', 16, 11),
(577, 10, 'EMPTY', 16, 12),
(578, 10, 'EMPTY', 16, 13),
(579, 10, 'EMPTY', 16, 14),
(580, 10, 'EMPTY', 16, 15),
(581, 10, 'EMPTY', 16, 16),
(582, 10, 'EMPTY', 16, 17),
(583, 10, 'EMPTY', 16, 18),
(584, 10, 'WALL', 16, 19),
(585, 10, 'WALL', 17, 0),
(586, 10, 'EMPTY', 17, 1),
(587, 10, 'EMPTY', 17, 2),
(588, 10, 'EMPTY', 17, 3),
(589, 10, 'EMPTY', 17, 4),
(590, 10, 'EMPTY', 17, 5),
(591, 10, 'EMPTY', 17, 6),
(592, 10, 'EMPTY', 17, 7),
(593, 10, 'EMPTY', 17, 8),
(594, 10, 'EMPTY', 17, 9),
(595, 10, 'EMPTY', 17, 10),
(596, 10, 'EMPTY', 17, 11),
(597, 10, 'EMPTY', 17, 12),
(598, 10, 'EMPTY', 17, 13),
(599, 10, 'EMPTY', 17, 14),
(600, 10, 'EMPTY', 17, 15),
(601, 10, 'EMPTY', 17, 16),
(602, 10, 'EMPTY', 17, 17),
(603, 10, 'EMPTY', 17, 18),
(604, 10, 'WALL', 17, 19),
(605, 10, 'WALL', 18, 0),
(606, 10, 'EMPTY', 18, 1),
(607, 10, 'EMPTY', 18, 2),
(608, 10, 'EMPTY', 18, 3),
(609, 10, 'EMPTY', 18, 4),
(610, 10, 'EMPTY', 18, 5),
(611, 10, 'EMPTY', 18, 6),
(612, 10, 'EMPTY', 18, 7),
(613, 10, 'EMPTY', 18, 8),
(614, 10, 'EMPTY', 18, 9),
(615, 10, 'EMPTY', 18, 10),
(616, 10, 'EMPTY', 18, 11),
(617, 10, 'EMPTY', 18, 12),
(618, 10, 'EMPTY', 18, 13),
(619, 10, 'EMPTY', 18, 14),
(620, 10, 'EMPTY', 18, 15),
(621, 10, 'EMPTY', 18, 16),
(622, 10, 'EMPTY', 18, 17),
(623, 10, 'EMPTY', 18, 18),
(624, 10, 'WALL', 18, 19),
(625, 10, 'WALL', 19, 0),
(626, 10, 'WALL', 19, 1),
(627, 10, 'WALL', 19, 2),
(628, 10, 'WALL', 19, 3),
(629, 10, 'WALL', 19, 4),
(630, 10, 'WALL', 19, 5),
(631, 10, 'WALL', 19, 6),
(632, 10, 'WALL', 19, 7),
(633, 10, 'WALL', 19, 8),
(634, 10, 'WALL', 19, 9),
(635, 10, 'WALL', 19, 10),
(636, 10, 'WALL', 19, 11),
(637, 10, 'WALL', 19, 12),
(638, 10, 'WALL', 19, 13),
(639, 10, 'WALL', 19, 14),
(640, 10, 'WALL', 19, 15),
(641, 10, 'WALL', 19, 16),
(642, 10, 'WALL', 19, 17),
(643, 10, 'WALL', 19, 18),
(644, 10, 'WALL', 19, 19);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `players`
--

CREATE TABLE `players` (
  `name` varchar(128) NOT NULL,
  `score` int(12) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `players`
--

INSERT INTO `players` (`name`, `score`) VALUES
('mark', 9),
('zsolt', 1);

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `maps`
--
ALTER TABLE `maps`
  ADD PRIMARY KEY (`ID`);

--
-- A tábla indexei `objects`
--
ALTER TABLE `objects`
  ADD PRIMARY KEY (`ID`);

--
-- A tábla indexei `players`
--
ALTER TABLE `players`
  ADD PRIMARY KEY (`name`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `maps`
--
ALTER TABLE `maps`
  MODIFY `ID` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT a táblához `objects`
--
ALTER TABLE `objects`
  MODIFY `ID` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=645;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
