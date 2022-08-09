package com.rahim.eccomerce.configuration;

import com.rahim.eccomerce.model.Item;
import com.rahim.eccomerce.model.User;
import com.rahim.eccomerce.repository.ItemRepo;
import com.rahim.eccomerce.repository.UserRepo;
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
    CommandLineRunner commandLineRunner(ItemRepo itemRepo, UserRepo userRepo) {
        return args -> {
            Item nike270 = new Item(
                    null,
                    "Nike 270",
                    "Black Nike Shoes",
                    "Black",
                    270.00,
                    AVAILABLE_STOCK
            );
            User rahim = new User(
                    null,
                    "Rahim Ahmed",
                    "rahim1605@gmail.com",
                    LocalDate.of(2001, Month.AUGUST, 17),
                    MALE
            );
            itemRepo.saveAll(List.of(nike270));
            userRepo.saveAll(List.of(rahim));
        };
    }
}
