package com.rahim.eccomerce.configuration;

import com.rahim.eccomerce.model.Customer;
import com.rahim.eccomerce.model.Item;
import com.rahim.eccomerce.repository.ItemRepo;
import com.rahim.eccomerce.repository.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static com.rahim.eccomerce.enumeration.Gender.MALE;
import static com.rahim.eccomerce.enumeration.Stock.AVAILABLE_STOCK;

@Configuration
public class DataConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(ItemRepo itemRepo, CustomerRepo customerRepo) {
        return args -> {
            Item nike270 = new Item(
                    null,
                    "Nike 270",
                    "Black Nike Shoes",
                    "Shoe",
                    270.00,
                    AVAILABLE_STOCK
            );
            Item adidas = new Item(
                    null,
                    "Adidas Ultraboost",
                    "Running Shoes",
                    "Shoe",
                    180,
                    AVAILABLE_STOCK
            );
            Customer rahim = new Customer(
                    null,
                    "Rahim Ahmed",
                    "rahim1605@gmail.com",
                    LocalDate.of(2001, Month.AUGUST, 17),
                    MALE
            );
            itemRepo.saveAll(List.of(nike270, adidas));
            customerRepo.saveAll(List.of(rahim));
        };
    }
}
