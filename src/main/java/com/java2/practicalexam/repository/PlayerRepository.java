package com.java2.practicalexam.repository;

import com.java2.practicalexam.entity.Player;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findByPlayerNameContainingIgnoreCase(String playerName);

    List<Player> findTopByOrderByHighScoreDesc(Pageable pageable);
}
