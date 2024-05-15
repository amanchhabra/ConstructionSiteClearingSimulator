package com.ac.simulator.domains.lands.impl;

import com.ac.simulator.constants.LandType;
import com.ac.simulator.domains.lands.Land;

/**
 * Land with tree
 */
public class TreeLand extends Land {
    private static final LandType landType = LandType.TREE;

    @Override
    public LandType getLandType() {
        return landType;
    }
}
