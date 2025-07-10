package org.example.piece;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.PositionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@NoArgsConstructor
public class King implements Piece{
    String color = "White";
    boolean canBypass = false;

    public King(String color){
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
        for (int i = -1; i < 2; i++) {
            moveForY = positionY + 1;
            moveForX = positionX + i;
            move = "" + positionUtils.getXPositionByIndex(moveForX) + moveForY;
            potentialMoves.add(move);
        }
        for (int i = -1; i < 2; i++) {
            moveForY = positionY;
            moveForX = positionX + i;
            move = "" + positionUtils.getXPositionByIndex(moveForX) + moveForY;
            potentialMoves.add(move);
        }
        for (int i = -1; i < 2; i++) {
            moveForY = positionY - 1;
            moveForX = positionX + i;
            move = "" + positionUtils.getXPositionByIndex(moveForX) + moveForY;
            potentialMoves.add(move);
        }
        potentialMoves.remove(position);
        return potentialMoves;
    }
}
