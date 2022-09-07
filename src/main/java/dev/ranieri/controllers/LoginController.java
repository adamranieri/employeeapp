package dev.ranieri.controllers;

import dev.ranieri.dtos.LoginCredentials;
import dev.ranieri.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login") // use someones credentials to generate a custom JWT for them
    public String login(@RequestBody LoginCredentials loginCredentials){
        return loginService.authenticateUser(loginCredentials);
    }


}
