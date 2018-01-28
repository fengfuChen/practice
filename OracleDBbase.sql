DB
	数据库(DB) :按照数据额结构来组织,存储和管理数据的仓库
数据库管理系统(DBMS):管理数据库的软件

RDBMS 关系数据库管理系统

	Oracle
	DB2
	Sybase
	SQL Server
	MySQL


SQL分类
	DDL:数据定义语言, 管理数据结构
			CREATE, ALTER, DROP, TRUNCATE 删除表数据, 保留表结构
	DML:数据操纵语言, 改变表数据
			INSERT, UPDATE, DELETE
	TCL:事物控制语言
			COMMIT, ROLLBACK, SAVEPOINT 保存点, 存档点
	DQL:数据查询语言
			SELECT
	DCL:数据控制语言, 权限, 赋权
			GRANT 授权
			REVOKE 收回权限
			CREATE USER 创建用户

常用函数
	CONCAT(str1,str2,...), ||   拼接字符串
	LENGTH(str) 返回字符串长度
	UPPER(str) 转大写
	LOWER(str) 转小写
	INITCAP(str) 首字母大写
	TRIM([remstr FROM] str) 从str的前后截去remstr
	oracle:LTRIM(str [, remStr]):左截去remstr; RTRIM(str [, remStr]):右截去remstr;
	mysql:LTRIM(str):左截去空格; 	RTRIM(str)右去空格

	LPAD(str,len,padstr) 左补位;
	RPAD(str,len,padstr) 右补位
	oracle: SUBSTR(str [, m [n]]) 
	mysql:SUBSTR(str FROM pos FOR len) 
	oracle:INSTR(str,substr[, n[,m]]) 返子字符串在字符串的位置, n起始位置, m 次数
	mysql:INSTR(str,substr) 返子字符串在字符串的位置
	
	ROUND(n [, m]) 四舍五入 n 源数字, m小数位
	TRUNCATE(X,D) 截取数字 
	MOD(N,M)  除法取余
	CEIL(X) 向上取整
	FLOOR(X) 向下取整
	
	TO_DATE(cahr, format) str转换为时间
	TO_CHAR(date, format)	时间格式化输出
	LAST_DAY(date) 所在月最后一天
	add_month(date, i) date后i月
	month_between(date1, date2) 时间差月
	next_day(date, char) 下一个周几
	LEAST(value1,value2,...) 返回最小日期
	GREATEST(value1,value2,...) 返回最大日期
	NVL(expr1, expr2) null 值转换
	NVL2(expr1, expr2, expr2) 不是null返回expr2,是null返回expr3
	DISTINCT 去重

	聚合函数
	MAX(expr), MIN(expr), SUM(expr), AVG([DISTINCT] expr), COUNT(expr)

	GROUP BY 分组
	HAVING: HAVING子句用来对分组后的结果进一步限制

	执行顺序:
		1. from 子句, 从后往前, 从右到左
		2. where 子句, 自上而下, 从右到左
		3. GROUP BY 从左往右分组

	关联:
		JOIN, LEFT JOIN, RIGHT JOIN, FULL OUTER JOIN




*/