CREATE TABLE `tw_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `userName` varchar(45) NOT NULL,
  `displayName` varchar(16) DEFAULT NULL,
  `emailAddress` varchar(100) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `userType` varchar(16) NOT NULL,
  `userStatus` varchar(16) NOT NULL,
  PRIMARY KEY (`userId`,`userName`),
  UNIQUE KEY `userId_UNIQUE` (`userId`),
  UNIQUE KEY `userName_UNIQUE` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;