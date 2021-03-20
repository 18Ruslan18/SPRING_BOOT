package com.company.controllers;

import com.company.security.details.UserDetailsImpl;
import com.company.transfer.UserDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import static com.company.transfer.UserDto.from;

@Controller
public class ProfileController {
    @GetMapping("/")
    public String getProfilePage(ModelMap model, @AuthenticationPrincipal Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }

        UserDetailsImpl details =  (UserDetailsImpl) authentication.getPrincipal();
        UserDto user = from(details.getUser());
        model.addAttribute("user", user);
        return "profile";

    }
}