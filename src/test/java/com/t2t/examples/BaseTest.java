package com.t2t.examples;

import com.google.gson.Gson;
import com.t2t.examples.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2015/10/19.
 */
public class BaseTest {
    Long st = 0L;
    Long et = 0L;
    public String RESOURCE = "mybatis.xml";
    public SqlSession session = null;

    @Before
    public void before() {
        System.out.println("方法开始");
        st = System.currentTimeMillis();
        session = getSqlSession();
    }

    @After
    public void after() {
        et = System.currentTimeMillis();
        System.out.println("耗时：" + (et - st) + "毫秒\n");
        session.close();
    }


    public SqlSession getSqlSession() {
        SqlSessionFactory sessionFactory = null;
        try {
            sessionFactory = getFactory();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSession session = sessionFactory.openSession();
        return session;
    }

    public SqlSessionFactory getFactory() throws IOException {
        Reader reader = Resources.getResourceAsReader(RESOURCE);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        return sessionFactory;
    }

    public void println(Object... beans) {
        println(Arrays.asList(beans));
    }

    public void println(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(new Gson().toJson(list));
        }
    }
}
