package dev.ansh.EcomUserAuthService.service;

import dev.ansh.EcomUserAuthService.dto.LoginRequestDTO;
import dev.ansh.EcomUserAuthService.dto.SignupRequestDTO;
import dev.ansh.EcomUserAuthService.dto.UserResponseDTO;
import dev.ansh.EcomUserAuthService.entity.Role;
import dev.ansh.EcomUserAuthService.entity.User;
import dev.ansh.EcomUserAuthService.exception.InvalidCredentialException;
import dev.ansh.EcomUserAuthService.exception.RoleNotFoundException;
import dev.ansh.EcomUserAuthService.exception.UserNotFoundException;
import dev.ansh.EcomUserAuthService.repository.RoleRepository;
import dev.ansh.EcomUserAuthService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserResponseDTO signup(SignupRequestDTO signupRequestDTO) throws RoleNotFoundException {
        Role role = roleRepository.findById(signupRequestDTO.getRoleId()).orElseThrow(
                () -> new RoleNotFoundException("Role not found")
        );
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();


        User user = new User();
        user.setEmail(signupRequestDTO.getEmail());
        user.setPassword(encoder.encode(signupRequestDTO.getPassword()));
        user.setName(signupRequestDTO.getName());
        user.setRoles(List.of(role));

        return UserResponseDTO.from(userRepository.save(user));
    }


    @Override
    public UserResponseDTO login(LoginRequestDTO loginRequestDTO) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
       User savedUser = userRepository.findByEmailId(loginRequestDTO.getEmail()).orElseThrow(
               () -> new UserNotFoundException("User Not found")
       );

       if(encoder.matches(loginRequestDTO.getPassword(), savedUser.getPassword()))
        {
            String userData = savedUser.getEmail()+savedUser.getPassword()+ LocalDateTime.now();
            String token = encoder.encode(userData);
            savedUser.setToken(token);
        }
       else {
           throw new InvalidCredentialException("Invalid Credentials");
       }
       savedUser = userRepository.save(savedUser);
       return UserResponseDTO.from(savedUser);

    }

    @Override
    public boolean validateToken(String token) {
        User savedUser = userRepository.findByToken(token).orElseThrow(
                () -> new InvalidCredentialException("Token is not valid")
        );
        return true;
    }

    @Override
    public boolean logout(String token) {
        User savedUser = userRepository.findByToken(token).orElseThrow(
                () -> new InvalidCredentialException("Token is not valid")
        );
        savedUser.setToken(null);
        userRepository.save(savedUser);
        return true;
    }
}
