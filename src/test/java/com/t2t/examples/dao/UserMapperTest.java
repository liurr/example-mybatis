package com.t2t.examples.dao;

import com.t2t.examples.BaseTest;
import com.t2t.examples.dao.UserMapper;
import com.t2t.examples.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

import org.junit.*;

/**
 * UserMappe测试类
 */
public class UserMapperTest extends BaseTest {

    @Test
    public void test_get() throws IOException {
        SqlSession session = getSqlSession();

        System.out.println("1.1 执行查询返回一个唯一user对象的sql");
        User user = session.selectOne(UserMapper.class.getName() + ".get", 1);
        System.out.println(user.getName() + "," + user.getAge());

        System.out.println("1.2 执行查询返回一个唯一user对象的sql");
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user1 = userMapper.get(1);
        System.out.println(user1.getName() + "," + user1.getAge());
    }


}