package org.example;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class GameEngine {
    Player player1;
    Player player2;
    Board board1;
    Board board2;
    Board mergedBoard = new Board();

    public GameEngine(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.board1 = player1.getBoard();
        this.board2 = player2.getBoard();
        mergedBoard = mergeBoards(board1, board2);
    }

    public Board mergeBoards(Board whitePlayerBoard, Board blackPlayerBoard) {
        mergedBoard.getBoard().clear();
        mergedBoard.getBoard().putAll(whitePlayerBoard.getBoard());
        mergedBoard.getBoard().putAll(boardTransformation(blackPlayerBoard, whitePlayerBoard.getMaxY()).getBoard());
        return mergedBoard;
    }

    private Board boardTransformation(Board board, int offset) {
        Board turnedBoard = turnBoard(board);
        return offsetBoardVertically(turnedBoard, offset);
    }


    private Board turnBoard(Board board) {
        Map<Position, Board.Cell> turnedBoard = new LinkedHashMap<>();
        for (Map.Entry<Position, Board.Cell> entry : board.getBoard().entrySet()) {
            Position position = new Position(
                    board.getMaxX() - entry.getKey().getX() + 1,
                    board.getMaxY() - entry.getKey().getY() + 1);
            turnedBoard.put(position, entry.getValue());
        }
        Board newBoard = new Board();
        newBoard.getBoard().putAll(turnedBoard);
        return newBoard;
    }

    private Board offsetBoardVertically(Board board, int offset) {
        Map<Position, Board.Cell> turnedBoard = new LinkedHashMap<>();
        for (Map.Entry<Position, Board.Cell> entry : board.getBoard().entrySet()) {
            Position position = new Position(
                    entry.getKey().getX(),
                    entry.getKey().getY() + offset + 1);
            turnedBoard.put(position, entry.getValue());
        }
        Board newBoard = new Board();
        newBoard.getBoard().putAll(turnedBoard);
        return newBoard;
    }


}