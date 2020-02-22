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