package com.example.test.dto;

import com.example.test.model.GameModel;
import fr.le_campus_numerique.square_games.engine.Game;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;


@Data
@Builder
public class GameDTO {
    private UUID id;
    private String gameType;
    private int boardSize;
    private UUID userId;

    static public GameDTO from(Game game) {
        return GameDTO.builder()
                .id(game.getId())
                .gameType(game.getFactoryId())
                .boardSize(game.getBoardSize())
                .build();
    }
    static public GameDTO from(GameModel game) {
        return GameDTO.builder()
                .id(game.getId())
                .gameType(game.getGameType())
                .boardSize(game.getBoardSize())
                .userId(game.getUserId())
                .build();
    }
}
