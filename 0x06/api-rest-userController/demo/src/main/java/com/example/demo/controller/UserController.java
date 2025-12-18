package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.CPFException;
import com.example.demo.exception.UserIdException;
import com.example.demo.exception.UserNameException;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping("/id/{id}")
    public String findUserById(@PathVariable int id) {
        if (id > 0 && id < 100) {
            return "You have entered valid ID";
        } else {
            throw new UserIdException();
        }
    }

    @GetMapping("/username/{username}")
    public String findUserByUserName(@PathVariable String username) {
        if (username.length() > 3 && username.length() < 15) {
            return "You have entered valid USERNAME";
        } else {
            throw new UserNameException();
        }
    }

    @GetMapping("/cpf/{cpf}")
    public String findUserByCPF(@PathVariable String cpf) {
        if (cpf.length() > 3 && cpf.length() < 15) {
            return "You have entered valid CPF";
        } else {
            throw new CPFException();
        }
    }

}
