package com.example.securitydemo.service;

import com.example.securitydemo.entity.User;

/**
 * @author shipp
 * @descript
 * @create 2019-04-24 16:18
 */
public interface AuthService {
    User register( User userToAdd );
    String login( String username, String password );
}
