package org.project.expensetrackerapi.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    public String username;

    @Column(name = "password", nullable = false)
    public String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @Nullable
    private List<Expense> expenses = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
