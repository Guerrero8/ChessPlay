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
        placePiece("d4", new King());
        placePiece("c5", new King());
        placePiece("b4", new King());

        for (Map.Entry<String, Board.Cell> board : board.board.entrySet()) {
            System.out.println(board.getKey());
            System.out.println(board.getValue());
        }
    }

    private void colorizeBoard() {
        String color = "Black";
        for (int i = 1; i <= 8; i++) {
            for (char j = 'a'; j <= 'h'; j++) {
                board.board.put("" + j + i, new Board.Cell(color, null));
                color = color.equals("White") ? "Black" : "White";
            }
        }
    }
    private String pieceColor(String position) throws Exception {
        if (position.charAt(1) <= '4'){
            return "White";
        }
        if (position.charAt(1) >= '5'){
            return "Black";
        }
        throw new Exception("color???");
    }

    public void placePawns() throws Exception {
        String color;
        for (Map.Entry<String, Board.Cell> board : board.board.entrySet()) {
            int positionY = Character.getNumericValue(board.getKey().charAt(1));
            if (positionY == 2) {
                board.getValue().setPiece(new Pawn(pieceColor(board.getKey())));
            } else if (positionY == 7) {
                board.getValue().setPiece(new Pawn(pieceColor(board.getKey())));
            }
        }
    }

    public void placePiece(String position, Piece piece) throws Exception {
        piece.setColor(pieceColor(position));
        board.board.get(position).setPiece(piece);
    }
}
