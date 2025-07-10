package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.piece.Piece;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
@Component
public class Board {
    Map<String, Cell> board = new LinkedHashMap<>();

    @Data
    @AllArgsConstructor
    public static class Cell {
        String cellColor = "";
        Piece piece = null;
    }
}
