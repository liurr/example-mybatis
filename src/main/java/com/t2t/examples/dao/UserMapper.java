package com.t2t.examples.dao;

import com.t2t.examples.model.User;

import java.util.List;

/**
 * 最简单的调用方法
 */
public interface UserMapper {

    public User get(int id);

    public List<User> query(User user);

    public int insert(User user);

    public int modify(User user);

    public int del(User user);


    //*******************MyBatis的动态SQL详解******************
    //1. if就是简单的条件判断，利用if语句我们可以实现某些简单的条件选择。
    public List<User> dynamicIfTest(User user);

    //2. choose元素的作用就相当于JAVA中的switch语句，基本上跟JSTL中的choose的作用和用法是一样的，通常都是与when和otherwise搭配的。
    public List<User> dynamicChooseTest(User user);

    //3. where语句的作用主要是简化SQL语句中where中的条件判断的。
    public List<User> dynamicWhereTest(User user);

    //4. trim元素的主要功能是可以在自己包含的内容前加上某些前缀，也可以在其后加上某些后缀，与之对应的属性是prefix和suffix。
    public List<User> dynamicTrimTest(User user);

    //5.1 set元素主要是用在更新操作的时候，它的主要功能和where元素是差不多的。
    public int dynamicSetTest1(User user);

    //5.1 set元素主要是用在更新操作的时候，它的主要功能和where元素是差不多的。
    public int dynamicSetTest2(User user);
}