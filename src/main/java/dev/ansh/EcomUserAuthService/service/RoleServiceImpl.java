package dev.ansh.EcomUserAuthService.service;

import dev.ansh.EcomUserAuthService.dto.RoleRequestDTO;
import dev.ansh.EcomUserAuthService.dto.RoleResponseDTO;
import dev.ansh.EcomUserAuthService.entity.Role;
import dev.ansh.EcomUserAuthService.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{


    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO) {
        Role role = new Role();
        role.setRoleName(roleRequestDTO.getRoleName());
        role.setDesc(roleRequestDTO.getDescription());
        return RoleResponseDTO.from(roleRepository.save(role));
    }
}
