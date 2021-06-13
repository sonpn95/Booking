package com.example.room.controllers;

import com.example.room.models.request.JwtRequest;
import com.example.room.models.response.jwtResponse;
import com.example.room.services.JwtService;
import com.example.room.services.MyUserDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class LoginController {
    private final AuthenticationManager authenticationManager;

    private final UserDetailsService myUserDetailsService;

    private final JwtService jwtService;

    public LoginController(AuthenticationManager authenticationManager, MyUserDetailsService myUserDetailsService, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.myUserDetailsService = myUserDetailsService;
        this.jwtService = jwtService;
    }

    @GetMapping({"/hello"})
    public String index(){
        return "Hello";
    }
    @GetMapping("/hi")
    public String in(){
        return "haha";
    }

    @PostMapping("/authen")
    public ResponseEntity<?> createAuthentication(@RequestBody JwtRequest jwtRequest) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));
        } catch (BadCredentialsException e){
            throw new Exception("Username or password not found",e);
        }

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(jwtRequest.getEmail());
        final String jwt = jwtService.generateToken(userDetails);
        return ResponseEntity.ok(new jwtResponse(jwt));

    }
}
