package com.example.test.dto;

import com.example.test.model.GameModel;
import fr.le_campus_numerique.square_games.engine.Game;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class GameDTO {
    private String id;
    private String gameType;
    private int boardSize;

    static public GameDTO from(Game game) {
        return GameDTO.builder()
                .id(game.getId().toString())
                .gameType(game.getFactoryId())
                .boardSize(game.getBoardSize())
                .build();
    }
    static public GameDTO from(GameModel game) {
        return GameDTO.builder()
                .id(game.getId().toString())
                .gameType(game.getGame_type())
                .boardSize(game.getBoard_size())
                .build();
    }
}
