package org.project.todoapp.model;

import com.google.common.collect.Sets;

import java.util.Set;

import static org.project.todoapp.model.Permission.*;

public enum Role {
    USER(Sets.newHashSet(USER_CREATE, USER_DELETE, USER_GET, USER_UPDATE)),
    ADMIN(Sets.newHashSet(ADMIN_GET, ADMIN_DELETE, ADMIN_VIEW));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
}
