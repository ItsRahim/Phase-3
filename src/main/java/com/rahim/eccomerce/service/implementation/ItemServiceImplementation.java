package com.rahim.eccomerce.service.implementation;

import com.rahim.eccomerce.enumeration.Stock;
import com.rahim.eccomerce.model.Item;
import com.rahim.eccomerce.repository.ItemRepo;
import com.rahim.eccomerce.service.ItemService;
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
public class ItemServiceImplementation implements ItemService {

    private final ItemRepo itemRepo;

    public Item save(Item item) {
        return itemRepo.save(item);
    }

    public Item get(Long id) {
        return itemRepo.findById(id).get();
    }

    public Item update(Long id, String name, String description,
                            String category, Double price, Stock stock) {
        Item item = itemRepo.findById(id).get();
        item.setName(name);
        item.setDescription(description);
        item.setCategory(category);
        item.setPrice(price);
        item.setStock(stock);
        return itemRepo.save(item);
    }

    public Boolean delete(Long id) {
        itemRepo.deleteById(id);
        return TRUE;
    }

    public Collection<Item> list(int limit) {
        return itemRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    public Collection<Item> getByCategory(String category) {
        return itemRepo.findByCategory(category);
    }
}
