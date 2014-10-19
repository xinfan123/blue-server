/*
SQLyog Ultimate v11.13 (64 bit)
MySQL - 5.1.69 : Database - bulu
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bulu` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bulu`;

/*Data for the table `t_advice` */

insert  into `t_advice`(`AD_ID`,`CONTENT`,`MOBILE`,`CREATE_TIME`,`DEAL`,`DEAL_TIME`) values (1,'奖学金就到家','+8618673119686','2014-10-18 21:48:53',0,'0000-00-00 00:00:00'),(2,'你心目中靠自己','+8618673119686','2014-10-18 21:50:37',0,'0000-00-00 00:00:00'),(3,'你想见的卡西可开心开心快','+8618673119686','2014-10-18 21:50:53',0,'0000-00-00 00:00:00');

/*Data for the table `t_area` */

/*Data for the table `t_client_type` */

/*Data for the table `t_client_version` */

insert  into `t_client_version`(`ID`,`CLIENT_CODE`,`VERSION`,`IS_NEWEST`,`INCR_DOWNLOAD_URL`,`FULL_DOWNLOAD_URL`,`INTRODUCE_URL`,`REMARK`) values (1,'android','1.0.1','1','http://192.168.1.104:7001/updates/bulu.apk','http://192.168.1.104:7001/updates/bulu.apk','PrintShop是MakerBot在今年5月份发布的一款安装在ipad上的3D模型制造工具，当时的主要功能为制造艺术字、制造手环、制造戒指，而这些设计好的模型只能在MakerBot五代机型上进行打印。此次版本更新，不仅仅增加了新的设计模型而且对之前版本的漏洞进行了修复。','11');

/*Data for the table `t_config` */

/*Data for the table `t_message` */

insert  into `t_message`(`MSG_ID`,`TITLE`,`CONTEXT`,`VALID_TIME`,`SEND_TYPE`,`SEND_AREA`,`SEND_DISTANCE`,`AMOUNT_STATUS`,`AMOUNT`,`MSG_STATUS`,`CREATE_USER_ID`,`GPSY`,`GPSX`,`REGIN_CODE`,`CREATE_TIME`) values (1,'就是看看这','你舅舅家','2014-10-18 14:01:54',0,'null','null',0,0,4,1,'null','null','null','2014-10-18 13:55:57'),(2,'可惜可开心快','奖学金想看看','2014-10-18 14:04:46',0,'null','null',0,0,4,1,'null','null','null','2014-10-18 13:57:27'),(3,'可惜可开心快','奖学金想看看','2014-10-18 14:19:58',0,'null','null',0,0,2,1,'null','null','null','2014-10-18 13:57:27'),(4,'就下课就先解决','就像经济学家姐','2014-10-18 14:08:08',0,'null','null',0,0,2,1,'null','null','null','2014-10-18 14:08:08');

/*Data for the table `t_message_received` */

/*Data for the table `t_message_reply` */

/*Data for the table `t_message_reported` */

/*Data for the table `t_message_send` */

insert  into `t_message_send`(`MSG_ID`,`SEND_USER_ID`,`PUBLISH_STATUS`,`PUBLISH_TIME`,`PUBLISH_COUNT`,`READ_COUNT`,`PUBLISH_TYPE`,`SEND_TIME`,`SEND_CURRENT_CREDIT`,`NEW_REPLY_FOR_SEND`,`MSG_STATUS`,`PUBLISH_TO`,`CREATE_TIME`) values (1,1,NULL,'2014-10-18 14:01:54',NULL,NULL,0,'2014-10-18 13:57:27',111,0,4,'null','2014-10-18 13:57:27'),(2,1,NULL,'2014-10-18 14:04:47',NULL,NULL,0,'2014-10-18 13:57:27',111,0,4,'null','2014-10-18 13:57:27'),(3,1,NULL,'2014-10-18 14:08:08',NULL,NULL,0,'2014-10-18 14:08:08',111,0,2,'null','2014-10-18 14:08:08');

/*Data for the table `t_user` */

insert  into `t_user`(`USER_ID`,`USER_NAME`,`MOBILE`,`USER_STATE`,`PASSWD`,`REG_GPSY`,`REG_GPSX`,`REG_EAREA`,`VIP`,`REG_TIME`) values (1,'把自己','18673119686',1,'e3f01fd8ddd359d225e2275ba62d69b1','1','1','1',0,'2014-10-18 19:08:48'),(2,'11','15580060516',1,'e3f01fd8ddd359d225e2275ba62d69b1','112.977447','28.189422','长沙市',0,'2014-10-19 16:59:33'),(3,'22','15580060546',1,'e3f01fd8ddd359d225e2275ba62d69b1','112.977447','28.189422','长沙市',0,'2014-10-19 16:59:47'),(4,'333','15580060526',1,'e3f01fd8ddd359d225e2275ba62d69b1','112.977447','28.189422','长沙市',0,'2014-10-19 16:59:39');

/*Data for the table `t_user_balance` */

insert  into `t_user_balance`(`USER_ID`,`USER_CREDIT`,`USER_BALANCE`) values (1,111,212),(2,0,0),(3,0,0),(4,0,0);

/*Data for the table `t_user_balance_his` */

insert  into `t_user_balance_his`(`ID`,`USER_ID`,`USER_CREDIT`,`USER_BALANCE`) values (1,2,0,0),(2,3,0,0),(3,4,0,0);

/*Data for the table `t_user_key` */

/*Data for the table `t_user_linkman` */

/*Data for the table `t_user_login` */

/*Data for the table `t_user_sent` */

insert  into `t_user_sent`(`ID`,`USER_ID`,`USER_SENT`,`CREATE_TIME`) values (28,1,'uuuuu','2014-10-13 23:29:56'),(29,1,'你的考试考','2014-10-15 21:04:38');

/*Data for the table `t_user_set` */

insert  into `t_user_set`(`USER_ID`,`NEW_MSG_NOTIFY`,`VOICE`,`VIBRATE`,`MAX_COUNT`,`SIMILAR_LEVEL`,`MIN_AMMOUNT`,`MIN_CREDIT`,`UPDATETIME`) values (1,0,0,0,0,0,0,0,'2014-10-19 20:28:00'),(2,1,1,1,20,3,0,10,'2014-10-19 16:55:56'),(3,1,1,1,20,3,0,10,'2014-10-19 16:55:59'),(4,1,1,1,20,3,0,10,'2014-10-19 16:56:00');

/*Data for the table `t_user_vip` */

/*Data for the table `t_user_vip_his` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
