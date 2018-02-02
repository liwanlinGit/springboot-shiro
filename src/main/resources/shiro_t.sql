/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : shiro_t

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-02-02 17:59:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `parent_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '宇通公司', 'YTGS', '0');
INSERT INTO `dept` VALUES ('5', '项目部', 'XMB', '1');
INSERT INTO `dept` VALUES ('6', '项目一部', 'XMB1', '5');

-- ----------------------------
-- Table structure for resources
-- ----------------------------
DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `resUrl` varchar(255) DEFAULT NULL COMMENT '资源url',
  `type` int(11) DEFAULT NULL COMMENT '资源类型   1:菜单    2：按钮',
  `parentId` int(11) DEFAULT NULL COMMENT '父资源',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resources
-- ----------------------------
INSERT INTO `resources` VALUES ('1', '系统设置', '', '1', '0', '10');
INSERT INTO `resources` VALUES ('2', '用户管理', '/page/users', '1', '1', '20');
INSERT INTO `resources` VALUES ('3', '角色管理', '/page/roles', '1', '1', '30');
INSERT INTO `resources` VALUES ('4', '资源管理', '/page/resources', '1', '1', '40');
INSERT INTO `resources` VALUES ('5', '添加用户', '/users/add', '2', '2', '1');
INSERT INTO `resources` VALUES ('6', '删除用户', '/users/delete', '2', '2', '2');
INSERT INTO `resources` VALUES ('7', '添加角色', '/roles/add', '2', '3', '1');
INSERT INTO `resources` VALUES ('8', '删除角色', '/roles/delete', '2', '3', '2');
INSERT INTO `resources` VALUES ('9', '添加资源', '/resources/add', '2', '4', '1');
INSERT INTO `resources` VALUES ('10', '删除资源', '/resources/delete', '2', '4', '2');
INSERT INTO `resources` VALUES ('11', '分配角色', '/users/saveUserRoles', '2', '2', '11');
INSERT INTO `resources` VALUES ('13', '分配权限', '/roles/saveRoleResources', '2', '3', '4');
INSERT INTO `resources` VALUES ('14', '修改资源', '/resources/edit', '2', '4', '3');
INSERT INTO `resources` VALUES ('15', '修改角色', '/roles/edit', '2', '3', '3');
INSERT INTO `resources` VALUES ('16', '添加部门', '/dept/add', '2', '55', '1');
INSERT INTO `resources` VALUES ('17', '删除部门', '/dept/delete', '2', '55', '2');
INSERT INTO `resources` VALUES ('18', '修改部门', '/dept/edit', '2', '55', '3');
INSERT INTO `resources` VALUES ('55', '部门管理', '/page/depts', '1', '1', '10');
INSERT INTO `resources` VALUES ('56', '修改用户', '/users/edit', '2', '2', '3');
INSERT INTO `resources` VALUES ('57', '停用', '/users/off', '2', '2', '4');
INSERT INTO `resources` VALUES ('58', '启用', '/users/on', '2', '2', '5');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleDesc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员');
INSERT INTO `role` VALUES ('2', '普通用户');
INSERT INTO `role` VALUES ('3', '超级管理员');
INSERT INTO `role` VALUES ('4', '管理部门');
INSERT INTO `role` VALUES ('7', '部门经理11');

-- ----------------------------
-- Table structure for role_resources
-- ----------------------------
DROP TABLE IF EXISTS `role_resources`;
CREATE TABLE `role_resources` (
  `roleId` int(11) NOT NULL,
  `resourcesId` int(11) NOT NULL,
  PRIMARY KEY (`roleId`,`resourcesId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_resources
-- ----------------------------
INSERT INTO `role_resources` VALUES ('1', '1');
INSERT INTO `role_resources` VALUES ('1', '2');
INSERT INTO `role_resources` VALUES ('1', '3');
INSERT INTO `role_resources` VALUES ('1', '4');
INSERT INTO `role_resources` VALUES ('1', '5');
INSERT INTO `role_resources` VALUES ('1', '6');
INSERT INTO `role_resources` VALUES ('1', '7');
INSERT INTO `role_resources` VALUES ('1', '8');
INSERT INTO `role_resources` VALUES ('1', '9');
INSERT INTO `role_resources` VALUES ('1', '10');
INSERT INTO `role_resources` VALUES ('1', '11');
INSERT INTO `role_resources` VALUES ('1', '13');
INSERT INTO `role_resources` VALUES ('1', '14');
INSERT INTO `role_resources` VALUES ('1', '15');
INSERT INTO `role_resources` VALUES ('1', '16');
INSERT INTO `role_resources` VALUES ('1', '17');
INSERT INTO `role_resources` VALUES ('1', '18');
INSERT INTO `role_resources` VALUES ('1', '55');
INSERT INTO `role_resources` VALUES ('1', '56');
INSERT INTO `role_resources` VALUES ('1', '57');
INSERT INTO `role_resources` VALUES ('1', '58');
INSERT INTO `role_resources` VALUES ('2', '1');
INSERT INTO `role_resources` VALUES ('2', '2');
INSERT INTO `role_resources` VALUES ('2', '3');
INSERT INTO `role_resources` VALUES ('2', '4');
INSERT INTO `role_resources` VALUES ('2', '5');
INSERT INTO `role_resources` VALUES ('2', '6');
INSERT INTO `role_resources` VALUES ('2', '7');
INSERT INTO `role_resources` VALUES ('2', '8');
INSERT INTO `role_resources` VALUES ('2', '9');
INSERT INTO `role_resources` VALUES ('2', '10');
INSERT INTO `role_resources` VALUES ('2', '11');
INSERT INTO `role_resources` VALUES ('2', '13');
INSERT INTO `role_resources` VALUES ('2', '14');
INSERT INTO `role_resources` VALUES ('2', '15');
INSERT INTO `role_resources` VALUES ('3', '2');
INSERT INTO `role_resources` VALUES ('3', '3');
INSERT INTO `role_resources` VALUES ('3', '4');
INSERT INTO `role_resources` VALUES ('3', '5');
INSERT INTO `role_resources` VALUES ('3', '7');
INSERT INTO `role_resources` VALUES ('3', '8');
INSERT INTO `role_resources` VALUES ('3', '9');
INSERT INTO `role_resources` VALUES ('3', '10');
INSERT INTO `role_resources` VALUES ('4', '1');
INSERT INTO `role_resources` VALUES ('4', '4');
INSERT INTO `role_resources` VALUES ('4', '9');
INSERT INTO `role_resources` VALUES ('4', '10');
INSERT INTO `role_resources` VALUES ('7', '1');
INSERT INTO `role_resources` VALUES ('7', '2');
INSERT INTO `role_resources` VALUES ('7', '3');
INSERT INTO `role_resources` VALUES ('7', '4');
INSERT INTO `role_resources` VALUES ('7', '5');
INSERT INTO `role_resources` VALUES ('7', '6');
INSERT INTO `role_resources` VALUES ('7', '7');
INSERT INTO `role_resources` VALUES ('7', '8');
INSERT INTO `role_resources` VALUES ('7', '9');
INSERT INTO `role_resources` VALUES ('7', '10');
INSERT INTO `role_resources` VALUES ('7', '11');
INSERT INTO `role_resources` VALUES ('7', '13');
INSERT INTO `role_resources` VALUES ('7', '14');
INSERT INTO `role_resources` VALUES ('7', '15');
INSERT INTO `role_resources` VALUES ('7', '16');
INSERT INTO `role_resources` VALUES ('7', '17');
INSERT INTO `role_resources` VALUES ('7', '18');
INSERT INTO `role_resources` VALUES ('7', '55');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(33) DEFAULT NULL,
  `password` varchar(33) DEFAULT NULL,
  `enable` int(10) DEFAULT '1' COMMENT '是否启用',
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `mark` varchar(255) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '3ef7164d1f6167cb9f2658c07d3c2f0a', '1', '管理员', '北京', '管理员', '1', '15510505500');
INSERT INTO `user` VALUES ('2', 'user1', '90e66e36e3135a91d298177d4389851e', '1', null, null, null, '5', null);
INSERT INTO `user` VALUES ('3', 'user2', '121', '0', null, null, null, '1', null);
INSERT INTO `user` VALUES ('4', 'user3', 'user3', '1', null, null, null, '1', null);
INSERT INTO `user` VALUES ('5', 'user4', 'user4', '1', null, null, null, '1', null);
INSERT INTO `user` VALUES ('8', 'user7', 'user7', '1', null, null, null, '1', null);
INSERT INTO `user` VALUES ('9', 'user8', 'user8', '1', null, null, null, '1', null);
INSERT INTO `user` VALUES ('10', 'user9', 'user9', '1', null, null, null, '1', null);
INSERT INTO `user` VALUES ('11', 'user10', 'user10', '1', null, null, null, '1', null);
INSERT INTO `user` VALUES ('12', 'user11', 'user11', '1', null, null, null, '1', null);
INSERT INTO `user` VALUES ('13', 'user12', 'user12', '1', null, null, null, '1', null);
INSERT INTO `user` VALUES ('14', 'user13', 'user13', '1', null, null, null, '1', null);
INSERT INTO `user` VALUES ('15', 'user14', 'user14', '1', null, null, null, '1', null);
INSERT INTO `user` VALUES ('16', 'user15', 'user15', '1', null, null, null, '1', null);
INSERT INTO `user` VALUES ('17', 'user16', 'user16', '1', null, null, null, '1', null);
INSERT INTO `user` VALUES ('18', 'user17', 'user17', '1', null, null, null, '1', null);
INSERT INTO `user` VALUES ('19', 'user18', 'user18', '1', null, null, null, '1', null);
INSERT INTO `user` VALUES ('21', 'user20', 'user20', '1', null, null, null, '1', null);
INSERT INTO `user` VALUES ('23', '222', 'd3db819453cadc702ea57097a1ad5ed9', '0', '1111', '123123', '123123123', '6', '21312312');
INSERT INTO `user` VALUES ('25', '31231', '4155b096f06457956fbe687c12c9ec18', '0', '1312323243', '234234', '234234', '1', '423434234');
INSERT INTO `user` VALUES ('26', '1111111', '299d98affd2f4d468c0aabf5df5793d2', '1', '123', '12', '123', '6', '1312312312');
INSERT INTO `user` VALUES ('27', '33333333', '6e041ac865e76f9cce9dc284e7085c22', '1', '333333333', '3213123', '3213', '6', '3333333333333');
INSERT INTO `user` VALUES ('28', '4444444444', '70b390d90c805d542a7a7ef3ecd9f54d', '1', '4444444444444', '444444', '44444444', '6', '44444444444444');
INSERT INTO `user` VALUES ('29', '423423', '9869589000ef480da4b7633099316b8d', '1', '324234', '234324', '23434', '6', '23423434');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `userId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('2', '2');
INSERT INTO `user_role` VALUES ('26', '3');
INSERT INTO `user_role` VALUES ('27', '3');
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('1', '2');
INSERT INTO `user_role` VALUES ('1', '3');
INSERT INTO `user_role` VALUES ('1', '4');
INSERT INTO `user_role` VALUES ('1', '7');

-- ----------------------------
-- Function structure for fun_a_dept
-- ----------------------------
DROP FUNCTION IF EXISTS `fun_a_dept`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fun_a_dept`(dept_id int) RETURNS varchar(4000) CHARSET utf8
BEGIN
DECLARE sTemp VARCHAR(4000);
DECLARE sTempChd VARCHAR(4000);

SET sTemp = '$';
SET sTempChd = cast(dept_id as char);

WHILE sTempChd is not NULL DO
SET sTemp = CONCAT(sTemp,',',sTempChd);
SELECT group_concat(id) INTO sTempChd FROM dept where FIND_IN_SET(parent_Id,sTempChd)>0;
END WHILE;
return sTemp;
END
;;
DELIMITER ;
