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

    public Cell getCell(String position) throws Exception {
        if (!board.containsKey(position)) {
            throw new Exception("Клетки " + position + " не существует на доске");
        }
        return board.get(position);
    }
    public void setCell(String position, Cell cell) throws Exception {
        if (!board.containsKey(position)) {
            throw new Exception("Клетки " + position + " не существует на доске");
        }
        board.put(position, cell);
    }


    @Data
    @AllArgsConstructor
    public static class Cell {
        String cellColor = "";
        Piece piece = null;
    }
}
