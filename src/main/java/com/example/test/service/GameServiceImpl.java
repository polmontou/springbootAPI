package com.example.test.service;

import com.example.test.dto.GameCreationParamsDTO;
import com.example.test.dto.GameDatasDTO;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    public void createGame(GameCreationParamsDTO params) {
        GameFactory game = null;
        switch (params.getGameType()) {
            case "tictactoe":
                game = new TicTacToeGameFactory();
                break;
            case "connect4":
                game = new ConnectFourGameFactory();
                break;
        }
        game.createGame(params.getPlayerCount(), params.getBoardSize());
    }

    @Override
    public GameDatasDTO getGameDatas(GameDatas game) {
        return GameDatasDTO.fromEntity(game);
    }


}
