package test;

import bean.User;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;



public class DemoTest {

    //定义 SqlSession
    SqlSession session = null;

    @Before
    public void init() {
        //定义mybatis全局配置文件
        String resource = "config/mybatis-config.xml";
//     props.load(DBUtils.class.getClassLoader().getResourceAsStream("./com/jdbc/db.properties")); // 默认是从ClassPath根下获取文件
        InputStream inputStream = DemoTest.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //根据 sqlSessionFactory 产生 session
        session = sessionFactory.openSession();
    }

    //根据id查询user表数据
    @Test
    public void testSelectUserById() {
        /*这个字符串由 userMapper.xml 文件中 两个部分构成
            <mapper namespace="com.ys.po.userMapper"> 的 namespace 的值
            <select id="selectUserById" > id 值*/
//        String statement = "com.ys.po.userMapper.selectUserById"; namespace + sqlId
        String statement = "mapper.UserMapper.selectUserById"; // namespace + sqlId
        User user = session.selectOne(statement, 20009);
        System.out.println(user);

        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.addUser(new User());
        session.commit();
        session.close();

    }
}
