package dev.ansh.EcomUserAuthService.dto;

import dev.ansh.EcomUserAuthService.entity.Role;
import dev.ansh.EcomUserAuthService.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserResponseDTO {
    private String email;
    private String name;
    private List<RoleResponseDTO> roles;

    public static UserResponseDTO from(User user) {
        if(user == null) return null;
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setName(user.getName());
        userResponseDTO.roles=new ArrayList<>();
        for(Role role : user.getRoles()) {
            RoleResponseDTO roleResponseDTO = new RoleResponseDTO();
            roleResponseDTO.setDesc(role.getDesc());
            roleResponseDTO.setRole(role.getRoleName());
            userResponseDTO.roles.add(roleResponseDTO);
        }
        return userResponseDTO;
    }


}

