package com.rahim.eccomerce.repository;

import com.rahim.eccomerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long>{
}
