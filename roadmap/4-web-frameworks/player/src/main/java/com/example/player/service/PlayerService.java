package com.example.player.service;

import com.example.player.exception.PlayerNotFoundException;
import com.example.player.model.Player;
import com.example.player.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
        throw new PlayerNotFoundException("This player does not exist!");
    }

    public void deletePlayer(Long id) {

        boolean exists = playerRepository.existsById(id);

        if (!exists) {
            throw new PlayerNotFoundException("Cannot delete a non-existent player");
        }
        playerRepository.deleteById(id);
    }

    @Transactional
    public void updatePlayer(Long id, String name, Integer age, String position) {

        Optional<Player> player = playerRepository.findById(id);
        if (player.isEmpty()) {
            throw new PlayerNotFoundException("Cannot update a non-existent player! ");
        }

        if (!name.equals(player.get().getName()) && !name.isEmpty() && !Objects.equals(player.get().getName(), name)) {
            player.get().setName(name);
        }
        if (!(age == null) && !Objects.equals(player.get().getAge(), age)){
            player.get().setAge(age);
        }
        if (!(position == null) && !position.isEmpty() && Objects.equals(player.get().getPosition(), position)) {
            player.get().setPosition(position);
        }
        // abandoning this project
    }
}
