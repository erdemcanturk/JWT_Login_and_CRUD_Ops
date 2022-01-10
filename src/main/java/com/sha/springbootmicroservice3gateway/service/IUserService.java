package com.sha.springbootmicroservice3gateway.service;

import com.sha.springbootmicroservice3gateway.model.User;

import java.util.List;
import java.util.Optional;


public interface IUserService
{
    User saveUser(User user);

    Optional<User> findBUsername(String username);

    List<User> findAllUsers();
}
