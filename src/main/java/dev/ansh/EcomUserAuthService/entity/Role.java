package dev.ansh.EcomUserAuthService.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name="ECOM_USER_ROLE")
@Getter
@Setter
public class Role extends BaseModel{
    private String roleName;
    private String desc;
}
