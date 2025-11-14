package com.example.test.service;

import com.example.test.GameCatalog;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;


@Service
public class GameCatalogImpl implements GameCatalog {
    private TicTacToeGameFactory tttGameFactory = new TicTacToeGameFactory();

    @Override
    public Collection<String> getGameIdentifiers() {
        return Collections.singleton(tttGameFactory.getGameFactoryId());
    }
}
