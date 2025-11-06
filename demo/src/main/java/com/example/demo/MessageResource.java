package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageResource {

    @GetMapping("/simpleMessageWelcome")
    public String simpleMessageWelcome() {
        return "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!";
    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String user,
                        @RequestParam(required = false) String password) {

        if (user == null || user.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            return "USUÁRIO E SENHA NÃO INFORMADOS";
        }

        if (user.trim().length() > 15 || password.trim().length() > 15) {
            return "USUÁRIO E SENHA INVÁLIDOS";
        }

        return "LOGIN EFETUADO COM SUCESSO !!!";
    }
}