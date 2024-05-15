package dev.ansh.EcomUserAuthService.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="ECOM_USER")
public class User extends BaseModel {
    private String name;
    private String password;
    private String email;

    @ManyToMany
    private List<Role> roles;
}
