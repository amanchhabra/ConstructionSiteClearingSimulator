package com.ac.simulator.domains.lands;

import com.ac.simulator.constants.LandType;
import com.ac.simulator.exceptions.ReservedTreeClearingException;

/**
 * Land abstract class. Every child class need to implement
 * 1. getLandType - To retrieve the type of land
 */
public abstract class Land {
    public abstract LandType getLandType();

    private boolean uncleared = true;

    public void clear() throws ReservedTreeClearingException {
        uncleared = false;
    }

    public boolean isUncleared() {
        return uncleared;
    }
}
