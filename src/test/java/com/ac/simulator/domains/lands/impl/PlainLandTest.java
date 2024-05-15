package com.ac.simulator.domains.lands.impl;

import com.ac.simulator.constants.LandType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlainLandTest {

    @DisplayName("When get land type then returns plain land type")
    @Test
    public void whenGetLandTypeThenReturnsPlainLandType() {
        //arrange
        PlainLand plainLand = new PlainLand();

        //act
        LandType landType = plainLand.getLandType();

        //assert
        assertEquals(LandType.PLAIN_LAND, landType);
    }
}
