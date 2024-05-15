package com.ac.simulator.domains.lands.impl;

import com.ac.simulator.constants.LandType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeLandTest {

    @DisplayName("When get land type then returns tree land type")
    @Test
    public void whenGetLandTypeThenReturnsTreeLandType() {
        //arrange
        TreeLand treeLand = new TreeLand();

        //act
        LandType landType = treeLand.getLandType();

        //assert
        assertEquals(LandType.TREE, landType);
    }
}
