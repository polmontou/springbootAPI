package com.example.test.dao;

import fr.le_campus_numerique.square_games.engine.Token;

import java.util.List;
import java.util.UUID;

public interface TokenDAO {
    public List<Token> getAllTokens();
    public Token getTokenById(UUID id);
    public void addToken(Token token);
    public void removeToken(UUID id);
    public void updateToken(Token token);
}
