package com.example.test.controller;

import com.example.test.dto.GameDTO;
import com.example.test.service.GameCreationParams;
import com.example.test.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/games")
    public List<GameDTO> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/games/{gameId}")
    public GameDTO getGame(@PathVariable("gameId") UUID gameId) {
        return gameService.getGameById(gameId);
    }

    @PostMapping("/games/user_logs")
    public List<GameDTO> getGamesByLogs(@RequestBody String logs) {
        return gameService.getGamesByLogs(logs);
    }

    @PostMapping("/games")
    public GameDTO createGame(@RequestBody GameCreationParams params) {
        return gameService.createGame(params);
    }

    @DeleteMapping("/games/{gameId}")
    public boolean deleteGame(@PathVariable("gameId") UUID gameId) {
        return gameService.deleteGame(gameId);
    }


    @PutMapping("/games")
    public GameDTO updateGame(@RequestBody GameDTO game) {
        return gameService.updateGame(game);
    }

}
