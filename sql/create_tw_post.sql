CREATE TABLE `tw_post` (
  `postId` int(11) NOT NULL AUTO_INCREMENT,
  `postTitle` text,
  `postContents` text,
  `postDate` datetime DEFAULT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`postId`),
  UNIQUE KEY `postId_UNIQUE` (`postId`,`userId`),
  KEY `userId_idx` (`userId`),
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `tw_user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
