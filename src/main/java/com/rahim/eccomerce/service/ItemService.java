package com.rahim.eccomerce.service;

import com.rahim.eccomerce.model.Item;

import java.util.Collection;

public interface ItemService {
    Item create(Item item);
    Item get(Long id);
    Item update(Item item);
    Boolean delete(Long id);
    Collection<Item> list(int limit);
}
