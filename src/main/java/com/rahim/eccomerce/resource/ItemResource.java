package com.rahim.eccomerce.resource;

import com.rahim.eccomerce.enumeration.Stock;
import com.rahim.eccomerce.model.Item;
import com.rahim.eccomerce.service.implementation.ItemServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public String getItem(Model model,@PathVariable String category) {
        model.addAttribute("titlePage", "Item By " + category);
        model.addAttribute("itemData", itemService.getByCategory(category));
        return "get-items";
    }

    @GetMapping("/save")
    public String getItemForm(Model model) {
        model.addAttribute("item", new Item());
        return "add-item";
    }

    @PostMapping("/save-item")
    public String postItemForm(@ModelAttribute("newItem") Item item, Model model) {
        try{
            itemService.save(item);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        model.addAttribute("titlePage", "All Items");
        model.addAttribute("itemData", itemService.list(20));
        return "get-items";
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
