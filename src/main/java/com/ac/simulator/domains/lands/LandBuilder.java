package com.ac.simulator.domains.lands;

import com.ac.simulator.constants.LandType;
import com.ac.simulator.domains.lands.impl.PlainLand;
import com.ac.simulator.domains.lands.impl.ReservedTreeLand;
import com.ac.simulator.domains.lands.impl.RockyLand;
import com.ac.simulator.domains.lands.impl.TreeLand;
import com.ac.simulator.exceptions.InvalidLandTypeException;

/**
 * Land builder to create land of different land types
 */
public class LandBuilder {

    public static Land createLand(String symbol) throws InvalidLandTypeException {
        return switch (LandType.getLandType(symbol).orElseThrow(InvalidLandTypeException::new)) {
            case PLAIN_LAND -> new PlainLand();
            case ROCKY_LAND -> new RockyLand();
            case TREE -> new TreeLand();
            case RESERVED_TREE -> new ReservedTreeLand();
        };
    }
}
