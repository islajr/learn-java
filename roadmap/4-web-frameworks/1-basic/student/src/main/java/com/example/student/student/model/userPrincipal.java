package com.example.student.student.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class userPrincipal implements UserDetails {

    private user _user;

    public userPrincipal(user _user) {
        this._user = _user;
    }

    @Override   
    public Collection<? extends GrantedAuthority> getAuthorities() {

//        return Collections.singleton(new SimpleGrantedAuthority("USER"));
        return Collections.singleton(new SimpleGrantedAuthority(_user.get_role().toString()));
    }

    @Override
    public String getPassword() {
        return _user.getPassword();
    }

    @Override
    public String getUsername() {
        return _user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
