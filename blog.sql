/*
Navicat MySQL Data Transfer

Source Server         : liu
Source Server Version : 50557
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2021-04-19 21:00:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `parent_comment_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '张三', '1463264276@qq.com', '评论一下子', null, '2020-12-11 12:40:19', '-1');
INSERT INTO `comment` VALUES ('2', '李四', '1463264276@qq.com', '评论二下子', null, '2020-12-11 12:40:54', '1');
INSERT INTO `comment` VALUES ('3', '王五', '1463264276@qq.com', '评论三下子', null, '2020-12-11 12:47:04', '2');
INSERT INTO `comment` VALUES ('4', '小刘', '1463264276@qq.com', '评论四下子', null, '2020-12-11 12:50:44', '3');
INSERT INTO `comment` VALUES ('33', '游客1', null, '又有一条评论', null, '2020-12-11 05:51:56', '-1');
INSERT INTO `comment` VALUES ('34', '游客2', null, '回复一下', null, '2020-12-11 13:52:57', '33');
INSERT INTO `comment` VALUES ('35', '游客3', null, 'aaaaa', null, '2020-12-11 14:12:52', '34');
INSERT INTO `comment` VALUES ('36', '游客', null, '平路', null, '2020-12-11 06:32:30', '1');
INSERT INTO `comment` VALUES ('45', '游客', null, '666', null, '2020-12-11 11:32:21', '36');
INSERT INTO `comment` VALUES ('46', '游客', null, '666', null, '2020-12-12 09:47:43', '-1');
INSERT INTO `comment` VALUES ('47', '游客', null, '666666', null, '2020-12-12 11:21:14', null);
INSERT INTO `comment` VALUES ('48', '游客', null, '55555', null, '2020-12-12 11:21:45', null);
INSERT INTO `comment` VALUES ('49', '游客', null, '5656456', null, '2020-12-12 11:21:57', null);
INSERT INTO `comment` VALUES ('50', '游客', null, '5555', null, '2020-12-12 11:23:29', null);
INSERT INTO `comment` VALUES ('51', '游客', null, '6666666', null, '2020-12-12 11:23:39', null);
INSERT INTO `comment` VALUES ('52', '游客', null, '66666', null, '2020-12-12 11:31:43', '1');

-- ----------------------------
-- Table structure for comment_copy
-- ----------------------------
DROP TABLE IF EXISTS `comment_copy`;
CREATE TABLE `comment_copy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `parent_comment_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment_copy
-- ----------------------------
INSERT INTO `comment_copy` VALUES ('1', '张三', '1463264276@qq.com', '评论一下子', null, '2020-12-11 12:40:19', '-1');
INSERT INTO `comment_copy` VALUES ('2', '李四', '1463264276@qq.com', '评论二下子', null, '2020-12-11 12:40:54', '1');
INSERT INTO `comment_copy` VALUES ('3', '王五', '1463264276@qq.com', '评论三下子', null, '2020-12-11 12:47:04', '2');
INSERT INTO `comment_copy` VALUES ('4', '小刘', '1463264276@qq.com', '评论四下子', null, '2020-12-11 12:50:44', '3');
INSERT INTO `comment_copy` VALUES ('33', '游客1', null, '又有一条评论', null, '2020-12-11 05:51:56', '-1');
INSERT INTO `comment_copy` VALUES ('34', '游客2', null, '回复一下', null, '2020-12-11 13:52:57', '33');
INSERT INTO `comment_copy` VALUES ('35', '游客3', null, 'aaaaa', null, '2020-12-11 14:12:52', '34');
INSERT INTO `comment_copy` VALUES ('36', '游客', null, '平路', null, '2020-12-11 06:32:30', '1');
INSERT INTO `comment_copy` VALUES ('45', '游客', null, '666', null, '2020-12-11 11:32:21', '36');
INSERT INTO `comment_copy` VALUES ('46', '游客', null, '666', null, '2020-12-12 09:47:43', '-1');
INSERT INTO `comment_copy` VALUES ('47', '游客', null, '666666', null, '2020-12-12 11:21:14', null);
INSERT INTO `comment_copy` VALUES ('48', '游客', null, '55555', null, '2020-12-12 11:21:45', null);
INSERT INTO `comment_copy` VALUES ('49', '游客', null, '5656456', null, '2020-12-12 11:21:57', null);
INSERT INTO `comment_copy` VALUES ('50', '游客', null, '5555', null, '2020-12-12 11:23:29', null);
INSERT INTO `comment_copy` VALUES ('51', '游客', null, '6666666', null, '2020-12-12 11:23:39', null);
INSERT INTO `comment_copy` VALUES ('52', '游客', null, '66666', null, '2020-12-12 11:31:43', '1');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('1');

-- ----------------------------
-- Table structure for t_blog
-- ----------------------------
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `appreciation` bit(1) DEFAULT NULL,
  `commentabled` bit(1) DEFAULT NULL,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `first_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `flag` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `published` bit(1) DEFAULT NULL,
  `recommened` bit(1) DEFAULT NULL,
  `share_statement` bit(1) DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `comment_count` int(200) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK292449gwg5yf7ocdlmswv9w4j` (`type_id`),
  KEY `FK8ky5rrsxh01nkhctmo7d48p82` (`user_id`),
  CONSTRAINT `FK292449gwg5yf7ocdlmswv9w4j` FOREIGN KEY (`type_id`) REFERENCES `t_type` (`id`),
  CONSTRAINT `FK8ky5rrsxh01nkhctmo7d48p82` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_blog
-- ----------------------------
INSERT INTO `t_blog` VALUES ('1', '', '', '第二个博客', '2020-12-07 12:06:55', 'bbb', '原创', '\0', '', '', 'title2', '2020-12-08 03:44:12', '0', '20', '1', '0', 'aaaaaaaaaaa');
INSERT INTO `t_blog` VALUES ('3', '', '', '努力学习java，就能学好', '2020-12-08 04:17:30', 'aaa', '原创', '\0', '', '', '如何学好java', '2020-12-08 04:17:30', '0', '20', '1', '0', 'aaaaaaaaaaa');
INSERT INTO `t_blog` VALUES ('4', '', '', '努力就能学好', '2020-12-08 04:18:14', 'aaaaaa', '原创', '\0', '', '', '如何学好c语言', '2020-12-08 04:18:14', '1', '21', '1', '0', 'aaaaaaaaaaaa');
INSERT INTO `t_blog` VALUES ('5', '', '', '努力就能学好', '2020-12-08 04:18:50', 'aaaaaa', '原创', '\0', '', '', '如何学好Python', '2020-12-08 04:18:50', '2', '23', '1', '0', 'aaaaaaaaaaa');
INSERT INTO `t_blog` VALUES ('6', '', '', '努力就能学好', '2020-12-08 04:19:25', 'aaaaaa', '原创', '\0', '', '', '如何学好前端框架', '2020-12-08 04:19:25', '19', '24', '1', '0', 'aaaaaaaaaaaaaaa');
INSERT INTO `t_blog` VALUES ('7', '', '', '努力就能学好', '2020-12-08 04:19:51', 'aaaaaa', '原创', '\0', '', '', '如何学好JVM虚拟机', '2020-12-08 04:19:51', '57', '25', '1', '1', 'aaaaaaaaaaaaaaaaa');

-- ----------------------------
-- Table structure for t_blog_tags
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_tags`;
CREATE TABLE `t_blog_tags` (
  `blogs_id` bigint(20) NOT NULL,
  `tags_id` bigint(20) NOT NULL,
  KEY `FK5feau0gb4lq47fdb03uboswm8` (`tags_id`),
  KEY `FKh4pacwjwofrugxa9hpwaxg6mr` (`blogs_id`),
  CONSTRAINT `FK5feau0gb4lq47fdb03uboswm8` FOREIGN KEY (`tags_id`) REFERENCES `t_tag` (`id`),
  CONSTRAINT `FKh4pacwjwofrugxa9hpwaxg6mr` FOREIGN KEY (`blogs_id`) REFERENCES `t_blog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_blog_tags
-- ----------------------------

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` bigint(20) NOT NULL,
  `avatar` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `nick_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `blog_id` bigint(20) DEFAULT NULL,
  `parent_comment_id` bigint(20) DEFAULT NULL,
  `admin_comment` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKke3uogd04j4jx316m1p51e05u` (`blog_id`),
  KEY `FK4jj284r3pb7japogvo6h72q95` (`parent_comment_id`),
  CONSTRAINT `FK4jj284r3pb7japogvo6h72q95` FOREIGN KEY (`parent_comment_id`) REFERENCES `t_comment` (`id`),
  CONSTRAINT `FKke3uogd04j4jx316m1p51e05u` FOREIGN KEY (`blog_id`) REFERENCES `t_blog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES ('1', null, '内容1', '2020-12-12 16:38:19', null, '游客', '7', '1', null);

-- ----------------------------
-- Table structure for t_diary
-- ----------------------------
DROP TABLE IF EXISTS `t_diary`;
CREATE TABLE `t_diary` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `create_time` date NOT NULL,
  `update_time` date NOT NULL,
  `content` varchar(1000) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_diary
-- ----------------------------
INSERT INTO `t_diary` VALUES ('1', '2020-12-10', '2020-12-10', '第一篇日记');

-- ----------------------------
-- Table structure for t_friend
-- ----------------------------
DROP TABLE IF EXISTS `t_friend`;
CREATE TABLE `t_friend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `blogaddress` varchar(255) NOT NULL,
  `blogname` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT '1970-01-01 08:00:00',
  `pictureaddress` varchar(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_friend
-- ----------------------------
INSERT INTO `t_friend` VALUES ('1', '博客地址2', '博客名称2', '2020-12-10 10:13:22', '图片地址2');

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT '1970-01-01 08:00:00',
  `parent_message_id` bigint(20) DEFAULT NULL,
  `admin_message` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_message
-- ----------------------------

-- ----------------------------
-- Table structure for t_picture
-- ----------------------------
DROP TABLE IF EXISTS `t_picture`;
CREATE TABLE `t_picture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pictureaddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `picturedescription` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `picturename` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `picturetime` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_picture
-- ----------------------------
INSERT INTO `t_picture` VALUES ('20', '图片地址1', '图片描述1', '图片名称1', '时间地点1');
INSERT INTO `t_picture` VALUES ('23', '图片名称2', '时间地点2', '图片地址2', '图片描述2');

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES ('3', 'Python');
INSERT INTO `t_tag` VALUES ('4', 'C');
INSERT INTO `t_tag` VALUES ('5', 'C++');

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_type
-- ----------------------------
INSERT INTO `t_type` VALUES ('20', 'java');
INSERT INTO `t_type` VALUES ('21', 'c语言');
INSERT INTO `t_type` VALUES ('23', 'Python');
INSERT INTO `t_type` VALUES ('24', '前端框架');
INSERT INTO `t_type` VALUES ('25', 'JVM虚拟机');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL,
  `avatar` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `nick_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '', '2020-12-05 10:12:09', '1463264276@qq.com', 'xiaoliu', '038bdaf98f2037b31f1e75b5b4c9b26e', null, '2020-12-05 10:13:11', 'admin');
