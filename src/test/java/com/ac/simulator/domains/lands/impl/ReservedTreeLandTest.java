package com.ac.simulator.domains.lands.impl;

import com.ac.simulator.constants.LandType;
import com.ac.simulator.exceptions.ReservedTreeClearingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReservedTreeLandTest {

    @DisplayName("When clear reserved tree land then throw exception")
    @Test
    public void whenClearReservedTreeThenThrowException() {
        //arrange
        ReservedTreeLand reservedTreeLand = new ReservedTreeLand();

        //act assert
        assertThrows(ReservedTreeClearingException.class, reservedTreeLand::clear);
    }

    @DisplayName("When get land type then returns reserved land type")
    @Test
    public void whenGetLandTypeThenReturnsPlainLandType() {
        //arrange
        ReservedTreeLand reservedTreeLand = new ReservedTreeLand();

        //act
        LandType landType = reservedTreeLand.getLandType();

        //assert
        assertEquals(LandType.RESERVED_TREE, landType);
    }
}
