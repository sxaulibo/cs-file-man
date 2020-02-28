CREATE TABLE IF NOT EXISTS `runoob_tbl`(
   `file_id` INT UNSIGNED AUTO_INCREMENT,
   `file_rootfid` VARCHAR(100) NOT NULL,
   `file_name` VARCHAR(40) NOT NULL,
   `file_password` VARCHAR(40) NOT NULL,
   `file_token` VARCHAR(100) NOT NULL,
   PRIMARY KEY ( `file_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO runoob_tbl ( file_rootfid, file_name,file_password,file_token)
                       VALUES
                       ( "197568495618", "root","root","" );
注意这两个语句，在cmd窗口显示是一样的区分不开
select * from  runoob_tbl;
select * from  runoob_tb1;
----------------------------------------------------------------------
数据表模型         数据库名 csfile
user_tb1 (用户表)
user_id       INT
user_name     VARCHAR
user_pwd      VARCHAR

file_tb2 (文件表)

file_id       BIGINT
file_name     VARCHAR
file_size      BIGINT
file_path     VARCHAR
creator       VARCHAR
editor        VARCHAR
c_ctime       DATETIME
c_ctime_millisecond MEDIUMINT   精确到毫秒
c_mtime       DATETIME
c_mtime_millisecond MEDIUMINT   精确到毫秒

file_tb1 (文件&文件 关联表)
file_id       BIGINT
file_parentid BIGINT

userid_fileid (用户&文件 关联表)    业务上用户id和根文件ID
user_id       INT
file_id       BIGINT

user_token (用户&token 关联表)
user_id       INT
token         CHAR
