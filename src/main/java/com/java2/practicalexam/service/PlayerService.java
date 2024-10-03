package com.java2.practicalexam.service;

import com.java2.practicalexam.entity.Player;
import com.java2.practicalexam.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player getPlayerById(int id) throws Exception {
        try {
            return playerRepository.findById(id).get();
        } catch (Exception e) {
            throw new Exception("Error getting player with ID" + id);
        }
    }

    public void insertPlayer(Player player) throws Exception {
        try {
            playerRepository.save(player);
        } catch (Exception e) {
            throw new Exception("Error adding new player" + e.getMessage());
        }
    }

    public boolean deletePlayer(int playerId) throws Exception {
        try {
            playerRepository.deleteById(playerId);
        } catch (Exception e) {
            throw new Exception("Error deleting player with ID " + playerId + e.getMessage());
        }
        return false;
    }

    public List<Player> getAllPlayers() throws Exception {
        try {
            return (List<Player>) playerRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Error getting all players" + e.getMessage());
        }
    }

    public List<Player> getAllPlayersByName(String playerName) throws Exception {
       try {
           return playerRepository.findByPlayerNameContainingIgnoreCase(playerName);
       } catch (Exception e) {
           throw new Exception("Error getting all players by name " + playerName + e.getMessage());
       }
    }

    public List<Player> getTopPlayers(int quantity) throws Exception {
        try {
            Pageable topPlayersPage = PageRequest.of(0, quantity);
            return playerRepository.findTopByOrderByHighScoreDesc(topPlayersPage);
        } catch (Exception e) {
            throw new Exception("Error getting top" + quantity + "players " + e.getMessage());
        }
    }

    public Player addPlayer(Player player) throws Exception {
        try {
            return playerRepository.save(player);
        } catch (Exception e) {
            throw new Exception("Failed to add player. Check logs for details.");
        }
    }
}
