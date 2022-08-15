package com.rahim.eccomerce.resource;

import com.rahim.eccomerce.enumeration.Stock;
import com.rahim.eccomerce.model.Item;
import com.rahim.eccomerce.service.implementation.ItemServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//TODO change to @Controller
@Controller
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemResource {

    private final ItemServiceImplementation itemService;

    @GetMapping("/list")
    public String getItems(Model model) {
        model.addAttribute("titlePage", "All Items");
        model.addAttribute("itemData", itemService.list(20));
        return "get-items";
    }

    @GetMapping("/get/{id}")
    public String getById(Model model, @RequestParam ("id") Long id) {
        return "Hello";
    }

    @GetMapping("/category/{category}")
    public String getItem(@PathVariable("category") String category) {
        //itemService.getByCategory(category)
        return "Hello";
    }

    @PostMapping("/save")
    public String saveItem(@RequestBody @Valid Item item) {
        //itemService.create(item)
        return "Save";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") Long id) {
        //itemService.delete(id)
        return "delete";
    }

    @PutMapping("/update-price/{id}/{price}")
    public String updateItemPrice(@PathVariable Long id, @PathVariable double price) {
        //itemService.updatePrice(id, price)
        return "update";
    }

    @PutMapping("/update-stock/{id}/{stock}")
    public String updateItemStock(@PathVariable Long id, @PathVariable Stock stock) {
        //itemService.updateStock(id, stock)
        return "stock";
    }
}
