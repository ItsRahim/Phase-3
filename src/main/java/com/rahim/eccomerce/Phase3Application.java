package com.rahim.eccomerce;

import com.rahim.eccomerce.model.Item;
import com.rahim.eccomerce.repository.ItemRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.rahim.eccomerce.enumeration.Stock.AVAILABLE_STOCK;

@SpringBootApplication
public class Phase3Application {

    public static void main(String[] args) {
        SpringApplication.run(Phase3Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ItemRepo itemRepo) {
        return args -> itemRepo.save(new Item(
                null,
                "Nike 270",
                "Black Nike Shoes",
                "Black",
                270.00,
                AVAILABLE_STOCK));
    }
}
