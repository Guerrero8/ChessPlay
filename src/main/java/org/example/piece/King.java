package org.example.piece;

import org.example.Player;
import org.example.Position;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    private final String texturePath = "src/main/resources/org/example/texture/King.png";

    public King(Player owner) {
        super("King", owner, Color.WHITE, 20, 2, 5, 2); // hp=20, armour=2, shield=5, damage=2
    }

    @Override
    public List<Position> getAvailableMoves(@NotNull Position positionFrom) {
        List<Position> availableMoves = new ArrayList<>();
        int x = positionFrom.getX();
        int y = positionFrom.getY();

        availableMoves.add(new Position(x + 1, y));
        availableMoves.add(new Position(x - 1, y));
        availableMoves.add(new Position(x, y + 1));
        availableMoves.add(new Position(x, y - 1));
        availableMoves.add(new Position(x + 1, y + 1));
        availableMoves.add(new Position(x - 1, y + 1));
        availableMoves.add(new Position(x + 1, y - 1));
        availableMoves.add(new Position(x - 1, y - 1));

        return availableMoves;
    }
}
