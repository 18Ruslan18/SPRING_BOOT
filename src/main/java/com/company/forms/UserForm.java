package com.company.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
public class UserForm {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
}
