package com.bean;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

// bean validation
public class User implements Serializable {
    private static final long serialVersionUID = 3468958140956309607L;

    @NotNull
    private Long id;
    private String loginName;//用户名
    private String phone;//登录手机号
    private String password;//登录密码
    private Long salt;//密码随机干扰因子

    private String name;
    private String nick;
    private Integer sex;
    private String headUrl;//用户头像
    private String idCard;
    @Size(min = 0, max = 200, message = "年龄必须在{min} 和 {max} 之间")
    private Integer age;
    private String address;
    private String token;

    private Integer crteUserId;
    private Date crteTime;
    private Integer updtUserId;
    private Date updtTime;
    private Date lastLoginTime;

    public User() {
        super();
    }

    public User(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    // ...... get set

}
