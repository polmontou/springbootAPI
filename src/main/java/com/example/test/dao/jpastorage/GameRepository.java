package com.example.test.dao.jpastorage;

import com.example.test.model.GameModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface GameRepository extends CrudRepository<GameModel, UUID> {
}
