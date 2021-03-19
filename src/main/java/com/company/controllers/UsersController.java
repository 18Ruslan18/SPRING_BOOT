package com.company.controllers;

import com.company.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UsersController {
@Autowired
private UsersRepository usersRepository;
@GetMapping("/users")
public String getUsersPage(ModelMap model){
model.addAttribute("usersFromServer",usersRepository.findAll());
return "users";
}
}
