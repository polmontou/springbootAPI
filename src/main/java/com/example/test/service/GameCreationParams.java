package com.example.test.service;

import lombok.Getter;

@Getter
public class GameCreationParams {
    private String gameType;
    private int playerCount;
    private int boardSize;
}
