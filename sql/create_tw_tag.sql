CREATE TABLE `tw_tag` (
  `tagId` int(11) NOT NULL AUTO_INCREMENT,
  `tagName` varchar(16) NOT NULL,
  PRIMARY KEY (`tagId`),
  UNIQUE KEY `tw_tag_tagId_uindex` (`tagId`),
  UNIQUE KEY `tw_tag_tagName_uindex` (`tagName`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;