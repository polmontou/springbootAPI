package com.example.test.dto;

import fr.le_campus_numerique.square_games.engine.Game;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class GameDTO {
    private String id;
    private String gameType;
    private int playerCount;
    private int boardSize;

    static public GameDTO from(Game game) {
        return GameDTO.builder()
                .id(game.getId().toString())
                .gameType(game.getClass().toString())
                .playerCount(game.getPlayerIds().toArray().length)
                .boardSize(game.getBoardSize())
                .build();
    }
}
