package com.tasktribe.service;

import java.util.Objects;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.tasktribe.entity.CustomUserDetails;
import com.tasktribe.entity.User;
import com.tasktribe.repository.UserRepository;

@Component
public class CustomUserDetailService implements UserDetailsService {

    private UserRepository userRepository;
    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByEmail(username);
       if(Objects.isNull(user)) {
           System.out.println("User not found");
           throw new UsernameNotFoundException("User not found");
       }
         return new CustomUserDetails(user);
    }
    
}
