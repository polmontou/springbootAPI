package com.example.test.controller;

import com.example.test.dto.GameCreationParamsDTO;
import com.example.test.dto.GameDatasDTO;
import com.example.test.service.CellPos;
import com.example.test.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {
    @Autowired
    private GameService service;

    @PostMapping("/games")
    public String createGame(@RequestBody GameCreationParamsDTO params) {
        service.createGame(params);
        return "success";
    }

    @GetMapping("/games/{gameId}")
    public GameDatasDTO getGame(@PathVariable("gameId") String gameId) {
        return null;
    }

    @PutMapping("/games/{gameId}/{tokenId}")
    public String updateGame(@PathVariable("gameId") String gameId, @PathVariable("tokenId") String tokenId, @RequestBody CellPos move) {
        return null;
    }
}
