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
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void test_query() throws IOException {
        SqlSession session = getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setName("张三丰");
        user.setAge(27);
        List<User> list = userMapper.query(user);
        println(list);
    }

    public void println(User... users) {
        println(Arrays.asList(users));
    }

    public void println(List<User> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + "," + list.get(i).getSex() + "," + list.get(i).getAge());
        }
    }

    @Test
    public void test_insert() throws IOException {
        SqlSession session = getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setName("霓凰郡主");
        user.setAge(26);
        System.out.println(userMapper.insert(user));
    }

    @Test
    public void test_insert2() throws IOException {
        SqlSession session = getSqlSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = new User();
            user.setName("霓凰郡主");
            user.setAge(26);


            System.out.println(userMapper.insert(user));
            session.commit();
        } catch (Exception e) {
            session.rollback();
        }
    }


    @Test
    public void dynamicIfTest() {
        SqlSession session = getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = new User();
        user.setName("张三丰");
        user.setSex("男");
        user.setAge(27);
        List list = userMapper.dynamicIfTest(user);
        println(list);
    }

    @Test
    public void dynamicChooseTest() {

    }

    @Test
    public void dynamicWhereTest() {
    }

    @Test
    public void dynamicTrimTest() {
    }

    @Test
    public void dynamicSetTest1() {
    }

    @Test
    public void dynamicSetTest2() {
    }
}