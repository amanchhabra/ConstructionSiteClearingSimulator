package com.ac.simulator.domains.lands;

import com.ac.simulator.constants.LandType;
import com.ac.simulator.exceptions.ReservedTreeClearingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LandTest {

    @DisplayName("when Land is not cleared then isUncleared should return true")
    @Test
    public void whenLandNotUnclearedThenReturnTrue(){
        //arrange
        Land land = new Land() {
            @Override
            public LandType getLandType() {
                return null;
            }
        };

        // act
        boolean isUncleared = land.isUncleared();

        //assert
        assertTrue(isUncleared);
    }

    @DisplayName("when Land is cleared then isUncleared should return false")
    @Test
    public void whenLandClearedThenReturnFalse() throws ReservedTreeClearingException {
        //arrange
        Land land = new Land() {
            @Override
            public LandType getLandType() {
                return null;
            }
        };

        // act
        land.clear();
        boolean isUncleared = land.isUncleared();

        //assert
        assertFalse(isUncleared);
    }
}
