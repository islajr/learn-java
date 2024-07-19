package com.example.player.service;

import com.example.player.model.Player;
import com.example.player.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerService {

    public final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Optional<Player> getPlayers() {
        return null;
    }

    public void createPlayer(Player player) {
    }

    public Optional<Player> getPlayer(UUID id) {
        return null;
    }
}
