package com.estevao.gamelist.dto;

import com.estevao.gamelist.entities.GameList;

public class GameListDTO {
    private Long id;
    private String name;

    public GameListDTO() {
    }

    public GameListDTO(GameList list) {
        this.id = list.getId();
        this.name = list.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
