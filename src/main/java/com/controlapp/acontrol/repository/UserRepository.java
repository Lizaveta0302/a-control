package com.controlapp.acontrol.repository;

import com.controlapp.acontrol.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
}
