package com.example.test.dao;

import fr.le_campus_numerique.square_games.engine.Game;

import java.util.List;
import java.util.UUID;

public interface GameDAO {
    public List<Game> getAllGames();
    public Game getGameById(String id);
    public void addGame(Game game);
    public void deleteGame(String id);
    public void updateGame(Game game);
}
