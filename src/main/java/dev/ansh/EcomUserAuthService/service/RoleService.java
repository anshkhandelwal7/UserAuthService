package dev.ansh.EcomUserAuthService.service;

import dev.ansh.EcomUserAuthService.dto.RoleRequestDTO;
import dev.ansh.EcomUserAuthService.dto.RoleResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO);
}
