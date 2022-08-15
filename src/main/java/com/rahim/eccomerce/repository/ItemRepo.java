package com.rahim.eccomerce.repository;

import com.rahim.eccomerce.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {
    Collection<Item> findByCategory(String category);
}
