package com.company.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UsersController {
@GetMapping("/users")
public String getUsersPage(ModelMap model){
model.addAttribute("userName","Ruslan");
return "users";
}
}
