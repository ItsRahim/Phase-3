package com.rahim.eccomerce.repository;

import com.rahim.eccomerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long>{
}
