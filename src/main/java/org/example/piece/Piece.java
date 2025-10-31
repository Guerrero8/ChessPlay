package org.example.piece;

import lombok.Data;
import lombok.NonNull;
import org.example.Player;
import org.example.Position;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public abstract class Piece {
    private final String id;
    private final String type;
    private final Player owner;
    private final Color color;
    private int hp;
    private int maxHp;
    private int armour;
    private int shield;
    private int maxShield;
    private int damage;
    private final String texturePath = "src/main/resources/org/example/texture/King.png";

    protected Piece(String type, Player owner, Color color, int maxHp, int armour, int maxShield, int damage) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.owner = owner;
        this.color = color;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.armour = armour;
        this.maxShield = maxShield;
        this.shield = maxShield;
        this.damage = damage;
    }

    public void die(){
        this.hp = 0;
    }

    public boolean isAlive() {
        return hp > 0;
    }
    public void restoreShield(){
        this.shield = this.maxShield;
    }

    public void takeDamage(int damage){
        if (damage <= 0){
            return;
        } else {
            damage = Math.max(damage - armour, 0);
        }
        int absorbedByShield = Math.min(shield, damage);
        shield -= absorbedByShield;
        damage -= absorbedByShield;
        if (damage > 0) {
            hp = Math.max(hp - damage, 0);
        }
    }

    public void regenerateLife (int heal){
        this.hp = Math.min(this.hp + heal, this.maxHp);
    }

    public abstract List<Position> getAvailableMoves(@NonNull Position positionFrom);

    public boolean makeMove(Player player, Position positionFrom, Position positionTo){
        List<Position> availableMoves = new ArrayList<>(getAvailableMoves(positionFrom));
        return availableMoves.contains(positionTo);
    }

    @Override
    public String toString() {
        return "Piece{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", color=" + color +
                ", hp=" + hp +
                ", maxHp=" + maxHp +
                ", armour=" + armour +
                ", shield=" + shield +
                ", maxShield=" + maxShield +
                ", damage=" + damage +
                '}';
    }
}
