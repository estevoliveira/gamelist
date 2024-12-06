package com.estevao.gamelist.Controllers;

import com.estevao.gamelist.dto.GameListDTO;
import com.estevao.gamelist.dto.GameMinDTO;
import com.estevao.gamelist.dto.ReplacementDTO;
import com.estevao.gamelist.services.GameListService;
import com.estevao.gamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/all-list")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
        //return "<h1>Hello world</h1>";
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }

    //SELECT position,list_id,game_id FROM TB_BELONGING where list_id = 2 order by position
    @PostMapping(value = "/{listId}/replaciment")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
