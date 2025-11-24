package com.example.test.service;


import fr.le_campus_numerique.square_games.engine.Game;

import java.util.List;


public interface GameService {
    List<Game> getAllGames();
    Game getGameById(String id);
    Game createGame(GameCreationParams params);
    boolean deleteGame(String id);
    void updateGame(String gameId);
}


