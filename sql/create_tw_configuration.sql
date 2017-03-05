CREATE TABLE `tw_configuration` (
  `blogId` int(11) NOT NULL AUTO_INCREMENT,
  `blogTitle` varchar(45) NOT NULL,
  `blogTagLine` varchar(150) DEFAULT NULL,
  `blogBaseURL` varchar(200) DEFAULT NULL,
  `numberOfPostsToDisplay` int(11) DEFAULT NULL,
  PRIMARY KEY (`blogId`),
  UNIQUE KEY `blogId_UNIQUE` (`blogId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
