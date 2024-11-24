package com.estevao.gamelist.services;

import com.estevao.gamelist.dto.GameListDTO;
import com.estevao.gamelist.entities.GameList;
import com.estevao.gamelist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        return gameListRepository.findAll().stream().map(GameListDTO::new).toList();
    }
}
