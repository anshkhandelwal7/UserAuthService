package dev.ansh.EcomUserAuthService.controller;

import dev.ansh.EcomUserAuthService.dto.LoginRequestDTO;
import dev.ansh.EcomUserAuthService.dto.SignupRequestDTO;
import dev.ansh.EcomUserAuthService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO loginRequestDTO){
        return null;
    }

    @GetMapping("/logout")
    public ResponseEntity logout(){
        return null;
    }

    @PostMapping("/signup")
    public ResponseEntity login(@RequestBody SignupRequestDTO signupRequestDTO){
        return null;
    }

    @GetMapping("/validate")
    public ResponseEntity validate(){
        return null;
    }


}
