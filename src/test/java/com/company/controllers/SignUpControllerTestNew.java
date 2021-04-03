package com.company.controllers;

import com.company.forms.UserForm;
import com.company.models.Role;
import com.company.models.State;
import com.company.models.User;
import com.company.repositories.UsersRepository;
import com.company.services.SignUpService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SignUpControllerTestNew {
    @MockBean
    private SignUpService service;
    @MockBean
    private UsersRepository usersRepository;
    @Test
    void signUp() {
        User user = User.builder()
                .firstName("test")
                .lastName("test")
                .hashPassword("test")
                .login("test")
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();

        usersRepository.save(user);
        assertTrue(usersRepository.findOneByLogin("test").isPresent());
    }
}