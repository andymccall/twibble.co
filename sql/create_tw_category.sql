CREATE TABLE `tw_category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `parentId` int(11) DEFAULT NULL,
  `categoryName` varchar(32) NOT NULL,
  PRIMARY KEY (`categoryId`),
  UNIQUE KEY `tw_category_categoryId_uindex` (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;