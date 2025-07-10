package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class PositionUtils {
    static final Map<Character, Integer> letterСoordinate = Map.of(
            'a', 1,
            'b', 2,
            'c', 3,
            'd', 4,
            'e', 5,
            'f', 6,
            'g', 7,
            'h', 8);

    private String getKeyByValue(int value) {
        for (Map.Entry<Character, Integer> entry : letterСoordinate.entrySet()) {
            if (entry.getValue() == value)
                return entry.getKey().toString();
        }
        return null;
    }


    public int getColorIndexByColor(@NotNull String color) throws Exception {
        switch (color) {
            case "White":
                return 1;
            case "Black":
                return -1;
            default:
                throw new Exception("Color????");
        }
    }

    public int getXPositionIndexByPosition(String position) {
        return letterСoordinate.get(position.charAt(0));
    }

    public String getXPositionByIndex(int index) {
        return getKeyByValue(index);
    }

    public int getYPositionByPosition(String position) {
        return Character.getNumericValue(position.charAt(1));
    }

}
