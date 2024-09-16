package com.example.player.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.player.model.Player;
import com.example.player.model.PlayerPrincipal;
import com.example.player.repository.PlayerRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Player player = playerRepository.findByUsername(username);

        if (player == null) {
            System.out.println("User not found!");
            throw new UsernameNotFoundException("User not found!");
        }

        return new PlayerPrincipal(player);
    }
}
