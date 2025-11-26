package com.example.test.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name ="game")
@Getter
@Setter
public class GameModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "board_size")
    private int boardSize;

    @Column(name = "game_type")
    private String gameType;


}
