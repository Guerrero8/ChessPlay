package org.example;

import org.example.piece.Piece;

import java.util.Map;

public class MovementController {
    public void movePiece(Player player, Board board, Position positionFrom, Position positionTo) {
        Map<Position, Board.Cell> cells = board.getBoardCell();
        Piece pieceInPositionFrom = cells.get(positionFrom).getPiece();
        if (isValidMove(player, board, positionFrom, positionTo)) {
            board.getBoardCell().get(positionFrom).setPiece(null);
            board.getBoardCell().get(positionTo).getPiece().die();
            board.getBoardCell().get(positionTo).setPiece(pieceInPositionFrom);
        }
    }

    private Boolean isValidMove(Player player, Board board, Position positionFrom, Position positionTo) {
        Board.Cell cellOnPositionFrom = board.getBoardCell().get(positionFrom);
        if (cellOnPositionFrom == null || cellOnPositionFrom.getPiece() == null) {
            return false;
        }
        Piece pieceOnPositionFrom = cellOnPositionFrom.getPiece();

        if (!player.getActivePieces().contains(pieceOnPositionFrom)) {
            return false;
        } else if (!pieceOnPositionFrom.makeMove(player, positionFrom, positionTo)) {
            return false;
        } else if (!board.getBoardCell().containsKey(positionTo)) {
            return false;
        }
        Piece pieceOnPositionTo = board.getBoardCell().get(positionTo).getPiece();
        if (player.getActivePieces().contains(pieceOnPositionTo)) {
            return false;
        } else {
            return true;
        }
    }
}
