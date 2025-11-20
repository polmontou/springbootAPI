package com.example.test.dto;

import com.example.test.service.GameCreationParams;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameCreationParamsDTO {
    private String gameType;
    private int playerCount;
    private int boardSize;

    public GameCreationParamsDTO fromEntity(GameCreationParams params) {
        if (params == null) {
            return null;
        }
        return GameCreationParamsDTO.builder()
                .gameType(params.getGameType())
                .playerCount(params.getPlayerCount())
                .boardSize(params.getBoardSize())
                .build();
    }
}
