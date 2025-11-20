package com.example.test.service;

import com.example.test.dto.GameCreationParamsDTO;
import com.example.test.dto.GameDatasDTO;

public interface GameService {
    void createGame(GameCreationParamsDTO params);

    GameDatasDTO getGameDatas(GameDatas game);
}

