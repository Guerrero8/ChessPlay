package org.example;

import lombok.Data;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

@Data
public class PlayerQueueController {

    private final GameEngine gameEngine;
    private final Queue<Player> turnQueue = new LinkedList<>();
    private Player currentPlayer;

    public PlayerQueueController(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        turnQueue.add(gameEngine.getPlayer1());
        turnQueue.add(gameEngine.getPlayer2());
        startTurn();
    }

    public void startTurn() {
        currentPlayer = turnQueue.peek();
        restoreAllPieceShield(gameEngine.getMergedBoard());
        currentPlayer.setAction(currentPlayer.getMaxAction());
    }

    public void restoreAllPieceShield(Board board) {
        for (Map.Entry<Position, Board.Cell> cell : board.getBoard().entrySet()) {
            if (cell.getValue().getPiece() != null) {
                cell.getValue().getPiece().restoreShield();
            }
        }
    }

    public boolean action(Player player) {
        if (player.getAction() > 0) {
            player.setAction(player.getAction() - 1);
            return true;
        }
        return false;
    }

    public void endTurn() {
        turnQueue.add(turnQueue.poll());
        startTurn();
    }
}
