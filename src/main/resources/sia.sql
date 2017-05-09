/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.5.46 : Database - sia
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sia` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sia`;

/*Table structure for table `adapter` */

DROP TABLE IF EXISTS `adapter`;

CREATE TABLE `adapter` (
  `node_id` int(8) NOT NULL COMMENT 'opc中对应的NodeId',
  `gateway_id` int(11) DEFAULT NULL COMMENT '外键关联gateway',
  `name` varchar(16) DEFAULT NULL COMMENT '适配器名称，水表001',
  `serial` varchar(32) DEFAULT NULL COMMENT '适配器位号，MTU-IOT001',
  `typeserial` varchar(16) DEFAULT NULL COMMENT '在数据库中对应的名称，sia001',
  `long_address` varchar(32) DEFAULT NULL COMMENT '适配器的长地址',
  `sub_address` varchar(4) DEFAULT 'FF' COMMENT '从站地址，默认N没有',
  `type` varchar(16) DEFAULT NULL COMMENT '适配器类型，Hart或者无线IO',
  `factory` varchar(16) DEFAULT NULL COMMENT '生产商',
  `protocl_id` int(11) DEFAULT NULL COMMENT '外键关联protocol',
  `is_enable` int(1) DEFAULT '1' COMMENT '该适配器是否使用，默认1启用',
  `at_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`node_id`),
  KEY `protocl_id` (`protocl_id`),
  KEY `gateway_id` (`gateway_id`),
  CONSTRAINT `adapter_ibfk_1` FOREIGN KEY (`node_id`) REFERENCES `state` (`node_id`),
  CONSTRAINT `adapter_ibfk_2` FOREIGN KEY (`gateway_id`) REFERENCES `gateway` (`node_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `adapter` */

insert  into `adapter`(`node_id`,`gateway_id`,`name`,`serial`,`typeserial`,`long_address`,`sub_address`,`type`,`factory`,`protocl_id`,`is_enable`,`at_time`) values (52010,52000,'无线水表011','WXWATER-01','wxio01','ffffffffffffffff','FF','无线IO','中科奥维',1,1,'2016-12-27 16:32:39');

/*Table structure for table `author` */

DROP TABLE IF EXISTS `author`;

CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增，唯一标识',
  `name` varchar(16) DEFAULT NULL COMMENT '权限名称',
  `menu_author` varchar(64) DEFAULT NULL COMMENT '菜单访问权限，多个菜单用逗号隔开',
  `role_author` varchar(64) DEFAULT NULL COMMENT '角色权限，待定',
  `at_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `author` */

insert  into `author`(`id`,`name`,`menu_author`,`role_author`,`at_time`) values (1,'超级管理员','1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17','administrator','2016-12-12 19:32:06'),(2,'操作员','1,3,5,7,9,12,13,14','operator','2016-12-12 19:46:13'),(3,'游客','2,4,6,8,10,12','guest','2016-12-17 18:51:54');

/*Table structure for table `config_protocol` */

DROP TABLE IF EXISTS `config_protocol`;

CREATE TABLE `config_protocol` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，自增',
  `name` varchar(16) DEFAULT NULL COMMENT '配置名称',
  `data_real_id` int(11) DEFAULT NULL COMMENT '节点的NodeID，外键关联',
  `device_id` int(11) DEFAULT NULL COMMENT '设备ID',
  `mod_addr` int(11) DEFAULT NULL COMMENT 'modbus地址',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `rw` int(11) DEFAULT NULL COMMENT '读写',
  `fre` int(11) DEFAULT NULL COMMENT '频率',
  `at_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `data_real_id` (`data_real_id`),
  CONSTRAINT `config_protocol_ibfk_1` FOREIGN KEY (`data_real_id`) REFERENCES `data_real` (`node_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `config_protocol` */

insert  into `config_protocol`(`id`,`name`,`data_real_id`,`device_id`,`mod_addr`,`type`,`rw`,`fre`,`at_time`) values (4,'配置',12121,12,21,0,0,12,'2017-01-11 13:18:55');

/*Table structure for table `data_base` */

DROP TABLE IF EXISTS `data_base`;

CREATE TABLE `data_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，自增',
  `name` varchar(16) DEFAULT NULL COMMENT '数据库名称',
  `type` tinyint(4) DEFAULT '0' COMMENT '数据库类型，默认0，Mysql',
  `ip` varchar(16) DEFAULT NULL COMMENT 'ip',
  `port` int(4) DEFAULT NULL COMMENT '端口',
  `login` varchar(8) DEFAULT NULL COMMENT '登陆名',
  `password` varchar(16) DEFAULT NULL COMMENT '登录密码',
  `user` varchar(16) DEFAULT NULL COMMENT '创建者',
  `is_enable` tinyint(2) DEFAULT '1' COMMENT '是否启用，默认1启用',
  `state` tinyint(2) DEFAULT '0' COMMENT '状态，默认0未知',
  `at_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `data_base` */

insert  into `data_base`(`id`,`name`,`type`,`ip`,`port`,`login`,`password`,`user`,`is_enable`,`state`,`at_time`) values (1,'MySql-Sia',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-27 22:51:04'),(2,'MySql-MaoMing',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 10:51:17'),(3,'MySql-TianJin',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 10:51:45'),(4,'MySql-AnQing',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(5,'MySql-JiuJiang5',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(6,'MySql-LanZhou',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(7,'MySql-BeiJing',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(8,'MySql-BeiJing',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(9,'MySql-BeiJing9',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(10,'MySql-BeiJing',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(11,'MySql-BeiJing',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(12,'MySql-BeiJing',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(13,'MySql-BeiJing13',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(14,'MySql-BeiJing',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(15,'MySql-BeiJing',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(16,'MySql-BeiJing',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(17,'MySql-BeiJing17',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(18,'MySql-BeiJing',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(19,'MySql-BeiJing',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(20,'MySql-BeiJing',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(21,'MySql-BeiJing',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(22,'MySql-BeiJing',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(23,'MySql-BeiJing23',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(24,'MySql-BeiJing',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(25,'MySql-BeiJing',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(26,'MySql-BeiJing',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(27,'MySql-BeiJing',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(28,'MySql-BeiJing28',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(29,'MySql-BeiJing',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(30,'MySql-BeiJing',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(31,'MySql-BeiJing31',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00'),(32,'MySql-BeiJing32',0,'192.168.4.23',6000,'root','123456','Pnoker',1,0,'2016-12-18 00:00:00');

/*Table structure for table `data_his` */

DROP TABLE IF EXISTS `data_his`;

CREATE TABLE `data_his` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，自增',
  `node_id` int(11) DEFAULT NULL COMMENT 'nodeId',
  `tag` int(4) DEFAULT NULL COMMENT '标志位，用于区分变量',
  `value` float DEFAULT NULL COMMENT '变量值，统一存储float型',
  `is_true` int(1) DEFAULT '1' COMMENT '是否是真值，1默认为真值',
  `units` varchar(8) DEFAULT NULL COMMENT '单位，Kg、M3等',
  `at_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `adapter_id` (`node_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `data_his` */

/*Table structure for table `data_real` */

DROP TABLE IF EXISTS `data_real`;

CREATE TABLE `data_real` (
  `node_id` int(11) NOT NULL COMMENT 'opc中对应的NodeId',
  `adapter_id` int(11) DEFAULT NULL COMMENT '外键关联adapter',
  `name` varchar(8) DEFAULT NULL COMMENT '参数名称，电压',
  `value_type` varchar(8) DEFAULT 'double' COMMENT '参数的数据类型,string/double',
  `write_able` varchar(8) DEFAULT 'y' COMMENT '读写，默认y可写',
  `tag` tinyint(4) DEFAULT '0' COMMENT '对应的tag值',
  `value` varchar(32) DEFAULT '0' COMMENT '参数的值，默认为字符串',
  `protocol_id` int(11) DEFAULT NULL COMMENT '协议号，外键关联protocol',
  `at_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`node_id`),
  KEY `adapter_id` (`adapter_id`),
  KEY `protocol_id` (`protocol_id`),
  CONSTRAINT `data_real_ibfk_1` FOREIGN KEY (`adapter_id`) REFERENCES `adapter` (`node_id`),
  CONSTRAINT `data_real_ibfk_2` FOREIGN KEY (`protocol_id`) REFERENCES `protocol` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `data_real` */

insert  into `data_real`(`node_id`,`adapter_id`,`name`,`value_type`,`write_able`,`tag`,`value`,`protocol_id`,`at_time`) values (12121,52010,'111','double','y',2,'好',1,'2016-12-27 16:40:05'),(52011,52010,'电压','double','y',0,'12.0',1,'2016-12-24 11:55:42'),(52012,52010,'瞬时值','double','y',2,'121',1,'2017-01-12 09:01:46'),(52013,52010,'累计值','double','y',2,'12',1,'2016-12-24 10:50:12'),(52632,52010,'脉冲值','double','y',1,'0',1,'2017-01-12 09:02:21');

/*Table structure for table `gateway` */

DROP TABLE IF EXISTS `gateway`;

CREATE TABLE `gateway` (
  `node_id` int(8) NOT NULL COMMENT 'OPC中对应的NodeID',
  `name` varchar(16) DEFAULT NULL COMMENT '网关名称',
  `ip` varchar(16) DEFAULT NULL COMMENT '网关，xxx.xxx.xxx.xxx',
  `port` int(4) DEFAULT '6000' COMMENT '端口，6000',
  `is_enable` int(1) DEFAULT '1' COMMENT '该是否使用，默认1启用',
  `at_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`node_id`),
  KEY `node_id` (`node_id`),
  CONSTRAINT `gateway_ibfk_1` FOREIGN KEY (`node_id`) REFERENCES `state` (`node_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `gateway` */

insert  into `gateway`(`node_id`,`name`,`ip`,`port`,`is_enable`,`at_time`) values (52000,'污水大楼','192.168.1.2',6000,1,'2016-12-27 16:32:23');

/*Table structure for table `items` */

DROP TABLE IF EXISTS `items`;

CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，自增',
  `parent_id` int(11) DEFAULT NULL COMMENT '外键关联menus',
  `title` varchar(16) DEFAULT NULL COMMENT '标题',
  `icon` varchar(32) DEFAULT 'building_edit.png' COMMENT '图标',
  `is_enable` int(1) DEFAULT '1' COMMENT '默认1，启用',
  `url` varchar(64) DEFAULT 'error.do' COMMENT 'URL',
  `at_index` int(11) DEFAULT '0' COMMENT '相对位置',
  `at_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `items_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `menus` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `items` */

insert  into `items`(`id`,`parent_id`,`title`,`icon`,`is_enable`,`url`,`at_index`,`at_time`) values (1,10,'适配器一览','computer_magnify.png',1,'adapter/adapterView.do',0,'2016-12-11 23:07:44'),(2,10,'适配器配置','computer_edit.png',0,'adapter/adapterCnfg.do',1,'2016-12-11 23:09:07'),(3,11,'点位一览','drive_rename.png',1,'opcItems/opcItemsView.do',0,'2016-12-11 23:09:15'),(4,11,'点位配置','drive_edit.png',1,'opcItems/opcItemsCnfg.do',1,'2016-12-11 23:21:35'),(5,12,'网关一览','chart_org_inverted.png',1,'gateWay/gateWayView.do',0,'2016-12-11 23:21:35'),(6,12,'网关配置','chart_organisation_add.png',0,'gateWay/gateWayCnfg.do',1,'2016-12-11 23:21:35'),(7,13,'数据库一览','database.png',0,'dataBase/dataBaseView.do',0,'2016-12-11 23:21:35'),(8,13,'数据库配置','database_edit.png',0,'dataBase/dataBaseCnfg.do',1,'2016-12-11 23:21:35'),(9,14,'协议库一览','lock.png',0,'ProtocolView.do',0,'2016-12-11 23:21:35'),(10,14,'协议库配置','lock_edit.png',0,'ProtocolCnfg.do',1,'2016-12-11 23:21:35'),(11,15,'用户管理','report_user.png',0,'UserManage.do',0,'2016-12-11 23:21:35'),(12,15,'其他','shield_silver.png',0,'Other.do',1,'2016-12-11 23:21:35'),(13,16,'数据格式配置','music_note.png',0,'rest/restCnfg.do',0,'2016-12-12 17:12:05'),(14,16,'Json/Xml测试','page_white_code.png',0,'rest/restTest.do',0,'2016-12-12 17:12:05'),(15,15,'菜单管理','building_edit.png',0,'error.do',0,NULL),(16,17,'历史数据展示','building_edit.png',0,'error.do',0,NULL),(17,17,'实时数据','building_edit.png',0,'error.do',0,NULL);

/*Table structure for table `menus` */

DROP TABLE IF EXISTS `menus`;

CREATE TABLE `menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID，自增，唯一标识',
  `title` varchar(16) NOT NULL COMMENT '菜单的标题',
  `icon` varchar(32) NOT NULL DEFAULT 'building.png' COMMENT '菜单图标URL，填写图标的文件名即可，add.png',
  `is_enable` int(1) DEFAULT '1' COMMENT '是否启用，默认为1，启用',
  `at_index` int(1) DEFAULT '0' COMMENT '相对位置',
  `at_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='菜单表\r\n\r\n0-9为预留ID';

/*Data for the table `menus` */

insert  into `menus`(`id`,`title`,`icon`,`is_enable`,`at_index`,`at_time`) values (10,'网络适配器','computer.png',1,3,'2016-12-11 13:31:38'),(11,'OPCUA配置','drive_web.png',1,5,'2016-12-11 13:59:41'),(12,'网关管理','chart_organisation.png',1,2,'2016-12-11 14:00:12'),(13,'数据库','database_copy.png',1,1,'2016-12-12 17:12:01'),(14,'协议库','mail.png',1,4,'2016-12-12 17:12:03'),(15,'系统设置','cog.png',1,7,'2016-12-12 17:12:05'),(16,'对外接口','neighbourhood.png',1,6,'2016-12-12 17:12:05'),(17,'数据展示','building.png',1,0,NULL);

/*Table structure for table `order_disp` */

DROP TABLE IF EXISTS `order_disp`;

CREATE TABLE `order_disp` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，自增',
  `name` varchar(16) DEFAULT NULL COMMENT '调度命令的名称',
  `flag` tinyint(4) DEFAULT '3' COMMENT '信号量，3表示打开，2表示关闭，1表示需要重启，0表示正在运行',
  `description` varchar(32) DEFAULT NULL COMMENT '描述',
  `at_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `order_disp` */

insert  into `order_disp`(`id`,`name`,`flag`,`description`,`at_time`) values (1,'OPC UA Server',1,'操作OPC UA 和 Modbus 采数程序','2017-01-17 16:39:05');

/*Table structure for table `protocol` */

DROP TABLE IF EXISTS `protocol`;

CREATE TABLE `protocol` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，自增',
  `name` varchar(16) DEFAULT NULL COMMENT '协议名称',
  `description` varchar(128) DEFAULT NULL COMMENT '协议描述',
  `at_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `protocol` */

insert  into `protocol`(`id`,`name`,`description`,`at_time`) values (1,'开封开润','开封开润协议，有8个变量','2016-12-17 19:27:14');

/*Table structure for table `protocol_attr` */

DROP TABLE IF EXISTS `protocol_attr`;

CREATE TABLE `protocol_attr` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `protocol_id` int(11) DEFAULT NULL COMMENT '协议号，外键关联',
  `name` varchar(32) DEFAULT NULL,
  `value` varchar(32) DEFAULT NULL,
  `at_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `protocol_id` (`protocol_id`),
  CONSTRAINT `protocol_attr_ibfk_1` FOREIGN KEY (`protocol_id`) REFERENCES `protocol` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `protocol_attr` */

/*Table structure for table `state` */

DROP TABLE IF EXISTS `state`;

CREATE TABLE `state` (
  `node_id` int(8) NOT NULL COMMENT '网关或者适配器的唯一标识',
  `network_up` datetime DEFAULT NULL COMMENT '网络报文更新时间',
  `health_up` datetime DEFAULT NULL COMMENT '健康报文更新时间',
  `data_up` datetime DEFAULT NULL COMMENT '数据报文更新时间',
  `sig_mag` tinyint(4) DEFAULT '36' COMMENT '信号强度',
  `rate` tinyint(4) DEFAULT '100' COMMENT '接收成功率',
  `lost_num` tinyint(4) DEFAULT '0' COMMENT '丢包个数',
  `lost_time` int(8) DEFAULT '0' COMMENT '中断时长，单位为分钟，默认0',
  `dia_result` tinyint(4) DEFAULT '0' COMMENT '诊断结果，默认0，暂无结果',
  `description` varchar(256) DEFAULT '暂无描述' COMMENT '诊断结果描述',
  `suggeat` varchar(256) DEFAULT '暂无建议' COMMENT '建议提示',
  `at_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`node_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `state` */

insert  into `state`(`node_id`,`network_up`,`health_up`,`data_up`,`sig_mag`,`rate`,`lost_num`,`lost_time`,`dia_result`,`description`,`suggeat`,`at_time`) values (52000,'2016-12-24 10:47:15','2016-12-24 10:47:15','2016-12-24 10:47:15',36,100,0,0,0,'暂无描述','暂无建议','2016-12-24 10:47:15'),(52010,'2016-12-24 10:48:51','2016-12-24 10:48:51','2016-12-24 10:48:51',36,100,0,0,0,'暂无描述','暂无建议','2016-12-24 10:48:51');

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `node_id` varchar(32) DEFAULT NULL,
  `type` varchar(32) DEFAULT NULL,
  `length` int(11) DEFAULT NULL,
  `value` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `test` */

insert  into `test`(`id`,`node_id`,`type`,`length`,`value`) values (1,'52004','double',0,'222'),(2,'52002','double',0,'3.5'),(3,'52003','double',0,'23'),(4,'52005','string',19,'2016-12-19 12:42:12');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识，自增',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名，不同于姓名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码，MD5加密',
  `author_id` int(11) DEFAULT NULL COMMENT '权限，外键关联author',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `sex` int(1) DEFAULT '0' COMMENT '性别，默认0未知，1男，2女',
  `birthday` datetime DEFAULT NULL COMMENT '生日，可推算出年龄',
  `country` varchar(32) DEFAULT NULL COMMENT '国家',
  `city` varchar(32) DEFAULT NULL COMMENT '城市',
  `address` varchar(64) DEFAULT NULL COMMENT '地址',
  `qq` varchar(16) DEFAULT NULL COMMENT 'QQ号码',
  `wechart` varchar(16) DEFAULT NULL COMMENT '微信',
  `ip` varchar(32) DEFAULT NULL COMMENT '登陆IP',
  `login_num` int(11) DEFAULT NULL COMMENT '登陆次数',
  `last_time` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `at_time` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`),
  KEY `author_id` (`author_id`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`,`author_id`,`phone`,`email`,`name`,`sex`,`birthday`,`country`,`city`,`address`,`qq`,`wechart`,`ip`,`login_num`,`last_time`,`at_time`) values (1,'admin','admin',1,'18304071393','peter-no@foxmail.com','张红元',1,'2016-12-17 19:44:11','中国','武汉','光谷','939510703','peter-no','172.0.0.1',161,'2017-05-09 19:39:09','2016-12-17 19:44:49');

/*Table structure for table `weather` */

DROP TABLE IF EXISTS `weather`;

CREATE TABLE `weather` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增，唯一标识',
  `code` int(4) DEFAULT NULL COMMENT '天气代码',
  `description` varchar(8) DEFAULT NULL COMMENT '描述，多云',
  `picture` varchar(8) DEFAULT NULL COMMENT '图片名',
  `at_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8;

/*Data for the table `weather` */

insert  into `weather`(`id`,`code`,`description`,`picture`,`at_time`) values (40,0,'晴','0.png','2016-12-14 19:14:53'),(41,1,'晴','1.png','2016-12-14 19:14:53'),(42,2,'晴','2.png','2016-12-14 19:14:53'),(43,3,'晴','3.png','2016-12-14 19:14:53'),(44,4,'多云','4.png','2016-12-14 19:14:53'),(45,5,'晴间多云','5.png','2016-12-14 19:14:53'),(46,6,'晴间多云','6.png','2016-12-14 19:14:53'),(47,7,'大部多云','7.png','2016-12-14 19:14:53'),(48,8,'大部多云','8.png','2016-12-14 19:14:53'),(49,9,'阴','9.png','2016-12-14 19:14:53'),(50,10,'阵雨','10.png','2016-12-14 19:14:53'),(51,11,'雷阵雨','11.png','2016-12-14 19:14:53'),(52,12,'雷阵雨伴有冰雹','12.png','2016-12-14 19:14:53'),(53,13,'小雨','13.png','2016-12-14 19:14:53'),(54,14,'中雨','14.png','2016-12-14 19:14:53'),(55,15,'大雨','15.png','2016-12-14 19:14:53'),(56,16,'暴雨','16.png','2016-12-14 19:14:53'),(57,17,'大暴雨','17.png','2016-12-14 19:14:53'),(58,18,'特大暴雨','18.png','2016-12-14 19:14:53'),(59,19,'冻雨','19.png','2016-12-14 19:14:53'),(60,20,'雨夹雪','20.png','2016-12-14 19:14:53'),(61,21,'阵雪','21.png','2016-12-14 19:14:53'),(62,22,'小雪','22.png','2016-12-14 19:14:53'),(63,23,'中雪','23.png','2016-12-14 19:14:53'),(64,24,'大雪','24.png','2016-12-14 19:14:53'),(65,25,'暴雪','25.png','2016-12-14 19:14:53'),(66,26,'浮尘','26.png','2016-12-14 19:14:53'),(67,27,'扬沙','27.png','2016-12-14 19:14:53'),(68,28,'沙尘暴','28.png','2016-12-14 19:14:53'),(69,29,'强沙尘暴','29.png','2016-12-14 19:14:53'),(70,30,'雾','30.png','2016-12-14 19:14:53'),(71,31,'霾','31.png','2016-12-14 19:14:53'),(72,32,'风','32.png','2016-12-14 19:14:53'),(73,33,'大风','33.png','2016-12-14 19:14:53'),(74,34,'飓风','34.png','2016-12-14 19:14:53'),(75,35,'热带风暴','35.png','2016-12-14 19:14:53'),(76,36,'龙卷风','36.png','2016-12-14 19:14:53'),(77,37,'冷','37.png','2016-12-14 19:14:53'),(78,38,'热','38.png','2016-12-14 19:14:53'),(79,99,'未知','99.png','2016-12-14 19:14:53');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
