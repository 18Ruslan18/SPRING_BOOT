package com.company.controllers;


import com.company.models.User;
import com.company.repositories.UsersRepository;
import com.company.security.details.UserDetailsImpl;
import com.company.transfer.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import static com.company.transfer.UserDto.from;
@Controller
public class FindFriendsController {
    @Autowired
    private UsersRepository usersRepository;
    private String loginFriend;
    @GetMapping("/findFriends")
    public String getProfilePage(@RequestParam(required = false, defaultValue = "") String filter, ModelMap model, @AuthenticationPrincipal Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        if (filter !=null && !filter.isEmpty()){
            Optional<User> user = usersRepository.findOneByLogin(filter);
            if (!user.isPresent()) { model.addAttribute("error", true);  return "findFriends"; }
            else {
                model.addAttribute("flag", true);
                model.addAttribute("user", user.get());
                loginFriend = user.get().getLogin();
            }
        }


        return "findFriends";

    }
    @PostMapping("/findFriends")
    public String add(@RequestParam(required = false, defaultValue = "") String filter, @AuthenticationPrincipal Authentication authentication){


            UserDetailsImpl details =  (UserDetailsImpl) authentication.getPrincipal();
            User currentUser= details.getUser();
            ///currentUser.addFriend(usersRepository.findOneByLogin(loginFriend).get());
             currentUser.addFriend(usersRepository.findOneByLogin("user").get());
            usersRepository.save(currentUser);

        return "findFriends";
    }
}

