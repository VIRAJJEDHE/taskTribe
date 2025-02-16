package com.tasktribe.service;

import java.util.List;

import com.tasktribe.entity.User;

public interface UserService {
    User registerUser(User user);

    List<User> getUsers();

    User getUserById(Long Id);
}
