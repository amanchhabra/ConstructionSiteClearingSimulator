package com.ac.simulator.constants;

/**
 * Cost associated with different actions
 */
public enum Cost {
    COMMUNICATION(1),
    FUEL_PER_UNIT(1),
    UNCLEARED_SQUARE(3),
    DESTRUCTION_PROTECTED_TREE(10),
    REPAIRING_PAINT_DAMAGE(2);

    private final int cost;

    Cost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
