package com.cognizant.spring_learn.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) {
        if ("admin".equals(username)) {
            return new User("admin", "{noop}password", Collections.singleton(() -> "ROLE_USER"));
        }
        throw new UsernameNotFoundException("User not found");
    }
}
