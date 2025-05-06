package org.project.todoapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private Role role;

    @Column(name = "role_str")
    private String roleString;

    public User(String name, String email, String password, Role role, String roleString) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.roleString = roleString;
    }

    public User(String name, String email, String password, String roleString) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roleString = roleString;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }


    public boolean isValid() {
        return !name.isEmpty() || !email.isEmpty() || !password.isEmpty();
    }
}
