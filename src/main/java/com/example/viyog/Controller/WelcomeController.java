package com.example.viyog.Controller;

import com.example.viyog.Dto.AuthRequest;
import com.example.viyog.Dto.UserDto;
import com.example.viyog.Service.UserService;
import com.example.viyog.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/auth")
public class WelcomeController {


    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;


    @GetMapping("/hello")
    public String welcome() {
        return "Welcome to javatechie !!";
    }


    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        System.out.println(userDto.toString());

        try {
            UserDto newUserDto = userService.createUser(userDto);
            return new ResponseEntity<>(newUserDto, HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            // Handle the case where user creation failed
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }


}
