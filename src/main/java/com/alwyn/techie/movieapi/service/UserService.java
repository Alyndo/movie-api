package com.alwyn.techie.movieapi.service;

import com.alwyn.techie.movieapi.model.User;

public interface UserService {
    void registerUser(User user);
    User findByUsername(String username);

}
