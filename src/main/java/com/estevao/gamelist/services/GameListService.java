package com.estevao.gamelist.services;

import com.estevao.gamelist.dto.GameListDTO;
import com.estevao.gamelist.entities.GameList;
import com.estevao.gamelist.projection.GameMinProjection;
import com.estevao.gamelist.repositories.GameListRepository;
import com.estevao.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        return gameListRepository.findAll().stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId,int sourceIndex,int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        var obj = list.remove(sourceIndex);
        list.add(destinationIndex,obj);
        var min = Math.min(sourceIndex,destinationIndex);
        var max = Math.max(sourceIndex, destinationIndex);

        for(var i=min;i<max;i++){
            gameListRepository.updateBelongingPosition(listId,list.get(i).getId(),i);
        }
    }
}
