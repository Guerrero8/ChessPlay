package org.example.piece;

import lombok.NonNull;
import org.example.Player;
import org.example.Position;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{

    public Rook(Player owner) {
        super("Rook", owner, Color.WHITE, 20, 2, 5, 2); // hp=20, armour=2, shield=5, damage=2
    }

    @Override
    public List<Position> getAvailableMoves(@NonNull Position positionFrom) {
        List<Position> availableMoves = new ArrayList<>();

        availableMoves.add(new Position(positionFrom.getX() + 1, positionFrom.getY()));
        availableMoves.add(new Position(positionFrom.getX() - 1, positionFrom.getY()));
        availableMoves.add(new Position(positionFrom.getX() + 2, positionFrom.getY()));
        availableMoves.add(new Position(positionFrom.getX() - 2, positionFrom.getY()));
        availableMoves.add(new Position(positionFrom.getX(), positionFrom.getY() + 1));
        availableMoves.add(new Position(positionFrom.getX(), positionFrom.getY() - 1));
        availableMoves.add(new Position(positionFrom.getX(), positionFrom.getY() + 2));
        availableMoves.add(new Position(positionFrom.getX(), positionFrom.getY() - 2));

        return List.of();
    }
}
