package org.example.piece;

import java.util.List;

public interface Piece {
    String getColor();
    void setColor(String color);
    List<String> getPotentialMoves(String position) throws Exception;
}
