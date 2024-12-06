package com.estevao.gamelist.dto;

import java.awt.print.PrinterGraphics;

public class ReplacementDTO {

    private Integer sourceIndex;
    private Integer destinationIndex;

    public ReplacementDTO(Integer sourceIndex, Integer destinationIndex) {
        this.sourceIndex = sourceIndex;
        this.destinationIndex = destinationIndex;
    }

    public ReplacementDTO() {
    }

    public Integer getSourceIndex() {
        return sourceIndex;
    }

    public Integer getDestinationIndex() {
        return destinationIndex;
    }
}
