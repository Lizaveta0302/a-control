package com.controlapp.acontrol.service;

import com.controlapp.acontrol.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getUser(long id);

    List<User> getAllUser();

    User createUser(long id, String name);

    void deleteUser(long id);

    User updateUser(long id, String name);
}
