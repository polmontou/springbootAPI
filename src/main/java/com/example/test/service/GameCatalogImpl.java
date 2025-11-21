package com.example.test.service;

import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@Service
public class GameCatalogImpl implements GameCatalog {
    private TicTacToeGameFactory tttGameFactory = new TicTacToeGameFactory();
    private ConnectFourGameFactory connectFourGameFactory = new ConnectFourGameFactory();
    private TaquinGameFactory taquinGameFactory = new TaquinGameFactory();

    @Override
    public Collection<String> getGameIdentifiers() {
        Collection<String> gameList = new ArrayList<>();
        gameList.add(tttGameFactory.getGameFactoryId());
        gameList.add(connectFourGameFactory.getGameFactoryId());
        gameList.add(taquinGameFactory.getGameFactoryId());

        return gameList;
    }

}
