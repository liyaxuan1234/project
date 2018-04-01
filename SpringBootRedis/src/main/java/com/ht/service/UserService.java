package com.ht.service;

import com.ht.pojo.User;

import java.util.List;

public interface UserService {
    List<User> getUserAll();
    User selectUser(Integer id);
    void delete(Integer id);
    void update(User user);
    void addUser(User user);
    Long count();
}
