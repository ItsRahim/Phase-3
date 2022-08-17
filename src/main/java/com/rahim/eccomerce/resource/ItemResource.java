package com.rahim.eccomerce.resource;

import com.rahim.eccomerce.enumeration.Stock;
import com.rahim.eccomerce.model.Item;
import com.rahim.eccomerce.service.implementation.ItemServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String getById(Model model, @PathVariable Long id) {
        model.addAttribute("titlePage", "Item By ID");
        model.addAttribute("itemData", itemService.get(id));
        return "get-items";
    }

    @GetMapping("/category/{category}")
    public String getItem(Model model, @PathVariable String category) {
        model.addAttribute("titlePage", "Item By " + category);
        model.addAttribute("itemData", itemService.getByCategory(category));
        return "get-items";
    }

    @GetMapping("/add-item")
    public String getItemForm(Model model) {
        model.addAttribute("item", new Item());
        return "add-item";
    }

    @PostMapping("/save-item")
    public String postItemForm(Item item, Model model) {
        itemService.save(item);

        model.addAttribute("titlePage", "All Items");
        model.addAttribute("itemData", itemService.list(20));
        return "redirect:/item/list";
    }

    @GetMapping("/delete-item/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.delete(id);
        return "redirect:/item/list";
    }

    @PostMapping("/update-item")
    public String updateItemForm(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String desc,
                                 @RequestParam String category,
                                 @RequestParam double price,
                                 @RequestParam Stock stock) {
        System.out.println("Hello");
        Item item = itemService.get(id);
        item.setName(name);
        item.setDescription(desc);
        item.setCategory(category);
        item.setPrice(price);
        item.setStock(stock);
        itemService.save(item);
        return "redirect:/item/list";
    }
}
