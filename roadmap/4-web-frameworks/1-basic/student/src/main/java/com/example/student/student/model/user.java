package com.example.student.student.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users", schema = "public")
public class user {

    @Id
    private int id;

    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "_role_id")
    private role _role;

    public role get_role() {
        return _role;
    }

    public void set_role(role _role) {
        this._role = _role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + _role + '\'' +
                '}';
    }
}
