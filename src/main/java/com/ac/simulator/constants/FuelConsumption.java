package com.ac.simulator.constants;

/**
 * Fuel consumption per land
 */
public enum FuelConsumption {
    CLEARING_PLAIN_LAND(1),
    VISITING_CLEARED_LAND(1),
    CLEARING_ROCKY_LAND(2),
    CLEARING_TREE(2);

    private final int fuelConsumption;

    FuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }
}
