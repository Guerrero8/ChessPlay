package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.piece.Piece;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
@Component
public class Board implements Serializable {
    private int width;
    private int height;
    private final Map<Position, Cell> boardCell = new LinkedHashMap<>();

    public Board() {
        this(3, 3);
    }

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        initializeBoard(width, height);
    }

    private void initializeBoard(int width, int height) {
        boardCell.clear();
        for (int y = 1; y <= height; y++) {
            for (int x = 1; x <= width; x++) {
                Position position = new Position(x, y);
                boardCell.put(position, new Cell(colorizeCell(position), null));
            }

        }
    }

    public void reColorizeBoard(Map<Position, Cell> board) {
        for (Map.Entry<Position, Cell> entry : board.entrySet()) {
            entry.getValue().setColor(colorizeCell(entry.getKey()));
        }
    }

    public Color colorizeCell(Position position) {
        int x = position.getX();
        int y = position.getY();
        return (x + y) % 2 == 0 ? Color.WHITE : Color.BLACK;
    }

    public int getMaxX() {
        return boardCell.keySet().stream().mapToInt(Position::getY).max().orElse(0);
    }

    public int getMaxY() {
        return boardCell.keySet().stream().mapToInt(Position::getY).max().orElse(0);
    }

    public void addCell(Position position) {
        if (!boardCell.containsKey(position)) {
            boardCell.put(position, new Cell(colorizeCell(position), null));
        }
    }

    public void addPiece(Position position, Piece piece) {
        boardCell.get(position).setPiece(piece);
    }

    public void removePiece(Position position) {
        boardCell.get(position).setPiece(null);
    }

    public void replacePiece(Position positionFrom, Position positionTo) {
        addPiece(positionTo, boardCell.get(positionFrom).getPiece());
        removePiece(positionFrom);
    }


    @Data
    @AllArgsConstructor
    public static class Cell implements Serializable {
        private Color color;
        private Piece piece;
    }
}
