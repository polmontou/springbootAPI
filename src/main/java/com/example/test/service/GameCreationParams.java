package com.example.test.service;

import lombok.Getter;

import java.util.UUID;

@Getter
public class GameCreationParams {
    private String gameType;
    private int playerCount;
    private int boardSize;
    private UUID userId;
}
