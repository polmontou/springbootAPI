package com.example.test.controller;

import com.example.test.model.GameModel;
import com.example.test.dao.jpastorage.GameRepository;
import com.example.test.dto.GameDTO;
import com.example.test.service.CellPos;
import com.example.test.service.GameCreationParams;
import com.example.test.service.GameService;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class GameController {
    @Autowired
    private GameService service;

    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/games")
    public List<GameDTO> getAllGames() {
        Iterable<GameModel> games = gameRepository.findAll();
        List<GameDTO> gamesDTO = new ArrayList<>();

        for (GameModel game : games) {
            gamesDTO.add(GameDTO.from(game));
        }

        return gamesDTO;
    }

    @GetMapping("/games/{gameId}")
    public GameDTO getGame(@PathVariable("gameId") String gameId) {
        GameModel game = gameRepository.findById(UUID.fromString(gameId)).get();
        return GameDTO.from(game);
    }

    @PostMapping("/games")
    public GameDTO createGame(@RequestBody GameCreationParams params) {
        GameModel game = new GameModel();
        game.setGame_type(params.getGameType());
        game.setBoard_size(params.getBoardSize());

        return GameDTO.from(gameRepository.save(game));
    }

    @DeleteMapping("/games/{gameId}")
    public void deleteGame(@PathVariable("gameId") String gameId) {
        gameRepository.deleteById(UUID.fromString(gameId));
    }


    @PutMapping("/games/{gameId}")
    public GameDTO updateGame(@PathVariable("gameId") String gameId, @RequestBody CellPos move) {
        GameModel game = gameRepository.findById(UUID.fromString(gameId)).get();

        return GameDTO.from(gameRepository.save(game));
    }
}
