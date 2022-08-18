package com.rahim.eccomerce.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping()
@RequiredArgsConstructor
public class LoginResource {

    @PostMapping("/login")
    public String checkLogin(@RequestParam String email,
                             @RequestParam String password) {
        if (email.equals("rahim.ahmed@mindweaver.co.uk") & password.equals("Password1")) {
            return "redirect:/item/list";
        }
        return "index";
    }
}
