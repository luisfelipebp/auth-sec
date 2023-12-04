package com.luisfelipebp.auth.services;

import com.luisfelipebp.model.DTO.LoginDTO;
import com.luisfelipebp.model.DTO.RegisterDTO;
import com.luisfelipebp.model.User;
import com.luisfelipebp.model.DTO.UserDTO;
import com.luisfelipebp.repository.UserRepository;
import com.luisfelipebp.security.TokenService;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private UserRepository userRepository;

    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByLogin(login);
    }

    public ResponseEntity<Object> login(@RequestBody UserDTO data){
        authenticationManager = context.getBean(AuthenticationManager.class);

        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginDTO(token));
    }


    public ResponseEntity<Object> register(@RequestBody RegisterDTO registerDto){
        if (this.userRepository.findByLogin(registerDto.login()) != null ) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDto.password());

        User newUser = new User(registerDto.login(), encryptedPassword, registerDto.email(), registerDto.role());
        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }

}
