package org.example;

import org.example.piece.Piece;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {
    @Autowired
    private Board board;
    String moveTurn = "White";

    public void pieceMove(String startPosition, String endPosition) throws Exception {

        if (board.getCell(startPosition).getPiece() == null) {
            System.out.println("На позиции " + startPosition + " нет фигуры");
            return;
        }

        List<String> acceptedMoves = getAcceptedPieceMove(startPosition);
        if (!acceptedMoves.contains(endPosition)) {
            System.out.println("Ход " + endPosition + " не доступен");
            return;
        }

        Piece piece = board.getCell(startPosition).getPiece();
        board.getCell(startPosition).setPiece(null);
        board.getCell(endPosition).setPiece(piece);
    }

    public List<String> getAcceptedPieceMove(String position) throws Exception {
        List<String> potentialMoves = board.getCell(position).getPiece().getPotentialMoves(position);
        List<String> acceptedMoves = new ArrayList<>();
        for (String move : potentialMoves) {
            if (board.getBoard().containsKey(move)) {
                acceptedMoves.add(move);
            }
        }
        return acceptedMoves;
    }
}
