package org.example.save;

import lombok.Data;
import org.example.Player;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Save implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Player player;

    public Save(Player player){
        this.player = player;
    }
}
