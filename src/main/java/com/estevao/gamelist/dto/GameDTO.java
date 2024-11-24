package com.estevao.gamelist.dto;

import com.estevao.gamelist.entities.Game;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;

public class GameDTO extends GameMinDTO{

    private String genre;
    private String platforms;
    private Double score;
    private String longDescription;

    public GameDTO() {
    }

    public GameDTO(Game game) {
        super(game);
        this.genre = game.getGenre();
        this.platforms = game.getPlatform();
        this.score = game.getScore();;
        this.longDescription = game.getLongDescription();

        //BeanUtils.copyProperties(game,this);
    }

    public String getGenre() {
        return genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public Double getScore() {
        return score;
    }

    public String getLongDescription() {
        return longDescription;
    }
}
