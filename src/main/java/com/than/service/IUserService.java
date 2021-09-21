package com.than.service;

import com.than.model.Music;
import com.than.model.User;

import java.util.Optional;

public interface IUserService {
    Iterable<User> findAll();
    Optional<User> findById(Long id);
    void save(User user);
}
