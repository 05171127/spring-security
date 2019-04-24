package com.example.securitydemo.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author shipp
 * @descript
 * @create 2019-04-24 15:08
 */
@Setter
@Getter
public class Role {
    private Integer id;
    private String roleName;
    private Integer userId;
}
