package com.example.player.service;

import com.example.player.model.Player;
import com.example.player.repository.PlayerRepository;
import jakarta.transaction.Transactional;
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
        if (!playerRepository.existsById(id)) {
            throw new IllegalStateException("Cannot delete a non-existent player! ");
        }
        playerRepository.deleteById(id);
    }

    @Transactional
    public void updatePlayer(Long id, String name, Integer age, String position) {

        Optional<Player> player = playerRepository.findById(id);
        if (player.isEmpty()) {
            throw new IllegalStateException("Cannot update a non-existent player! ");
        }

        if (!name.equals(player.get().getName()) && !name.isEmpty()) {
            player.get().setName(name);
        }
        if (!age.equals(null)){
            player.get().setAge(age);
        }
        if (!position.isEmpty()) {
            player.get().setPosition(position);
        }
    }
}
