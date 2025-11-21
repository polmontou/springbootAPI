package com.example.test.service;

import com.example.test.dto.GameDTO;
import fr.le_campus_numerique.square_games.engine.Game;

public interface GameService {
    Game createGame(GameCreationParams params);
    Game findGameById(String id);
    GameDTO getGameDatas(Game game);
}

