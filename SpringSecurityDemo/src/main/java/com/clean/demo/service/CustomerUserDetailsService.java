package com.clean.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by tonghui on 2015/9/24.
 */
public class CustomerUserDetailsService implements UserDetailsService{
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
