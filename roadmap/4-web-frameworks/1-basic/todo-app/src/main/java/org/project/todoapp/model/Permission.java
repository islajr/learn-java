package org.project.todoapp.model;

import lombok.Getter;

@Getter
public enum Permission {
    USER_CREATE("user:create_todo"),
    USER_GET("user:get_todo"),
    USER_UPDATE("user:update_todo"),
    USER_DELETE("user:delete_todo"),
    ADMIN_VIEW("admin:view_all_todos"),
    ADMIN_DELETE("admin:delete_user"),
    ADMIN_GET("admin:get_all_users");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

}
