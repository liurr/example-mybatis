package com.t2t.examples.dao;

import com.t2t.examples.model.User;

/**
 * 最简单的调用方法
 */
public interface UserMapper {

    public User get(int id);

    public int insert(User user);

    public int modify(User user);

    public int del(User user);

}