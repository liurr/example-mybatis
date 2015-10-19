package com.t2t.examples.service;

import com.t2t.examples.model.User;

/**
 * 最简单的调用方法
 */
public interface UserService {

    public User get();

    public int add(User user);

    public int modify(User user);

    public int del(User user);

}