package com.example.test.controller;

import com.example.test.dto.GameDTO;
import com.example.test.service.CellPos;
import com.example.test.service.GameCreationParams;
import com.example.test.service.GameService;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GameController {
    @Autowired
    private GameService service;

    @GetMapping("/games")
    public List<GameDTO> getAllGames() {
        List<Game> games = service.getAllGames();
        List<GameDTO> gamesDTO = new ArrayList<>();

        for (Game game : games) {
            gamesDTO.add(GameDTO.from(game));
        }

        return gamesDTO;
    }

    @GetMapping("/games/{gameId}")
    public GameDTO getGame(@PathVariable("gameId") String gameId) {
        return GameDTO.from(service.getGameById(gameId));
    }

    @PostMapping("/games")
    public GameDTO createGame(@RequestBody GameCreationParams params) {
        return GameDTO.from(service.createGame(params));
    }

    @DeleteMapping("/games/{gameId}")
    public boolean deleteGame(@PathVariable("gameId") String gameId) {
        boolean deleted = service.deleteGame(gameId);

        return deleted;
    }


    @PutMapping("/games/{gameId}")
    public GameDTO updateGame(@PathVariable("gameId") String gameId, @RequestBody CellPos move) {
        Game game = service.getGameById(gameId);
        service.updateGame(game);
        return GameDTO.from(service.getGameById(gameId));
    }
}
