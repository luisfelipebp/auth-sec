package com.luisfelipebp.auth.controller;

import com.luisfelipebp.model.DTO.RegisterDTO;
import com.luisfelipebp.model.DTO.UserDTO;
import com.luisfelipebp.auth.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {


    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid UserDTO user){
        return authService.login(user);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        return authService.register(data);
    }

}
