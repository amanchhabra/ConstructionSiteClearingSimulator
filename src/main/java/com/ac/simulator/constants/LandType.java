package com.ac.simulator.constants;

import java.util.Arrays;
import java.util.Optional;

/**
 * Type of land
 */
public enum LandType {
    PLAIN_LAND("o"),
    ROCKY_LAND("r"),
    TREE("t"),
    RESERVED_TREE("T");

    private final String symbol;

    LandType(String symbol) {
        this.symbol = symbol;
    }

    public static Optional<LandType> getLandType(String symbol) {
        return Arrays.stream(LandType.values()).filter(land -> land.symbol.equals(symbol)).findFirst();
    }

    public String getSymbol() {
        return symbol;
    }
}
