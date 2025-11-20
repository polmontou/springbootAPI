package com.example.test.dto;

import com.example.test.service.GameDatas;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class GameDatasDTO {
    private String id;
    private String gameType;
    private int playerCount;
    private int boardSize;

    static public GameDatasDTO fromEntity(GameDatas game) {
        return GameDatasDTO.builder()
                .id(game.getId())
                .gameType(game.getGameType())
                .playerCount(game.getPlayerCount())
                .boardSize(game.getBoardSize())
                .build();
    }
}
