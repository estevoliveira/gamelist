package com.estevao.gamelist.services;

import com.estevao.gamelist.dto.GameDTO;
import com.estevao.gamelist.dto.GameMinDTO;
import com.estevao.gamelist.entities.Game;
import com.estevao.gamelist.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long idGame){
        Optional<Game> g = gameRepository.findById(idGame);
        return new GameDTO(g.get());
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        return  gameRepository.searchByList(listId)
                .stream()
                .map(GameMinDTO::new)
                .toList();
    }
}
