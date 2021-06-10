package com.example.room.controllers;

import com.example.room.models.entities.Account;
import com.example.room.models.response.jwtresponse;
import com.example.room.services.JwtService;
import com.example.room.services.MyUserDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    private final AuthenticationManager authenticationManager;

    private final MyUserDetailsService myUserDetailsService;

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

    @RequestMapping(value="/authen", method= RequestMethod.POST)
    public ResponseEntity<?> createAuthentication(@RequestBody Account account) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getEmail(), account.getPassword()));
        }catch(BadCredentialsException e){
            throw new Exception("incorrect",e);
        }

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(account.getEmail());
        final String jwt = jwtService.generateToken(userDetails);
        return ResponseEntity.ok(new jwtresponse(jwt));

    }
}
