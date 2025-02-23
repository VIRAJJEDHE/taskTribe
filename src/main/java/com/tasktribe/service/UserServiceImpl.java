package com.tasktribe.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasktribe.entity.User;
import com.tasktribe.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User getUserById(Long Id) {
        return null;
    }

    @Override
    public Boolean login(User user) {
        var u = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if(!Objects.isNull(u)) {
            return true;
        }
        return false;
    }

}
