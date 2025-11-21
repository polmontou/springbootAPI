package com.example.test.service;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GameCreationParams {
    private String gameType;
    private int playerCount;
    private int boardSize;
}
