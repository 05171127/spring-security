package com.example.securitydemo.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author shipp
 * @descript
 * @create 2019-04-24 13:05
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
