package com.company.controllers;

import com.company.models.User;
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
        User user1= details.getUser();
        model.addAttribute("user", user);
        model.addAttribute("listFriends", user1.getFriends());
        model.addAttribute("listFollowers", user1.getFollowers());
        model.addAttribute("listFollowing", user1.getFollowing());
        return "profile";

    }
}