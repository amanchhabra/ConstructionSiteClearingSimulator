package com.ac.simulator.domains.lands.impl;

import com.ac.simulator.constants.LandType;
import com.ac.simulator.domains.lands.Land;

/**
 * Rocky Land
 */
public class RockyLand extends Land {
    private static final LandType landType = LandType.ROCKY_LAND;

    @Override
    public LandType getLandType() {
        return landType;
    }
}
