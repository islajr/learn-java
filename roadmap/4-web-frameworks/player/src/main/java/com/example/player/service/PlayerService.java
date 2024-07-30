package com.example.player.service;

import com.example.player.model.Player;
import com.example.player.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    public final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public void createPlayer(Player player) {
        playerRepository.save(player);
    }

    public Optional<Player> getPlayer(Long id) {
        if (playerRepository.existsById(id)) {
            return playerRepository.findById(id);
        }
        // else
        throw new IllegalStateException("Such player does not exist! ");
    }

    public void deletePlayer(Long id) {
    }
}
