package com.example.test.dao.mariadb;

import com.example.test.dao.GameDAO;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MariaDBGameDAO implements GameDAO {
    public List<Game> getAllGames() {
        return null;
    }

    public Game getGameById(String id) {
        return null;
    }

    public void addGame(Game game) {

    }

    public void deleteGame(String id) {

    }

    public void updateGame(Game game) {

    }
}
