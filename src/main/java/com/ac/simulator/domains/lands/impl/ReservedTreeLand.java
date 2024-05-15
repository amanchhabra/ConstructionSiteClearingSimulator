package com.ac.simulator.domains.lands.impl;

import com.ac.simulator.constants.LandType;
import com.ac.simulator.domains.lands.Land;
import com.ac.simulator.exceptions.ReservedTreeClearingException;

/**
 * Land with reserved tree
 */
public class ReservedTreeLand extends Land {
    private static final LandType landType = LandType.RESERVED_TREE;

    @Override
    public void clear() throws ReservedTreeClearingException {
        throw new ReservedTreeClearingException();
    }

    @Override
    public LandType getLandType() {
        return landType;
    }
}
