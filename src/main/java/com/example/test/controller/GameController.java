package com.example.test.controller;

import com.example.test.dto.GameDTO;
import com.example.test.service.CellPos;
import com.example.test.service.GameCreationParams;
import com.example.test.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {
    @Autowired
    private GameService service;

    @PostMapping("/games")
    public GameDTO createGame(@RequestBody GameCreationParams params) {
        return GameDTO.from(service.createGame(params));
    }

    @GetMapping("/games/{gameId}")
    public GameDTO getGame(@PathVariable("gameId") String gameId) {
        return GameDTO.from(service.findGameById(gameId));
    }

    @PutMapping("/games/{gameId}/{tokenId}")
    public String updateGame(@PathVariable("gameId") String gameId, @PathVariable("tokenId") String tokenId, @RequestBody CellPos move) {
        return null;
    }
}
