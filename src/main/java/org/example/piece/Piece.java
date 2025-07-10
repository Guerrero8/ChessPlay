package org.example.piece;

import java.util.List;

public interface Piece {
    void setColor(String color);
    List<String> getPotentialMoves(String position) throws Exception;
}
