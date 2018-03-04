package com.dao;

import com.bean.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by chenfengfu on 2018/3/4.
 * spring --jdbc
 */
public class SpringJdbcDao {

    private JdbcTemplate template; // 或者集成 JdbcDaoSupport

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public List<User> query() {
        String sql = "select * from sys_user where name like %?% ";
        String[] param = {"张三"};
        RowMapper<User> userRowMapper = new RowMapper<User>() {
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                // ......
                return user;
            }
        };
        List<User> userList = template.query(sql, param, userRowMapper);
        return userList;
    }
}
