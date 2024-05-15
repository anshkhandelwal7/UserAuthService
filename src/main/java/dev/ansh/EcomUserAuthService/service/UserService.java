package dev.ansh.EcomUserAuthService.service;

import dev.ansh.EcomUserAuthService.dto.LoginRequestDTO;
import dev.ansh.EcomUserAuthService.dto.SignupRequestDTO;
import dev.ansh.EcomUserAuthService.dto.UserResponseDTO;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;

@Service
public interface UserService {
    UserResponseDTO signup(SignupRequestDTO signupRequestDTO) throws RoleNotFoundException;
    UserResponseDTO login(LoginRequestDTO loginRequestDTO);
    boolean validateToken(String token);
    boolean logout(String token);
}
