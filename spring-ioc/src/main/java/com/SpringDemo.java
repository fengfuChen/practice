package com;

import com.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringDemo {

//    Bena bean = (Bean) context.getBean("beanId");

    @Test
    public void iocTest() {
        // 构造器实例化
        // 静态工厂方法实例化
        // 实例工厂方法实例化
        ApplicationContext context = new ClassPathXmlApplicationContext("springIocConfig.xml"); // 加载classpath 下的配置文件实例化
//        ApplicationContext context =new FileSystemXmlApplicationContext("F:\\workSpace\\fengfuChen\\practice\\spring-ioc\\src\\main\\resources\\applicationContext.xml"); // 加载文件系统中的配
        User user1 = (User) context.getBean("user1");
        User user2 = (User) context.getBean("user2");
        User user3 = (User) context.getBean("user3");
        System.out.println(".....");
    }


}
