package com.controlapp.acontrol.service;

import com.controlapp.acontrol.domain.User;
import com.controlapp.acontrol.exception.UserNotFoundException;
import com.controlapp.acontrol.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getUser(long id) {

        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new UserNotFoundException("User with id " + id + " is not found", "id");
        }

        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User createUser(long id, String name) {

        Optional<User> userFromDB = userRepository.findById(id);

        if (userFromDB.isPresent() && userFromDB.get().getName().equals(name)) {
            throw new UserNotFoundException("User with name " + name + " already exists", name);
        }

        User user = new User(id, name);

        return userRepository.insert(user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        userRepository.findById(id).ifPresentOrElse(user -> userRepository.delete(user),
                () -> {
                    throw new UserNotFoundException("User with id " + id + " is not found.", id + "");
                });
    }

    @Override
    @Transactional
    public User updateUser(long id, String name) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> {
                            throw new UserNotFoundException("User with id " + id + " is not found.", id + "");
                        }
                );

        user.setName(name);
        userRepository.save(user);

        return user;
    }
}
