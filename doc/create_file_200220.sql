CREATE TABLE IF NOT EXISTS `user_tb1`(
   `user_id` INT UNSIGNED AUTO_INCREMENT,
   `user_name` VARCHAR(40) NOT NULL,
   `user_pwd` VARCHAR(40) NOT NULL,
   PRIMARY KEY ( `user_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `file_info`(
   `file_id` BIGINT NOT NULL,
   `file_parentid` BIGINT NOT NULL,
   `file_name` VARCHAR(40) NOT NULL,
   `file_size` BIGINT NOT NULL,
   `file_path` VARCHAR(40) NOT NULL,
   `creator` VARCHAR(40) NOT NULL,
   `editor` VARCHAR(40) NOT NULL,
   `c_ctime` DATETIME NOT NULL,
   `c_ctime_millisecond` MEDIUMINT NOT NULL,
   `c_mtime` DATETIME NOT NULL,
   `c_mtime_millisecond` MEDIUMINT NOT NULL,
   PRIMARY KEY ( `file_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `fileid_filecode`(
   `file_id` BIGINT NOT NULL,
   `file_code` VARCHAR(40) NOT NULL,
   PRIMARY KEY ( `file_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `user_file`(
    `user_id` INT NOT NULL,
   `file_id` VARCHAR(40)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `user_token`(
    `user_id` INT NOT NULL,
   `token` VARCHAR(40)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
//以上为建表语句
------------------------------------------------------------------------------
//以下为测试插入语句
INSERT INTO user_tb1 ( user_name,user_pwd)
                       VALUES
                       ( "3214640369","501090LB" );
注意这两个语句，在cmd窗口显示是一样的区分不开
select * from  user_tbl; //错误
select * from  user_tb1; //正确
197568495618 文件id
----------------------------------------------------------------------
数据表模型         数据库名 csfile
user_tb1 (用户表)
user_id       INT                   user_id为唯一键 不能为null
user_name     VARCHAR
user_pwd      VARCHAR
user_id->
    user_name
    user_pwd

file_info (文件表)
file_id       BIGINT
file_parentid BIGINT
file_name     VARCHAR
file_size      BIGINT
file_path     VARCHAR    绝对路径
creator       VARCHAR
editor        VARCHAR
c_ctime       DATETIME
c_ctime_millisecond MEDIUMINT   精确到毫秒
c_mtime       DATETIME
c_mtime_millisecond MEDIUMINT   精确到毫秒
file_id->
    file_parent_id
    file_name
    file_size
    file_path
    creator
    editor
    c_ctime
    c_mtime

fileid_filecode  (fileid&filecode)
file_id
file_code
file_id->
    file_code

user_file (用户&文件)    业务上用户id和根文件ID
user_id       INT
file_id       BIGINT
user_id->
    file_id

user_token (用户&token)
user_id       INT
token         CHAR
user_token->
    user_id

mapper 的实例作为service bean的成员属性，依然被共享。不符合应在函数中即用即毁。（mpper实例壳子确实可以是单例的。mapper中内涵的
sqlsession是即用即关的。MapperFactoryBean）

托管至：在某一步触发下（某一个mapper类），依赖MapperFactory bean，入参Mapper.class，获取出mapper实例。
@Resource处，获取bean的时候再次被截获出mapper的实例。