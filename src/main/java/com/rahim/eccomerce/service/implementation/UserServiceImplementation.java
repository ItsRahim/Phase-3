package com.rahim.eccomerce.service.implementation;

import com.rahim.eccomerce.model.User;
import com.rahim.eccomerce.repository.UserRepo;
import com.rahim.eccomerce.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

import static java.lang.Boolean.TRUE;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {
    private final UserRepo userRepo;

    @Override
    public User create(User item) {
        return userRepo.save(item);
    }

    @Override
    public User get(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public User updateEmail(Long id, String email) {
        User user = userRepo.findById(id).get();
        user.setEmail(email);
        return userRepo.save(user);
    }

    @Override
    public Boolean delete(Long id) {
        userRepo.deleteById(id);
        return TRUE;
    }

    @Override
    public Collection<User> list(int limit) {
        return userRepo.findAll(PageRequest.of(0, limit)).toList();
    }
}
