package org.project.todoapp.model;

import com.google.common.collect.Sets;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static org.project.todoapp.model.Permission.*;

@Getter
public enum Role {
    USER(Sets.newHashSet(USER_CREATE, USER_DELETE, USER_GET, USER_UPDATE)),
    ADMIN(Sets.newHashSet(ADMIN_GET, ADMIN_DELETE, ADMIN_VIEW));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> authorities = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;

    }

}
