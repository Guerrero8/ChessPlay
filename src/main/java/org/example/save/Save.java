package org.example.save;

import lombok.Data;
import org.example.Player;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Save implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String saveName;
    private Player player;

    public Save(String saveName, Player player){
        this.saveName = saveName;
        this.player = player;
    }
}
