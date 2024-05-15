package dev.ansh.EcomUserAuthService.controller;

import dev.ansh.EcomUserAuthService.dto.LoginRequestDTO;
import dev.ansh.EcomUserAuthService.dto.SignupRequestDTO;
import dev.ansh.EcomUserAuthService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok(userService.login(loginRequestDTO));
    }

    @GetMapping("/logout")
    public ResponseEntity logout(@RequestHeader("Authorisation") String token){
        return ResponseEntity.ok(userService.logout(token));
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody SignupRequestDTO signupRequestDTO) throws RoleNotFoundException {
        return ResponseEntity.ok(userService.signup(signupRequestDTO));
    }

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validate(@RequestHeader("Authorisation") String token){
        return ResponseEntity.ok(userService.validateToken(token));
    }


}
