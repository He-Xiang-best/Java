/*
 Navicat Premium Data Transfer

 Source Server         : localhost - MySQL8.0
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : db_bookstore

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 28/05/2021 08:15:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` decimal(11, 2) NULL DEFAULT NULL,
  `author` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sales` int NULL DEFAULT NULL,
  `stock` int NULL DEFAULT NULL,
  `img_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES (1, 'java从入门到精通', 80.00, '咖啡', 10001, 7, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (2, '数据结构与算法', 78.50, '严敏君', 10, 9, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (3, '计算机网络', 68.00, '敬业', 100002, 49, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (4, '计算机组成原理', 16.00, '诚信', 1005, 45, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (5, 'C++编程思想', 45.50, '公正', 14, 95, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (6, '软件工程', 9.90, '友善', 12, 53, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (7, '数据库原理与应用', 66.50, '法治', 125, 535, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (8, 'Java编程思想', 99.50, '大佬', 47, 36, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (9, 'JavaScript从入门到精通', 9.90, '贾斯丁', 85, 95, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (10, 'cocos2d-x游戏编程入门', 49.00, '荣耀', 51, 62, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (11, 'C语言程序设计', 28.00, '谭浩强', 52, 74, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (12, 'go语言程序设计', 51.50, '和谐', 48, 82, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (13, '西游记', 12.00, '吴承恩', 19, 9999, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (14, '水浒传', 33.05, '罗贯中', 22, 88, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (15, '操作系统原理', 133.05, '微软', 122, 188, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (16, '数据结构 java版', 173.15, '平等', 21, 81, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (17, 'UNIX高级环境编程', 99.15, '自由', 200, 800, '/store/static/img/default.jpg');
INSERT INTO `t_book` VALUES (18, 'javaScript高级编程', 69.15, '文明', 210, 810, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (19, '大话设计模式', 89.15, '民主', 20, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (20, '算法导论', 88.15, '富强', 20, 80, 'static/img/default.jpg');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `order_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `price` decimal(11, 2) NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `user_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('16188329961931', '2021-04-19 11:49:56', 174.50, 0, 1);
INSERT INTO `t_order` VALUES ('16188331775911', '2021-04-19 11:52:58', 535.50, 0, 1);
INSERT INTO `t_order` VALUES ('16188333871881', '2021-04-19 11:56:27', 48.00, 0, 1);

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `count` int NULL DEFAULT NULL,
  `price` decimal(11, 2) NULL DEFAULT NULL,
  `total_price` decimal(11, 2) NULL DEFAULT NULL,
  `order_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  CONSTRAINT `t_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_item
-- ----------------------------
INSERT INTO `t_order_item` VALUES (1, 'java从入门到精通', 1, 80.00, 80.00, '16188329961931');
INSERT INTO `t_order_item` VALUES (2, '数据结构与算法', 1, 78.50, 78.50, '16188329961931');
INSERT INTO `t_order_item` VALUES (3, '计算机组成原理', 1, 16.00, 16.00, '16188329961931');
INSERT INTO `t_order_item` VALUES (4, '数据结构与算法', 3, 78.50, 235.50, '16188331775911');
INSERT INTO `t_order_item` VALUES (5, '计算机网络', 3, 68.00, 204.00, '16188331775911');
INSERT INTO `t_order_item` VALUES (6, '计算机组成原理', 1, 16.00, 16.00, '16188331775911');
INSERT INTO `t_order_item` VALUES (7, 'java从入门到精通', 1, 80.00, 80.00, '16188331775911');
INSERT INTO `t_order_item` VALUES (8, '计算机组成原理', 3, 16.00, 48.00, '16188333871881');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', 'admin', 'admin@atguigu.com', NULL);
INSERT INTO `t_user` VALUES (2, '帅翔', '@ABCDabcd1234', '172837855@qq.com', '15875615752');
INSERT INTO `t_user` VALUES (20, 'admin123', '@ABCDabcd1234', '172837855@qq.com', '13866666666');
INSERT INTO `t_user` VALUES (21, 'asdas131231', '@ABCDabcd1234', '172837855@qq.com', '13866666666');
INSERT INTO `t_user` VALUES (22, 'asd342423', '@ABCDabcd1234', '172837855@qq.com', '13866666666');

SET FOREIGN_KEY_CHECKS = 1;
