package com.t2t.examples.dao;

import com.t2t.examples.BaseTest;
import com.t2t.examples.model.User;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.*;

import org.junit.*;

/**
 * UserMappe测试类
 */
public class UserMapperTest extends BaseTest {

    /**
     * 1. if就是简单的条件判断，利用if语句我们可以实现某些简单的条件选择。
     */
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

    /**
     * 2. choose元素的作用就相当于JAVA中的switch语句，基本上跟JSTL中的choose的作用和用法是一样的，
     * 通常都是与when和otherwise搭配的。
     */
    @Test
    public void dynamicChooseTest() {
        SqlSession session = getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = new User();
        user.setName("张三丰");
        user.setSex("男");
        List list = userMapper.dynamicChooseTest(user);
        println(list);
    }

    /**
     * 3. where语句的作用主要是简化SQL语句中where中的条件判断的。
     */
    @Test
    public void dynamicWhereTest() {
        SqlSession session = getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = new User();
        user.setName("张三丰");
        user.setSex("男");
        List list = userMapper.dynamicWhereTest(user);
        println(list);
    }

    /**
     * 4. trim元素的主要功能是可以在自己包含的内容前加上某些前缀，也可以在其后加上某些后缀，与之对应的属性是prefix和suffix。
     */
    @Test
    public void dynamicTrimTest() {
        SqlSession session = getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = new User();
        user.setName("张三丰");
        user.setSex("男");
        List list = userMapper.dynamicTrimTest(user);
        println(list);
    }

    /**
     * 5.1 set元素主要是用在更新操作的时候，它的主要功能和where元素是差不多的。
     */
    @Test
    public void dynamicSetTest1() {
        SqlSession session = getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = new User();
        user.setName("霓凰郡主");
        user.setAge(26);
        user.setSex("女");
        user.setId(3);
        System.out.println(userMapper.dynamicSetTest1(user));
        session.commit();
        queryTest();
    }

    /**
     * 6.1 单参数List的类型
     */
    @Test
    public void dynamicSetTest2() {
        SqlSession session = getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = new User();
        user.setName("霓凰郡主");
        user.setAge(28);
        user.setSex("女");
        user.setId(3);
        System.out.println(userMapper.dynamicSetTest2(user));
        session.commit();
    }

    /**
     * 6.1 单参数List的类型
     */
    @Test
    public void dynamicForeach1Test() {
        SqlSession session = getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(3);
        List<User> list = userMapper.dynamicForeach1Test(ids);
        println(list);
        session.close();
    }

    /**
     * 6.2 单参数array数组的类型
     */
    @Test
    public void dynamicForeach2Test() {
        SqlSession session = getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        int[] ids = new int[]{1, 3, 6, 9};
        List<User> list = userMapper.dynamicForeach2Test(ids);
        println(list);
    }

    /**
     * 6.3 自己把参数封装成Map的类型
     */
    @Test
    public void dynamicForeach3Test() {
        UserMapper userMapper = session.getMapper(UserMapper.class);

        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ids", ids);
        params.put("name", "张三丰");
        List<User> list = userMapper.dynamicForeach3Test(params);
        println(list);
    }

    //**********************其他**********************
    //根据id查询
    @Test
    public void getTest() throws IOException {
        SqlSession session = getSqlSession();

        System.out.println("1.1 执行查询返回一个唯一user对象的sql");
        User user = session.selectOne(UserMapper.class.getName() + ".get", 1);
        System.out.println(user.getName() + "," + user.getAge());

        System.out.println("1.2 执行查询返回一个唯一user对象的sql");
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user1 = userMapper.get(1);
        System.out.println(user1.getName() + "," + user1.getAge());
    }

    //获取所有的用户
    @Test
    public void queryTest() {
        SqlSession session = getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User();
        List<User> list = userMapper.query(user);
        println(list);
    }

    //添加用户
    @Test
    public void insertTest() throws IOException {
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
}