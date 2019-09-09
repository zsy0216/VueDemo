/*
Navicat MySQL Data Transfer

Source Server         : Localhost
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : vue

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-09-08 09:02:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `education` varchar(255) DEFAULT NULL,
  `graduationschool` varchar(255) DEFAULT NULL,
  `profession` varchar(255) DEFAULT NULL,
  `profile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('6', 'zs', '123', '123@zs.com', 'academ', 'zut', 'student', 'a student at zut.');
INSERT INTO `t_customer` VALUES ('8', 'ls', '456', '456@ls.com', null, null, null, null);
INSERT INTO `t_customer` VALUES ('9', 'test', 'test', 'test', 'test', 'test', 'test', 'test');
INSERT INTO `t_customer` VALUES ('11', 'cxk', '54438', '54438@nmsl.com', 'elementary school', 'qbl num 1 primary school', 'rapper,basket baller.', '鸡你太美');
INSERT INTO `t_customer` VALUES ('14', '2', '123', '123@zs.com', 'academ', 'zut', 'student', 'a student at zut.');
INSERT INTO `t_customer` VALUES ('16', '3', '123', '123@zs.com', 'academ', 'zut', 'student', 'a student at zut.');
INSERT INTO `t_customer` VALUES ('17', '4', '4', '4', '4', null, null, null);
INSERT INTO `t_customer` VALUES ('18', 'cxk', '54438', '54438@jntm.com', 'elementary school', 'qbl primary school', 'rapper', '鸡你太美');
