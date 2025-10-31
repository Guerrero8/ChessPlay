package org.example;

import org.example.piece.King;
import org.example.piece.Rook;

import java.util.Map;

public class PiecePlacementController {

    public Board createDefaultPlacement(Player player) {
        Board board = player.getBoard();

        board.addPiece(new Position(2, 1), new King(player));
        board.addPiece(new Position(1, 1), new Rook(player));

        return board;

    }


}
