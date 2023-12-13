package com.example.meetingsmanagmentandorganization.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@Getter
public enum Roles implements GrantedAuthority {
    ADMIN("Администратор"),
    USER("Пользователь"),
    MANAGER("Управляющий встречей");

    private final String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}
