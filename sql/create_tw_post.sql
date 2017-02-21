CREATE TABLE `tw_post` (
  `postId` int(11) NOT NULL AUTO_INCREMENT,
  `postTitle` text DEFAULT NULL,
  `postContents` text DEFAULT NULL,
  PRIMARY KEY (`userId`,`userName`),
  UNIQUE KEY `postId_UNIQUE` (`postId`),
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;