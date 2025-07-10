package org.example;

import org.example.piece.King;
import org.example.piece.Pawn;
import org.example.piece.Piece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PlacementControl {
    @Autowired
    private Board board;

    public void applyDefaultPlacement() throws Exception {
        colorizeBoard();
        placePawns();
        placePiece("e1", new King());
        placePiece("e8", new King());

        for (Map.Entry<String, Board.Cell> entry : board.getBoard().entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    private void colorizeBoard() throws Exception {
        String color = "Black";
        for (int i = 1; i <= 8; i++) {
            for (char j = 'a'; j <= 'h'; j++) {
                board.setCell("" + j + i, new Board.Cell(color, null));
                color = color.equals("White") ? "Black" : "White";
            }
        }
    }

    private String pieceColor(String position) throws Exception {
        if (position.charAt(1) <= '4') {
            return "White";
        }
        if (position.charAt(1) >= '5') {
            return "Black";
        }
        throw new Exception("color???");
    }

    public void placePawns() throws Exception {
        for (Map.Entry<String, Board.Cell> entry : board.getBoard().entrySet()) {
            int positionY = Character.getNumericValue(entry.getKey().charAt(1));
            if (positionY == 2) {
                entry.getValue().setPiece(new Pawn(pieceColor(entry.getKey())));
            } else if (positionY == 7) {
                entry.getValue().setPiece(new Pawn(pieceColor(entry.getKey())));
            }
        }
    }

    public void placePiece(String position, Piece piece) throws Exception {
        piece.setColor(pieceColor(position));
        Board.Cell cell = board.getCell(position);
        cell.setPiece(piece);
        board.setCell(position, cell);
    }
}
