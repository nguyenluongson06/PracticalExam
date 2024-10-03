package com.java2.practicalexam.controller;

import com.java2.practicalexam.entity.Player;
import com.java2.practicalexam.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/player")
public class PlayerController {
    private final PlayerService playerService;
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/all-players")
    public ResponseEntity<List<Player>> getPlayers() {
        try {
            List<Player> playerList = playerService.getAllPlayers();
            return ResponseEntity.ok(playerList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping
    public ResponseEntity<Player> getPlayer(@RequestParam Integer id) {
        try {
            Optional<Player> result = Optional.ofNullable(playerService.getPlayerById(id));
            return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deletePlayer(@RequestParam Integer id){
        try {
            boolean status = playerService.deletePlayer(id);
            if (status) {
                return ResponseEntity.ok("Player with ID" + id + "deleted");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to delete player with ID " + id);
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/get-by-name")
    public ResponseEntity<List<Player>> getPlayersByPlayerName(@RequestParam String name) {
        try {
            List<Player> playerList = playerService.getAllPlayersByName(name);
            return ResponseEntity.ok(playerList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/top10")
    public ResponseEntity<List<Player>> getTop10Players() {
        try {
            List<Player> playerList = playerService.getTopPlayers(10);
            return ResponseEntity.ok(playerList);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping
    public ResponseEntity<String> addPlayer(@RequestBody Player player) {
        try {
            playerService.addPlayer(player);
            return ResponseEntity.status(HttpStatus.CREATED).body("Player added");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
