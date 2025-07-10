package org.example.piece;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.PositionUtils;

import java.util.List;


@Data
@NoArgsConstructor
public class Pawn implements Piece {
    String color = "White";
    boolean canBypass = false;

    public Pawn(String color) {
        this.color = color;
    }

    @Override
    public List<String> getPotentialMoves(String position) throws Exception {
        PositionUtils positionUtils = new PositionUtils();

        List<String> potentialMoves = new java.util.ArrayList<>(List.of());

        int positionY = positionUtils.getYPositionByPosition(position);
        int positionX = positionUtils.getXPositionIndexByPosition(position);
        int moveForY = positionY;
        int moveForX = positionX;
        String move;

        moveForY = positionY + 1 * positionUtils.getColorIndexByColor(color);
        move = "" + positionUtils.getXPositionByIndex(moveForX) + moveForY;
        potentialMoves.add(move);

        if (positionY == 2 && positionUtils.getColorIndexByColor(color) == 1) {
            moveForY = positionY + 2 * positionUtils.getColorIndexByColor(color);
            move = "" + positionUtils.getXPositionByIndex(moveForX) + moveForY;
            potentialMoves.add(move);
        }
        if (positionY == 7 && positionUtils.getColorIndexByColor(color) == -1) {
            moveForY = positionY + 2 * positionUtils.getColorIndexByColor(color);
            move = "" + positionUtils.getXPositionByIndex(moveForX) + moveForY;
            potentialMoves.add(move);
        }
        potentialMoves.remove(position);
        return potentialMoves;
    }
}
