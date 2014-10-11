/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2014/10/12 7:38:00                           */
/*==============================================================*/


DROP TABLE IF EXISTS T_AREA;

DROP TABLE IF EXISTS T_CLIENT_TYPE;

DROP TABLE IF EXISTS T_CLIENT_VERSION;

DROP TABLE IF EXISTS T_CONFIG;

DROP TABLE IF EXISTS T_MESSAGE;

DROP TABLE IF EXISTS T_MESSAGE_RECEIVED;

DROP TABLE IF EXISTS T_MESSAGE_REPLY;

DROP TABLE IF EXISTS T_MESSAGE_REPORTED;

DROP TABLE IF EXISTS T_MESSAGE_SEND;

DROP TABLE IF EXISTS T_USER;

DROP TABLE IF EXISTS T_USER_BALANCE;

DROP TABLE IF EXISTS T_USER_BALANCE_HIS;

DROP TABLE IF EXISTS T_USER_KEY;

DROP TABLE IF EXISTS T_USER_LINKMAN;

DROP TABLE IF EXISTS T_USER_LOGIN;

DROP TABLE IF EXISTS T_USER_SENT;

DROP TABLE IF EXISTS T_USER_SET;

DROP TABLE IF EXISTS T_USER_VIP;

DROP TABLE IF EXISTS T_USER_VIP_HIS;

/*==============================================================*/
/* Table: T_AREA                                                */
/*==============================================================*/
CREATE TABLE T_AREA
(
   CODE                 VARCHAR(30) NOT NULL COMMENT '区域编码',
   PARENT_CODE          VARCHAR(30) COMMENT '父区域编号',
   NAME                 VARCHAR(60) COMMENT '区域名称',
   LEVEL                SMALLINT COMMENT '0 全国 1省 2市 3区/县 4街道/乡镇 5社区/村',
   PRIMARY KEY (CODE)
);

ALTER TABLE T_AREA COMMENT '行政区划表';

/*==============================================================*/
/* Table: T_CLIENT_TYPE                                         */
/*==============================================================*/
CREATE TABLE T_CLIENT_TYPE
(
   CODE                 VARCHAR(30) NOT NULL COMMENT '类型编号',
   NAME                 VARCHAR(30) COMMENT '类型名称',
   REMARK               VARCHAR(100) COMMENT '类型备注',
   CURRENT_VERSION      VARCHAR(60) COMMENT '当前版本',
   PRIMARY KEY (CODE)
);

ALTER TABLE T_CLIENT_TYPE COMMENT '客户端类型';

/*==============================================================*/
/* Table: T_CLIENT_VERSION                                      */
/*==============================================================*/
CREATE TABLE T_CLIENT_VERSION
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT COMMENT '版本编号',
   CLIENT_CODE          VARCHAR(30) COMMENT '客户端编码',
   VERSION              VARCHAR(30) COMMENT '版本号',
   IS_NEWEST            VARCHAR(30) COMMENT '是否当前版本',
   INCR_DOWNLOAD_URL    VARCHAR(120) COMMENT '增量版本下载地址',
   FULL_DOWNLOAD_URL    VARCHAR(120) COMMENT '量版本下载地址',
   INTRODUCE_URL        VARCHAR(100) COMMENT '版本内容介绍url',
   REMARK               VARCHAR(100) COMMENT '备注',
   PRIMARY KEY (ID)
);

ALTER TABLE T_CLIENT_VERSION COMMENT '客户端版本';

/*==============================================================*/
/* Table: T_CONFIG                                              */
/*==============================================================*/
CREATE TABLE T_CONFIG
(
   CONFIG_KEY           VARCHAR(30) NOT NULL COMMENT '键值',
   CONFIG_VALUE         VARCHAR(60) NOT NULL COMMENT 'value值',
   REMARK               VARCHAR(100) COMMENT '键注释',
   CREATE_TIME          TIMESTAMP COMMENT '创建时间',
   PRIMARY KEY (CONFIG_KEY, CONFIG_VALUE)
);

ALTER TABLE T_CONFIG COMMENT '参数配置表';

/*==============================================================*/
/* Table: T_MESSAGE                                             */
/*==============================================================*/
CREATE TABLE T_MESSAGE
(
   MSG_ID               BIGINT NOT NULL AUTO_INCREMENT COMMENT '信息编号',
   TITLE                VARCHAR(80) COMMENT '标题',
   CONTEXT              VARCHAR(144) COMMENT '内容',
   VALID_TIME           TIMESTAMP COMMENT '有效时间止',
   SEND_TYPE            INT COMMENT '1 距离 2行政区域',
   SEND_AREA            VARCHAR(30) COMMENT '发送到的行政区域',
   SEND_DISTANCE        VARCHAR(20) COMMENT '1 1km以内 2 2km以内 ...',
   AMOUNT_STATUS        INT COMMENT '1 有偿消息 0 无偿消息',
   AMOUNT               DECIMAL(10) COMMENT '有偿金额',
   MSG_STATUS           INT COMMENT '1 创建 2审核通过 3审核拒绝 4删除',
   CREATE_USER_ID       BIGINT COMMENT '创建人',
   GPSY                 VARCHAR(30) COMMENT '信息发布时所在经度',
   GPSX                 VARCHAR(30) COMMENT '信息发布时所在维度',
   REGIN_CODE           VARCHAR(30) COMMENT '信息发布所在行政区域',
   CREATE_TIME          TIMESTAMP COMMENT '创建时间',
   PRIMARY KEY (MSG_ID)
);

/*==============================================================*/
/* Table: T_MESSAGE_RECEIVED                                    */
/*==============================================================*/
CREATE TABLE T_MESSAGE_RECEIVED
(
   PUBLISH_ID           BIGINT NOT NULL AUTO_INCREMENT COMMENT '推送编号',
   MSG_ID               BIGINT NOT NULL COMMENT '信息编号',
   RECEIVED_USERID      BIGINT NOT NULL COMMENT '收信人ID',
   SEND_USERID          BIGINT NOT NULL COMMENT '发信人用户ID',
   SEND_NEW_REPLY       INT COMMENT '1发信方有新回复 0 无新回复',
   RECEIVED_NEW_REPLY   INT COMMENT '1收信方有新回复 0 无新回复',
   RECEIVED_STAUS       INT COMMENT '0 收信方未读 1收信方已读 2 收信方已删除',
   READ_TIME            TIMESTAMP COMMENT '阅读时间',
   DELETE_TIME          TIMESTAMP COMMENT '删除时间',
   PUBISH_TIME          TIMESTAMP COMMENT '收信方时间',
   PRIMARY KEY (PUBLISH_ID)
);

ALTER TABLE T_MESSAGE_RECEIVED COMMENT '用户收信表';

/*==============================================================*/
/* Table: T_MESSAGE_REPLY                                       */
/*==============================================================*/
CREATE TABLE T_MESSAGE_REPLY
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT COMMENT '编号',
   MSG_ID               BIGINT COMMENT '信息编号',
   REPLY_USER_ID        BIGINT COMMENT '回复人编号',
   BE_REPLYED_USER_ID   BIGINT COMMENT '被回复人编号',
   CONTEXT              VARCHAR(144) COMMENT '回复内容',
   STATUS               INT COMMENT '0 创建 1审核通过 2删除',
   CREATE_TIME          TIMESTAMP COMMENT '创建时间',
   PRIMARY KEY (ID)
);

ALTER TABLE T_MESSAGE_REPLY COMMENT '信息回复表';

/*==============================================================*/
/* Table: T_MESSAGE_REPORTED                                    */
/*==============================================================*/
CREATE TABLE T_MESSAGE_REPORTED
(
   REPORTED_ID          BIGINT NOT NULL AUTO_INCREMENT COMMENT '举报编号',
   BE_REPORTED_USER_ID  BIGINT COMMENT '被举报用户ID',
   BE_REPORTED_MSG_ID   BIGINT NOT NULL COMMENT '被举报用户信息ID',
   CONTEXT              VARCHAR(100) COMMENT '举报内容',
   REPORT_TYPE          INT COMMENT '举报类型',
   REPORT_USER_ID       BIGINT COMMENT '举报人',
   CREATE_TIME          TIMESTAMP COMMENT '创建时间',
   DEAL_STATUS          INT COMMENT '1 已处理 0 未处理',
   DEAL_RESULT          VARCHAR(100) COMMENT '降低信用值等...',
   PRIMARY KEY (REPORTED_ID)
);

ALTER TABLE T_MESSAGE_REPORTED COMMENT '信息举报表';

/*==============================================================*/
/* Table: T_MESSAGE_SEND                                        */
/*==============================================================*/
CREATE TABLE T_MESSAGE_SEND
(
   MSG_ID               BIGINT NOT NULL AUTO_INCREMENT COMMENT '消息ID',
   SEND_USER_ID         BIGINT NOT NULL COMMENT '发送人',
   PUBLISH_STATUS       INT COMMENT '1 已推送 0 未推送',
   PUBLISH_TIME         TIMESTAMP COMMENT '推送时间',
   PUBLISH_COUNT        INT COMMENT '推送到的人数',
   READ_COUNT           INT COMMENT '阅读人数',
   PUBLISH_TYPE         INT COMMENT '1 广播 2行业 3点对点',
   SEND_TIME            TIMESTAMP COMMENT '发送时间',
   SEND_CURRENT_CREDIT  INT COMMENT '发送人当前信用点',
   NEW_REPLY_FOR_SEND   INT COMMENT '发信方有新回复',
   MSG_STATUS           INT COMMENT '1 创建  2审核通过 3审核拒绝 4删除',
   PUBLISH_TO           VARCHAR(30) COMMENT '推送到的行业或指定的推送人',
   CREATE_TIME          TIMESTAMP COMMENT '创建时间',
   PRIMARY KEY (MSG_ID)
);

ALTER TABLE T_MESSAGE_SEND COMMENT '用户发信表';

/*==============================================================*/
/* Table: T_USER                                                */
/*==============================================================*/
CREATE TABLE T_USER
(
   USER_ID              BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户ID',
   USER_NAME            VARCHAR(50) COMMENT '用户昵称',
   MOBILE               VARCHAR(20) NOT NULL COMMENT '手机号码',
   USER_STATE           INT COMMENT '用户状态 1正常，2禁用，3删除',
   PASSWD               VARCHAR(32) COMMENT '密码',
   REG_GPSY             VARCHAR(20) COMMENT '注册时经度',
   REG_GPSX             VARCHAR(20) COMMENT '注册时纬度',
   REG_EAREA            VARCHAR(20) COMMENT '注册时所在行政区域',
   VIP                  INT COMMENT '是否vip用户',
   REG_TIME             TIMESTAMP COMMENT '注册时间',
   PRIMARY KEY (USER_ID)
);

ALTER TABLE T_USER COMMENT '用户表';

/*==============================================================*/
/* Table: T_USER_BALANCE                                        */
/*==============================================================*/
CREATE TABLE T_USER_BALANCE
(
   USER_ID              BIGINT NOT NULL COMMENT '用户ID',
   USER_CREDIT          INT COMMENT '信用值',
   USER_BALANCE         INT COMMENT '用户余额',
   PRIMARY KEY (USER_ID)
);

ALTER TABLE T_USER_BALANCE COMMENT '用户余额';

/*==============================================================*/
/* Table: T_USER_BALANCE_HIS                                    */
/*==============================================================*/
CREATE TABLE T_USER_BALANCE_HIS
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT COMMENT '编号',
   USER_ID              BIGINT NOT NULL COMMENT '用户ID',
   USER_CREDIT          INT COMMENT '信用值',
   USER_BALANCE         INT COMMENT '用户余额',
   PRIMARY KEY (ID)
);

ALTER TABLE T_USER_BALANCE_HIS COMMENT '用户余额历史';

/*==============================================================*/
/* Table: T_USER_KEY                                            */
/*==============================================================*/
CREATE TABLE T_USER_KEY
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT COMMENT '编号',
   USER_ID              BIGINT NOT NULL COMMENT '用户编号',
   KEY_LEVEL            INT COMMENT '关键字级别1最低 2,3,4...',
   KEY_NAME             VARCHAR(100) COMMENT '关键字名',
   CREATE_TIME          TIMESTAMP COMMENT '创建时间',
   PRIMARY KEY (ID)
);

ALTER TABLE T_USER_KEY COMMENT '用户收信关键字';

/*==============================================================*/
/* Table: T_USER_LINKMAN                                        */
/*==============================================================*/
CREATE TABLE T_USER_LINKMAN
(
   USER_ID              BIGINT NOT NULL COMMENT '联系用户ID',
   LINK_USER_ID         BIGINT NOT NULL COMMENT '联系用户名称',
   LINK_REMARK          VARCHAR(50) COMMENT '记录用户名称',
   CREATE_TIME          TIMESTAMP COMMENT '联系人重名',
   PRIMARY KEY (USER_ID, LINK_USER_ID)
);

ALTER TABLE T_USER_LINKMAN COMMENT '用户联系人';

/*==============================================================*/
/* Table: T_USER_LOGIN                                          */
/*==============================================================*/
CREATE TABLE T_USER_LOGIN
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT COMMENT '登陆编号',
   USER_ID              BIGINT NOT NULL COMMENT '用户ID',
   LOGIN_TIME           TIMESTAMP COMMENT '登陆时间',
   GPSX                 VARCHAR(32) COMMENT '登陆GPS-X',
   GPSY                 VARCHAR(32) COMMENT '登陆GPS-Y',
   LOGIN_IP             VARCHAR(30) COMMENT '登陆ip',
   CLIENT_VERSION       VARCHAR(30) COMMENT '软件版本',
   CLIENT_TYPE          VARCHAR(32) COMMENT '软件终端',
   LOGIN_AREA           CHAR(10) COMMENT '登陆所在行政区域',
   PRIMARY KEY (ID)
);

ALTER TABLE T_USER_LOGIN COMMENT '用户登陆';

/*==============================================================*/
/* Table: T_USER_SENT                                           */
/*==============================================================*/
CREATE TABLE T_USER_SENT
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT COMMENT '收信语编号',
   USER_ID              BIGINT NOT NULL COMMENT '用户ID',
   USER_SENT            VARCHAR(144) COMMENT '用户收信内容',
   CREATE_TIME          TIMESTAMP COMMENT '创建时间',
   PRIMARY KEY (ID)
);

ALTER TABLE T_USER_SENT COMMENT '用户收信语';

/*==============================================================*/
/* Table: T_USER_SET                                            */
/*==============================================================*/
CREATE TABLE T_USER_SET
(
   USER_ID              BIGINT NOT NULL COMMENT '用户编号',
   NEW_MSG_NOTIFY       INT COMMENT '是否新消息通知',
   VOICE                INT COMMENT '通知声音是否开启',
   VIBRATE              INT COMMENT '通知震动是否开启',
   MAX_COUNT            INT COMMENT '一天最多接收消息条数',
   SIMILAR_LEVEL        INT COMMENT '接收消息相似度级别',
   MIN_AMMOUNT          INT COMMENT '消息有偿额',
   MIN_CREDIT           INT COMMENT '接收消息最低信用值',
   UPDATETIME           TIMESTAMP COMMENT '修改时间',
   PRIMARY KEY (USER_ID)
);

ALTER TABLE T_USER_SET COMMENT '用户设置';

/*==============================================================*/
/* Table: T_USER_VIP                                            */
/*==============================================================*/
CREATE TABLE T_USER_VIP
(
   USER_ID              BIGINT NOT NULL COMMENT '用户编号',
   VIP_TATUS            INT COMMENT '1正常，2禁用，3过期',
   VIP_REG_TIME         TIMESTAMP COMMENT 'vip启用时间',
   VIP_END_TIME         TIMESTAMP COMMENT 'vip截止时间',
   PRIMARY KEY (USER_ID)
);

ALTER TABLE T_USER_VIP COMMENT '用户VIP';

/*==============================================================*/
/* Table: T_USER_VIP_HIS                                        */
/*==============================================================*/
CREATE TABLE T_USER_VIP_HIS
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT COMMENT '编号',
   USER_ID              BIGINT NOT NULL COMMENT '用户编号',
   VIP_TATUS            INT COMMENT '1正常，2禁用，3过期',
   VIP_REG_TIME         TIMESTAMP COMMENT 'vip启用时间',
   VIP_END_TIME         TIMESTAMP COMMENT 'vip截止时间',
   PRIMARY KEY (ID)
);

ALTER TABLE T_USER_VIP_HIS COMMENT '用户VIP注册历史';

ALTER TABLE T_MESSAGE_SEND ADD CONSTRAINT FK_REFERENCE_4 FOREIGN KEY (MSG_ID)
      REFERENCES T_MESSAGE (MSG_ID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE T_USER_BALANCE ADD CONSTRAINT FK_REFERENCE_12 FOREIGN KEY (USER_ID)
      REFERENCES T_USER (USER_ID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE T_USER_LOGIN ADD CONSTRAINT FK_REFERENCE_8 FOREIGN KEY (USER_ID)
      REFERENCES T_USER (USER_ID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE T_USER_SENT ADD CONSTRAINT FK_REFERENCE_14 FOREIGN KEY (USER_ID)
      REFERENCES T_USER (USER_ID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE T_USER_SET ADD CONSTRAINT FK_REFERENCE_11 FOREIGN KEY (USER_ID)
      REFERENCES T_USER (USER_ID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE T_USER_VIP ADD CONSTRAINT FK_REFERENCE_7 FOREIGN KEY (USER_ID)
      REFERENCES T_USER (USER_ID) ON DELETE RESTRICT ON UPDATE RESTRICT;

