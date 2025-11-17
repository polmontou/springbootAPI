package com.example.test.controller;

import com.example.test.service.CellPos;
import com.example.test.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class GameController {
    @Autowired
    private GameService service;

    @PostMapping("/games")
    public String createGame(@RequestBody GameController params) {
        return UUID.randomUUID().toString();
    }

    @GetMapping("/games/{gameId}")
    public Object getGame(@PathVariable("gameId") String gameId) {
        return null;
    }

    @PutMapping("/games/{gameId}/{tokenId}")
    public String updateGame(@PathVariable("gameId") String gameId, @PathVariable("tokenId") String tokenId, @RequestBody CellPos move) {
        return null;
    }
}
