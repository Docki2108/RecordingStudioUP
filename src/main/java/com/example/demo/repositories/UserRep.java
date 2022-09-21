package com.example.demo.repositories;

import com.example.demo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRep extends CrudRepository<User, Long> {
    User findByLogin(String login);
}
