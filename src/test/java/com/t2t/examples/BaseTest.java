package com.t2t.examples;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Administrator on 2015/10/19.
 */
public class BaseTest {
    Long st = 0L;
    Long et = 0L;

    @Before
    public void before() {
        System.out.println("方法开始:");
        st = System.currentTimeMillis();
    }

    @After
    public void after() {
        et = System.currentTimeMillis();
        System.out.println("耗时：" + (et - st) + "毫秒\n");
    }

    public static String RESOURCE = "mybatis.xml";

    public static SqlSession getSqlSession() throws IOException {
        SqlSessionFactory sessionFactory = getFactory();
        SqlSession session = sessionFactory.openSession();
        return session;
    }

    public static SqlSessionFactory getFactory() throws IOException {
        Reader reader = Resources.getResourceAsReader(RESOURCE);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        return sessionFactory;
    }
}
