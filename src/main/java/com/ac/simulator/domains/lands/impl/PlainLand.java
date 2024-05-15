package com.ac.simulator.domains.lands.impl;

import com.ac.simulator.constants.LandType;
import com.ac.simulator.domains.lands.Land;

/**
 * Plain Land
 */
public class PlainLand extends Land {
    private static final LandType landType = LandType.PLAIN_LAND;

    @Override
    public LandType getLandType() {
        return landType;
    }

}
