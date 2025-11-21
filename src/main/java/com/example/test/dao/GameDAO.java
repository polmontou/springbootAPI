package com.example.test.dao;

import fr.le_campus_numerique.square_games.engine.Game;

import java.util.List;
import java.util.UUID;

public interface GameDAO {
    public List<Game> getAllGames();
    public Game getGameById(UUID id);
    public void addGame(Game game);
    public void removeGame(UUID id);
    public void updateGame(Game game);
}
