package com.rahim.eccomerce.service.implementation;

import com.rahim.eccomerce.model.Customer;
import com.rahim.eccomerce.repository.CustomerRepo;
import com.rahim.eccomerce.service.CustomerService;
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
public class CustomerServiceImplementation implements CustomerService {
    private final CustomerRepo customerRepo;

    @Override
    public Customer create(Customer item) {
        return customerRepo.save(item);
    }

    @Override
    public Customer get(Long id) {
        return customerRepo.findById(id).get();
    }

    @Override
    public Customer updateEmail(Long id, String email) {
        Customer customer = customerRepo.findById(id).get();
        customer.setEmail(email);
        return customerRepo.save(customer);
    }

    @Override
    public Boolean delete(Long id) {
        customerRepo.deleteById(id);
        return TRUE;
    }

    @Override
    public Collection<Customer> list(int limit) {
        return customerRepo.findAll(PageRequest.of(0, limit)).toList();
    }
}
