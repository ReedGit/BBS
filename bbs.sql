/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50623
Source Host           : 127.0.0.1:3306
Source Database       : bbs

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2015-06-07 19:13:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentId` int(255) NOT NULL AUTO_INCREMENT,
  `commentNote` int(255) NOT NULL,
  `commentContent` text NOT NULL,
  `commentAuthor` varchar(255) NOT NULL,
  `commentTime` datetime NOT NULL,
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '8', '围观学习', 'Reed', '2015-06-01 15:21:01');
INSERT INTO `comment` VALUES ('4', '4', '看个人情况吧', 'Reed', '2015-06-04 19:10:54');
INSERT INTO `comment` VALUES ('11', '8', '前排围观', '颜文青', '2015-06-04 20:18:04');
INSERT INTO `comment` VALUES ('20', '8', '不知道', '111111', '2015-06-07 16:54:58');
INSERT INTO `comment` VALUES ('21', '13', '我是来找书的', 'Hallo', '2015-06-07 19:04:48');
INSERT INTO `comment` VALUES ('22', '12', '不懂也能进来么', 'Hallo', '2015-06-07 19:05:11');
INSERT INTO `comment` VALUES ('23', '15', '同求', '颜文青', '2015-06-07 19:08:42');
INSERT INTO `comment` VALUES ('24', '16', '自己顶上去', '颜文青', '2015-06-07 19:08:56');

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
  `noteId` int(255) NOT NULL AUTO_INCREMENT,
  `noteTitle` text NOT NULL,
  `noteContent` text NOT NULL,
  `noteAuthor` varchar(255) NOT NULL,
  `noteTime` datetime NOT NULL,
  `noteClassify` varchar(255) NOT NULL,
  PRIMARY KEY (`noteId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES ('4', 'c++', 'c++语言好学么', '111111', '2015-05-29 19:29:36', 'C++');
INSERT INTO `note` VALUES ('8', 'html5', 'html5和html的差别', 'tangpan', '2015-05-29 21:21:25', 'HTML5');
INSERT INTO `note` VALUES ('12', '懂oc的来看看', 'object-c怎么实现内存管理', 'Reed', '2015-06-07 18:58:41', 'Object-C');
INSERT INTO `note` VALUES ('13', 'android的ui设计', '求推荐android ui设计方面的书籍', 'Reed', '2015-06-07 18:59:31', '其他');
INSERT INTO `note` VALUES ('15', 'java初学者', 'java初学者，求指导', 'Hallo', '2015-06-07 19:04:28', 'JAVA');
INSERT INTO `note` VALUES ('16', '新人冒泡', '我是c的初学者，过来冒个泡', '颜文青', '2015-06-07 19:08:19', 'C');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` varchar(255) NOT NULL,
  `userPassword` varchar(255) NOT NULL,
  `userImage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('111111', '111111', 'upload/111111.jpg');
INSERT INTO `user` VALUES ('byroner', '111111', 'upload/tp.jpg');
INSERT INTO `user` VALUES ('Hallo', '123123', 'upload/tp.jpg');
INSERT INTO `user` VALUES ('Reed', '111111', 'upload/Reed.jpg');
INSERT INTO `user` VALUES ('tangpan', '123456', 'upload/tp.jpg');
INSERT INTO `user` VALUES ('颜文青', '12341234', 'upload/颜文青.jpg');
