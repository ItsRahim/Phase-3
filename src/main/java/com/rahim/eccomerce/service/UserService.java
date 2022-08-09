package com.rahim.eccomerce.service;

import com.rahim.eccomerce.model.User;

import java.util.Collection;

public interface UserService {
    User create(User user);
    User get(Long id);
    User updateEmail(Long id, String email);
    Boolean delete(Long id);
    Collection<User> list(int limit);
}
