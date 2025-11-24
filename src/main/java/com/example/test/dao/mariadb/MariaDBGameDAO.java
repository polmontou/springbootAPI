package com.example.test.dao.mariadb;

import com.example.test.dao.GameDAO;
import com.example.test.dbconnect.MariaDBConnectSingleton;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.InconsistentGameDefinitionException;
import fr.le_campus_numerique.square_games.engine.TokenPosition;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
public class MariaDBGameDAO implements GameDAO {
    private Connection connection = MariaDBConnectSingleton.getInstance().getConnection();

    public List<Game> getAllGames() {
        String query = "SELECT * FROM `game`";
        List<Game> games = new ArrayList<>();
        List<UUID> fakePlayers = new ArrayList<>();
        Collection<TokenPosition<UUID>> tokens = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            UUID uuid = UUID.randomUUID();
            fakePlayers.add(uuid);
        }

        try(Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        ) {
            while(rs.next()) {
                GameFactory gameFactory = getGameFactory(rs.getString("game_type"));

                try {
                    Game createdGame = gameFactory.createGameWithIds(UUID.fromString(rs.getString("id")),
                            rs.getInt("board_size"),
                            fakePlayers,
                            tokens,
                            tokens);

                    games.add(createdGame);
                } catch (InconsistentGameDefinitionException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return games;
    }

    public Game getGameById(String gameId) {
        String query = "SELECT * FROM game WHERE id = ?";
        Game game = null;
        List<UUID> fakePlayers = new ArrayList<>();
        Collection<TokenPosition<UUID>> tokens = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            UUID uuid = UUID.randomUUID();
            fakePlayers.add(uuid);
        }

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, gameId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                GameFactory gameFactory = getGameFactory(rs.getString("game_type"));
                try {
                    game = gameFactory.createGameWithIds(UUID.fromString(rs.getString("id")),
                            rs.getInt("board_size"),
                            fakePlayers,
                            tokens,
                            tokens);
                } catch (InconsistentGameDefinitionException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return game;
    }

    public void addGame(Game game) {
        String query = "INSERT INTO game (id, board_size, game_type) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, game.getId().toString());
            stmt.setInt(2, game.getBoardSize());
            stmt.setString(3, game.getFactoryId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteGame(String gameId) {
        String query = "DELETE FROM game WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, gameId);
            int deleted = stmt.executeUpdate();

            return deleted > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public void updateGame(Game game) {
        String query = "UPDATE game SET board_size = ?, game_type = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, game.getBoardSize());
            stmt.setString(2, game.getFactoryId());
            stmt.setString(3, game.getId().toString());

            int deleted = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private GameFactory getGameFactory(String gameType) {
        GameFactory gameFactory = null;

        switch (gameType) {
            case "tictactoe":
                gameFactory = new TicTacToeGameFactory();
                break;
            case "connect4":
                gameFactory = new ConnectFourGameFactory();
                break;
        }
        return gameFactory;
    }
}
