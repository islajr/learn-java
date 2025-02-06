package com.example.player.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.player.model.Player;
import com.example.player.service.PlayerService;

import jakarta.servlet.http.HttpServletRequest;

@RequestMapping(path = "/api/v1/player")
@RestController
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    /*@GetMapping("/")
    public String greet(HttpServletRequest request) {
        return "Welcome, Isla\n" + request.getSession().getId();
    }*/

    @GetMapping("/")
    public String greet() {
        return "Welcome, Isla! ";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/getPlayers")
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }
            
    @PostMapping("/createPlayer")
    public void createPlayer(@RequestBody Player player) {
        playerService.createPlayer(player);
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/getPlayer/{id}")
    public Optional<Player> getPlayer(@PathVariable("id") Long id) {
        return playerService.getPlayer(id);
    }

    @DeleteMapping("/deletePlayer/{id}")
    public void deletePlayer(@PathVariable("id") Long id) {
        playerService.deletePlayer(id);
    }

    @PutMapping("/updatePlayer/{id}")
    public void updatePlayer(@PathVariable("id") Long id,
                             @RequestParam (required = false) @RequestBody String name,
                             @RequestParam (required = false) @RequestBody Integer age,
                             @RequestParam (required = false) @RequestBody String position) {
        playerService.updatePlayer(id, name, age, position);
    }
}
