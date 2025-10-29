package org.example;

import lombok.Data;
import org.example.piece.Piece;

import java.util.ArrayList;
import java.util.List;

@Data
public class Player {
    private final String name;
    private final Board board;
    private int action;
    private int maxAction;
    private final List<Piece> activePieces;
    private final List<Piece> reservePieces;
    private int coins;
    private int boardHealth;

    public Player(String name) {
        this.name = name;
        this.board = new Board();
        this.maxAction = 1;
        this.action = maxAction;
        this.activePieces = new ArrayList<>();
        this.reservePieces = new ArrayList<>();
        this.coins = 10;
        this.boardHealth = 3;
    }

    public void addActivePiece(Piece piece) {
        activePieces.add(piece);
    }

    public void removeActivePiece(Piece piece) {
        activePieces.remove(piece);
    }
    public void addReservePiece(Piece piece) {
        reservePieces.add(piece);
    }

    public void removeReservePiece(Piece piece) {
        reservePieces.remove(piece);
    }
    public void moveActiveToReserve(Piece piece){
        removeActivePiece(piece);
        addReservePiece(piece);
    }
    public void moveReserveToActive(Piece piece){
        removeReservePiece(piece);
        addActivePiece(piece);
    }

}
