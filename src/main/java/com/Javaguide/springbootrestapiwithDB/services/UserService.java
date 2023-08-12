package com.Javaguide.springbootrestapiwithDB.services;

import com.Javaguide.springbootrestapiwithDB.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    boolean existsByCustomId(String customId);
    List<User> getAllUsers();
    Optional<User> getById(String id);

    Optional<User> updateById(User user,String ID);
    boolean deleteById(String id);
}
