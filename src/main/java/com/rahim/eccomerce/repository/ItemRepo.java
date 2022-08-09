package com.rahim.eccomerce.repository;

import com.rahim.eccomerce.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Long> {
}
