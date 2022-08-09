package com.rahim.eccomerce.service;

import com.rahim.eccomerce.model.Customer;

import java.util.Collection;

public interface CustomerService {
    Customer create(Customer customer);
    Customer get(Long id);
    Customer updateEmail(Long id, String email);
    Boolean delete(Long id);
    Collection<Customer> list(int limit);
}
