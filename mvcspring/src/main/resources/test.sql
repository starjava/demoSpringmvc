 CREATE TABLE `t_user` (
	`f_id` INT(11) NOT NULL AUTO_INCREMENT,
	`f_name` VARCHAR(20) NULL DEFAULT NULL,
	`sex` CHAR(2) NULL DEFAULT NULL,
	PRIMARY KEY (`f_id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT
AUTO_INCREMENT=1
INSERT INTO `t_user` (`f_id`, `f_name`, `sex`) VALUES (1, 'A', '男');
INSERT INTO `t_user` (`f_id`, `f_name`, `sex`) VALUES (2, 'B', '女');
INSERT INTO `t_user` (`f_id`, `f_name`, `sex`) VALUES (3, 'C', '男');
INSERT INTO `t_user` (`f_id`, `f_name`, `sex`) VALUES (4, 'D', '女');
INSERT INTO `t_user` (`f_id`, `f_name`, `sex`) VALUES (5, 'E', '女');
INSERT INTO `t_user` (`f_id`, `f_name`, `sex`) VALUES (6, 'F', '女');
 DELIMITER $
CREATE  PROCEDURE `PRO_GET_USER_COUNT`(IN `sex_id` INT, OUT `user_count` INT)
	LANGUAGE SQL
	NOT DETERMINISTIC
	CONTAINS SQL
	SQL SECURITY DEFINER
	COMMENT ''
BEGIN
IF sex_id=0 then 
select count(f_id)from t_user where sex='女'into user_count;
else
select count(f_id)from t_user where sex='男'into user_count;
END if;
end
$
 DELIMITER $
 CREATE DEFINER=`root`@`localhost` PROCEDURE `PRO_GET_USER_INFO`()
	LANGUAGE SQL
	NOT DETERMINISTIC
	CONTAINS SQL
	SQL SECURITY DEFINER
	COMMENT ''
BEGIN
select *from t_user where sex='女';
end
 $
 DELIMITER $
CREATE PROCEDURE `PRO_GET_USER_MORE_COUNT`(IN `sex_id` INT, OUT `boy_count` INT,OUT girl_count INT)
	LANGUAGE SQL
	NOT DETERMINISTIC
	CONTAINS SQL
	SQL SECURITY DEFINER
	COMMENT '2个OUT参数，返回多结果集'
BEGIN
set sex_id=0 ;
select count(f_id)from t_user where sex='女'into boy_count;
select count(f_id)from t_user where sex='男'into girl_count;
end
$
call PRO_GET_USER_MORE_COUNT(0,@boy,@girl);
select @boy,@girl;

 DELIMITER $
CREATE PROCEDURE `PRO_GET_USER_MORE_USERS`()
	LANGUAGE SQL
	NOT DETERMINISTIC
	CONTAINS SQL
	SQL SECURITY DEFINER
	COMMENT '返回多结果集'
BEGIN
select *from t_user where sex='女';
select *from t_user where sex='男';
end
$
call PRO_GET_USER_MORE_USERS();









