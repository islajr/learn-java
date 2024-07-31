package com.example.player.api;

import com.example.player.model.Player;
import com.example.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "/api/v1/player")
@RestController
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/getPlayers")
    public List<Player> getPlayers() {
        return playerService.getPlayers();

    }

    @PostMapping("/createPlayer")
    public void createPlayer(@RequestBody Player player) {
        playerService.createPlayer(player);
    }

    @GetMapping("/getPlayer/{id}")
    public Optional<Player> getPlayer(@PathVariable("id") Long id) {
        return playerService.getPlayer(id);
    }

    @DeleteMapping("/deletePlayer{id}")
    public void deletePlayer(@PathVariable("id") Long id) {
        playerService.deletePlayer(id);
    }
}
