package org.example;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class GameEngine {
    @Autowired
    private Board board;
    String moveTurn = "White";

    public void getPieceMove(String position) throws Exception {
        List<String> acceptedMoves = board.board.get(position).piece.getPotentialMoves(position);
        for (String move : acceptedMoves) {
            if (board.board.containsKey(move)) {

            } else {
                acceptedMoves.remove(move);
            }
        }
    }
}
