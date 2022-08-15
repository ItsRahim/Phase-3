package com.rahim.eccomerce.service;

import com.rahim.eccomerce.enumeration.Stock;
import com.rahim.eccomerce.model.Item;

import java.util.Collection;

public interface ItemService {
    Item create(Item item);
    Item get(Long id);
    Item updatePrice(Long id, double price);
    Item updateStock(Long id, Stock stock);
    Boolean delete(Long id);
    Collection<Item> list(int limit);
    Collection<Item> getByCategory(String category);
}
