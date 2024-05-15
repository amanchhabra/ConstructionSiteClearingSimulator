package com.ac.simulator.domains.lands.impl;

import com.ac.simulator.constants.LandType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RockyLandTest {

    @DisplayName("When get land type then returns rocky land type")
    @Test
    public void whenGetLandTypeThenReturnsRockyLandType() {
        //arrange
        RockyLand rockyLand = new RockyLand();

        //act
        LandType landType = rockyLand.getLandType();

        //assert
        assertEquals(LandType.ROCKY_LAND, landType);
    }
}
