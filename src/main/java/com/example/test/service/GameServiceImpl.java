package com.example.test.service;

import com.example.test.dto.GameDTO;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    private List<Game> games;

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
//        Game createdGame = game.createGame(params.getPlayerCount(), params.getBoardSize());
//        games.add(createdGame);
//        return createdGame;
        return game.createGame(params.getPlayerCount(), params.getBoardSize());
    }
    @Override
    public Game findGameById(String gameId) {
        for (Game game : games) {
            if(game.getId().equals(gameId)) {
                return game;
            }
        }
        return null;
    }

    @Override
    public GameDTO getGameDatas(Game game) {
        return GameDTO.from(game);
    }


}
