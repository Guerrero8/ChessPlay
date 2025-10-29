package org.example;

import org.example.piece.Piece;

import java.util.Map;

public class MovementController {
    public void movePiece(Player player, Board board, Position positionFrom, Position positionTo) {
        Map<Position, Board.Cell> cells = board.getBoard();
        Piece pieceInPositionFrom = cells.get(positionFrom).getPiece();
        if (isValidMove(player, board, positionFrom, positionTo)) {
            board.getBoard().get(positionFrom).setPiece(null);
            board.getBoard().get(positionTo).getPiece().die();
            board.getBoard().get(positionTo).setPiece(pieceInPositionFrom);
        }
    }

    private Boolean isValidMove(Player player, Board board, Position positionFrom, Position positionTo) {
        Board.Cell cellOnPositionFrom = board.getBoard().get(positionFrom);
        if (cellOnPositionFrom == null || cellOnPositionFrom.getPiece() == null) {
            return false;
        }
        Piece pieceOnPositionFrom = cellOnPositionFrom.getPiece();

        if (!player.getActivePieces().contains(pieceOnPositionFrom)) {
            return false;
        } else if (!pieceOnPositionFrom.makeMove(player, positionFrom, positionTo)) {
            return false;
        } else if (!board.getBoard().containsKey(positionTo)) {
            return false;
        }
        Piece pieceOnPositionTo = board.getBoard().get(positionTo).getPiece();
        if (player.getActivePieces().contains(pieceOnPositionTo)) {
            return false;
        } else {
            return true;
        }
    }
}
