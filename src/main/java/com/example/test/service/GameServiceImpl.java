package com.example.test.service;

import com.example.test.dao.jpastorage.GameRepository;
import com.example.test.dto.GameDTO;
import com.example.test.model.GameModel;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository gameRepository;


    public List<GameDTO> getAllGames() {
        Iterable<GameModel> games = gameRepository.findAll();
        List<GameDTO> gameDTOS = new ArrayList<>();

        for (GameModel gameModel : games) {
            gameDTOS.add(GameDTO.from(gameModel));
        }
        return gameDTOS;
    }

    @Override
    public GameDTO getGameById(UUID gameId) {
        return GameDTO.from(gameRepository.findById(gameId).get());
    }

    @Override
    public GameDTO createGame(GameCreationParams params) {
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
        GameModel newGame = GameModel.fromGame(createdGame);

        return GameDTO.from(gameRepository.save(newGame));
    }

    public boolean deleteGame(UUID gameId) {
        gameRepository.deleteById(gameId);
        return (!gameRepository.existsById(gameId));
    }

    public GameDTO updateGame(GameDTO gameDTO) {
        return GameDTO.from(gameRepository.save(GameModel.fromGameDTO(gameDTO)));
    }

}
