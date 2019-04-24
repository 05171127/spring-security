package com.example.securitydemo.dao;

import com.example.securitydemo.entity.Role;

/**
 * @author shipp
 * @descript
 * @create 2019-04-24 18:38
 */
public interface RoleMapper {
    public Role byUserId(Integer userId);
}
