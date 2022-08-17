package com.rahim.eccomerce.service;

import com.rahim.eccomerce.enumeration.Stock;
import com.rahim.eccomerce.model.Item;

import java.util.Collection;

public interface ItemService {
    Item save(Item item);
    Item get(Long id);
    Item update(Long id, String name, String description,
                       String category, Double price, Stock stock);
    Boolean delete(Long id);
    Collection<Item> list(int limit);
    Collection<Item> getByCategory(String category);
}
