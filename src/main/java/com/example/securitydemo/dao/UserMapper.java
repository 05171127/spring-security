package com.example.securitydemo.dao;

import com.example.securitydemo.entity.User;

/**
 * @author shipp
 * @descript
 * @create 2019-04-24 16:21
 */
public interface UserMapper {
    User findByUsername(String username);

    User save(User userToAdd);
}
