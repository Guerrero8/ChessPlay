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
    private int width;
    private int height;
    private final Map<Position, Cell> board = new LinkedHashMap<>();

    public Board() {
        this(3, 3);
    }

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        initializeBoard(width, height);
    }

    private void initializeBoard(int width, int height) {
        board.clear();
        for (int y = 1; y <= height; y++) {
            for (int x = 1; x <= width; x++) {
                Position position = new Position(x, y);
                Color color = findCellColor(position);
                board.put(position, new Cell(color, null));
            }
        }
    }

    public void addCell(Position position) {
        if (!board.containsKey(position)) {
            board.put(position, new Cell(findCellColor(position), null));
        }
    }

    public int getMaxX() {
        return board.keySet().stream().mapToInt(Position::getY).max().orElse(0);
    }

    public int getMaxY() {
        return board.keySet().stream().mapToInt(Position::getY).max().orElse(0);
    }

    public Color findCellColor(Position position) {
        int x = position.getX();
        int y = position.getY();
        return (x + y) % 2 == 0 ? Color.WHITE : Color.BLACK;
    }

    @Data
    @AllArgsConstructor
    public static class Cell {
        private Color color;
        private Piece piece;
    }
}
