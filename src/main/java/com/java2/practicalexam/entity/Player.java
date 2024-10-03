package com.java2.practicalexam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "player")
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PlayerId", nullable = false)
    private int playerId;

    @Getter
    @Column(name = "PlayerName")
    private String playerName;

    @Getter
    @Column(name = "HighScore")
    private int highScore;

    @Getter
    @Column(name = "Level")
    private int level;

    @ManyToOne
    @JoinColumn(name = "NationalId", nullable = false)
    private National national;
}
