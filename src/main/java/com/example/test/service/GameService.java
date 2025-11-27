package com.example.test.service;


import com.example.test.dto.GameDTO;
import fr.le_campus_numerique.square_games.engine.Game;

import java.util.List;
import java.util.UUID;


public interface GameService {
    List<GameDTO> getAllGames();
    GameDTO getGameById(UUID id);
    GameDTO createGame(GameCreationParams params);
    boolean deleteGame(UUID id);
    GameDTO updateGame(GameDTO game);
}


