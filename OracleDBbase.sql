/*

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

	EXISTS

	分页:
		ROWNUM

	DECODE(expr, search1, result1, search2, result2 ......, defultResult)
	CASE expr
	WHEN search1 THEN result1
	WHEN search2 THEN result2
	......
	ELSE defultResult END


排序:
	ROW_NUMBER() OVER(
		PARTITION BY col1 ORDER BY col2
		) -- 按照col1 分组, col2 排序

	RANK() OVER(
		PARTITION BY col1 ORDER BY col2
		) -- 根据col1 分组, 根据col2给与等级标识, col2等级相同则并列排名, 下一排名跳跃(eg: 两个第二, 无第三名, 直接跳到第四名)

		DENSE_RANK() OVER(
		PARTITION BY col1 ORDER BY col2
		) -- 根据col1 分组, 根据col2给与等级标识, col2等级相同则并列排名, 下一排名排名不跳跃(eg: 两个第二, 下一排名为第三, 不跳到第四名)


高级分组
		GROUP BY ROLLUP(col1, col2......coln) -- 从右到左一次少一列依次group by; eg: GROUP BY col1, col2; GROUP BY col1
		GROUP BY CUBE(col1, col2 .....ALTER.)
		GROUP BY grouping sets(col1, col2) -- GROUP BY col1, col2
		GROUP BY grouping sets((a, b), c) -- GROUP BY (a, b) , c

集合操作:
	UNION 		-- 并集, 去重, 自动排序
	UNION ALL -- 并集, 不去重
	INTERSECT -- 交集
	MINUS			-- 差集


视图:
	视图也被称为虚表, 是一组数据的逻辑表示
	视图对应于一条select语句, 结果集被赋予一个名字, 即视图名
	视图本身不包含数据, 它只包含映射到基表的一个查询语句, 当基表数据发生变化时视图数据随之改变
	对视图进行insert实际上是对基表进行insert
	视图是表的扩展, 限制数据访问, 安全和保密的作用
	创建视图
		CREATE VIEW viewName AS SELECT语句
			WITH CHECK OPTION -- 对视图进行的操作必须在视图中可见
	    WITH READ ONLY -- 只读视图
	删除视图: DROP VIEW viewName


	复杂视图: 在子查询中包含了表达式, 单行函数或分组函数的视图
	复杂视图不允许DML 操作

序列
	序列是一种用来生成唯一数字值得数据库对象, 通常作为表主键
	创建序列
		CREATE SEQUENCE sequence_name
		START WITH i -- 起始值
		INCREMENT BY j -- 步幅
		MAXVALUE m | NOMAXVALUE -- 上限
		MINVALUE N | NOMINVALUE -- 下限
		CYCLE | NOCYCLE -- 循环
		CACHE P | NOCACHE --  缓存, 默认20个缓存

	CURRVAL -- 当前序列值, 使用此伪劣序列不会自增
	NEXTVAL -- 下一个值

索引
	索引是允许直接访问数据表中某一数据行的树形结构, 可提高查询效率
	索引记录中存有索引关键字和指向表中数据的指针(地址)

创建索引
	CREATE [UNIQUE] INDEX index_name ON tableName(col1, col2 ......) -- UNIQUE INDEX 唯一索引
定期重建索引, 提高索引的空间利用率
	ALTER INDEX index_name REBUILD
删除
	DROP INDEX inde_name


约束 CONSTRAINT
	非空约束 Not NULL 简写 NN
	唯一性约束 UNIQUE 简写 UK
	主键约束 PRIMARY KEY  PK
	外键约束 FOREIGN KEY 	FK
	检查约束 CHECK 				CK


	ALTER TABLE table_name
		ADD CONSTRAINT uk_name UNIQUE
		ADD CONSTRAINT pk_name PRIMARY KEY(id)
		ADD CONSTRAINT fk_name FOREIGN KEY(parent_id) REFERENCES table2(id)
		ADD CONSTRAINT ck_name CHECK(age > 20)
		ADD CONSTRAINT ck_name CHECK(REGEXP_LIKE(col, 正则))

	-- DROP CONSTRAINT 约束名

*/