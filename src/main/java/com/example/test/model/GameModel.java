package com.example.test.model;

import com.example.test.dto.GameDTO;
import fr.le_campus_numerique.square_games.engine.Game;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name ="game")
@Getter
@Setter
public class GameModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "board_size")
    private int boardSize;

    @Column(name = "game_type")
    private String gameType;

    public static GameModel fromGame(Game game) {
        GameModel gameModel = new GameModel();
        gameModel.id = game.getId();
        gameModel.boardSize = game.getBoardSize();
        gameModel.gameType = game.getFactoryId();
        return gameModel;
    }

    public static GameModel fromGameDTO(GameDTO game) {
        GameModel gameModel = new GameModel();
        gameModel.id = game.getId();
        gameModel.boardSize = game.getBoardSize();
        gameModel.gameType = game.getGameType();
        return gameModel;
    }

}
