package com.bean;

/**
 * Created by chenfengfu on 2018/2/10.
 */
public class FactoryBean {

    public FactoryBean() {
        System.out.println("工厂实例化");
    }

    public User initUser(){
        return new User("phone", "pwd");
    }

    public static User staticInitUser(){
        return new User();
    }
}
