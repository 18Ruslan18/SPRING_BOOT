package com.company.controllers;

import com.company.forms.UserForm;
import com.company.models.Role;
import com.company.models.State;
import com.company.models.User;
import com.company.repositories.UsersRepository;
import com.company.security.details.UserDetailsImpl;
import com.company.services.SignUpService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Controller
public class SignUpController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SignUpService service;
    @Autowired
    private UsersRepository usersRepository;
    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "signUp";
    }
    @PostMapping("/signUp")
    public String signUp(UserForm userForm, ModelMap model, @RequestParam("login") String login,
                         @RequestParam("password") String password,@RequestParam("passwordCheck") String passwordCheck,
                         @RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName) {

        Optional<User> user = usersRepository.findOneByLogin(login);
        if (user.isPresent()) { model.addAttribute("error", true);  return "signUp"; }
        if (!password.equals(passwordCheck)) { model.addAttribute("error1", true);  return "signUp"; }
        if (login.equals("") || firstName.equals("") || lastName.equals("") || password.equals("")) { model.addAttribute("error2", true);  return "signUp"; }
        service.signUp(userForm);
        return "redirect:/login";
    }
}
