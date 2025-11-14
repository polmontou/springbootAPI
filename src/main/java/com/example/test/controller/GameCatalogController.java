package com.example.test.controller;

import com.example.test.GameCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class GameCatalogController {

    @Autowired
    private GameCatalog gameCatalog;

    @GetMapping("/gameId")
    public Collection<String> getGameId() {
        return gameCatalog.getGameIdentifiers();
    }
}
