package com.example.player.repository;

import com.example.player.model.Player;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends Repository<Player, Long> {
}
