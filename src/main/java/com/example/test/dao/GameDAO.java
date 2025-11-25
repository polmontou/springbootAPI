package com.example.test.dao;

import fr.le_campus_numerique.square_games.engine.Game;

import java.util.List;

public interface GameDAO {
    List<Game> getAllGames();
    Game getGameById(String id);
    void addGame(Game game);
    boolean deleteGame(String gameId);
    void updateGame(Game game);
}
