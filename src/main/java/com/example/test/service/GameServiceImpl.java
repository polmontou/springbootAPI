package com.example.test.service;

import com.example.test.dao.GameDAO;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameDAO gameDAO;

    private List<Game> games;

    public List<Game> getAllGames() {
        return gameDAO.getAllGames();
    }

    @Override
    public Game getGameById(String gameId) {
        return gameDAO.getGameById(gameId);
    }

    public Game createGame(GameCreationParams params) {
        GameFactory game = null;
        switch (params.getGameType()) {
            case "tictactoe":
                game = new TicTacToeGameFactory();
                break;
            case "connect4":
                game = new ConnectFourGameFactory();
                break;
        }
        Game createdGame = game.createGame(params.getPlayerCount(), params.getBoardSize());
        gameDAO.addGame(createdGame);
        return createdGame;
    }

    public boolean deleteGame(String id) {
        gameDAO.deleteGame(id);
        return true;
    }

    public void updateGame(String gameId) {
    }

}
