package com.rahim.eccomerce.resource;

import com.rahim.eccomerce.enumeration.Gender;
import com.rahim.eccomerce.model.Customer;
import com.rahim.eccomerce.service.implementation.CustomerServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerResource {

    private final CustomerServiceImplementation customerService;

    @GetMapping("/list")
    public String getItems(Model model) {
        model.addAttribute("titlePage", "All Customers");
        model.addAttribute("customerData", customerService.list(20));
        return "get-customer";
    }

    @GetMapping("/get/{id}")
    public String getById(Model model, @PathVariable Long id) {
        model.addAttribute("titlePage", "Customer by ID");
        model.addAttribute("customerData", customerService.get(id));
        return "get-customer";
    }

    @PostMapping("/add-customer")
    public String getItemForm(@RequestParam String name,
                              @RequestParam String email,
                              @RequestParam String dob,
                              @RequestParam Gender gender) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        LocalDate localDate = LocalDate.parse(dob, formatter);
        Customer customer = new Customer(null, name, email, localDate, gender);
        customerService.create(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/delete-customer/{id}")
    public String deleteItem(@PathVariable Long id) {
        customerService.delete(id);
        return "redirect:/customer/list";
    }

    @PostMapping("/update-customer")
    public String updateItemForm(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam String dob,
                                 @RequestParam Gender gender) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dob, formatter);

        Customer customer = customerService.get(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setDob(localDate);
        customer.setGender(gender);
        customerService.create(customer);
        return "redirect:/customer/list";
    }
}
