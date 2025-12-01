package com.example.test.service;


import com.example.test.dto.GameDTO;


import java.util.List;
import java.util.UUID;


public interface GameService {
    List<GameDTO> getAllGames();
    List<GameDTO> getGamesByLogs(String logs);
    GameDTO getGameById(UUID id);
    GameDTO createGame(GameCreationParams params);
    boolean deleteGame(UUID id);
    GameDTO updateGame(GameDTO game);
}


