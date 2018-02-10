package com.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;



public class User implements Serializable {
    private static final long serialVersionUID = 3468958140956309607L;

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

    public User(String loginName, String phone, String password, Long salt) {
        this.loginName = loginName;
        this.phone = phone;
        this.password = password;
        this.salt = salt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getSalt() {
        return salt;
    }

    public void setSalt(Long salt) {
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    @Value("#{dbParam.user}")
    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getCrteUserId() {
        return crteUserId;
    }

    public void setCrteUserId(Integer crteUserId) {
        this.crteUserId = crteUserId;
    }

    public Date getCrteTime() {
        return crteTime;
    }

    public void setCrteTime(Date crteTime) {
        this.crteTime = crteTime;
    }

    public Integer getUpdtUserId() {
        return updtUserId;
    }

    public void setUpdtUserId(Integer updtUserId) {
        this.updtUserId = updtUserId;
    }

    public Date getUpdtTime() {
        return updtTime;
    }

    public void setUpdtTime(Date updtTime) {
        this.updtTime = updtTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
