package org.example.visual;

import org.example.Board;
import org.example.GameEngine;
import org.example.Player;
import org.example.Position;

import java.util.Map;

public class GameController {

    private GameEngine gameEngine;

    public void startGame() {
        // создаем игроков
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // создаем движок игры
        gameEngine = new GameEngine(player1, player2);

        // пока просто проверим что все запустилось
        System.out.println(player1.toString());
        System.out.println(player2.toString());
        for (Map.Entry<Position, Board.Cell> asdf : gameEngine.getMergedBoard().getBoard().entrySet()){
            System.out.println(asdf.toString());
        }


    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }
}