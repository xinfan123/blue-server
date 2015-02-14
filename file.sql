drop table if exists t_message;

/*==============================================================*/
/* table: t_message                                             */
/*==============================================================*/
create table t_message
(
   msg_id               bigint not null auto_increment comment '信息编号',
   title                varchar(80) comment '标题',
   context              varchar(144) comment '内容',
   valid_time           timestamp comment '有效时间止',
   duration_time        int comment '持续时间（分）',
   send_type            int comment '1 距离 2行政区域',
   send_area            varchar(30) comment '发送到的行政区域',
   send_distance        varchar(20) comment '1 1km以内 2 2km以内 ...',
   amount_status        int comment '1 有偿消息 0 无偿消息',
   amount               decimal(10) comment '有偿金额',
   msg_status           int comment '1 创建 2审核通过 3审核拒绝 4删除',
   create_user_id       bigint comment '创建人',
   gpsy                 varchar(30) comment '信息发布时所在经度',
   gpsx                 varchar(30) comment '信息发布时所在维度',
   regin_code           varchar(30) comment '信息发布所在行政区域',
   create_time          timestamp comment '创建时间',
   primary key (msg_id)
);
