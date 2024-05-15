package com.ac.simulator.domains;

import com.ac.simulator.constants.LandType;
import com.ac.simulator.exceptions.InvalidLandTypeException;
import com.ac.simulator.exceptions.InvalidSitemapException;
import com.ac.simulator.exceptions.LandNotFoundException;
import com.ac.simulator.exceptions.ReservedTreeClearingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SiteMapTest {


    @DisplayName("When fieldmap is not rectangle then should throw exception")
    @Test
    public void whenFieldmapIsNotRectangleThenShouldThrowException(){
        //arrange
        List<String> data = List.of("oo","oooo");

        //act
        //assert
        assertThrows(InvalidSitemapException.class, ()->new SiteMap(data));

    }

    @DisplayName("When fieldmap contains invalid land then should throw exception")
    @Test
    public void whenFieldmapContainsInvalidLandThenShouldThrowException(){
        //arrange
        List<String> data = List.of("oo","ww");

        //act
        //assert
        assertThrows(InvalidLandTypeException.class, ()->new SiteMap(data));
    }

    @DisplayName("When fieldmap id valid then should create fieldmap")
    @Test
    public void whenFieldmapValidLandThenShouldCreateFieldmap() throws InvalidLandTypeException, InvalidSitemapException, LandNotFoundException {
        //arrange
        List<String> data = List.of("or","tT");

        //act
        SiteMap siteMap = new SiteMap(data);

        //assert
        assertEquals(LandType.PLAIN_LAND, siteMap.getLand(0,0).getLandType());
        assertEquals(LandType.ROCKY_LAND, siteMap.getLand(0,1).getLandType());
        assertEquals(LandType.TREE, siteMap.getLand(1,0).getLandType());
        assertEquals(LandType.RESERVED_TREE, siteMap.getLand(1,1).getLandType());
    }

    @DisplayName("When get land called with invalid then should throw exception")
    @Test
    public void whenGetLandCalledWithOutsideBoundary() throws InvalidLandTypeException, InvalidSitemapException {
        //arrange
        List<String> data = List.of("or","tT");

        //act
        SiteMap siteMap = new SiteMap(data);

        //assert
        assertThrows(LandNotFoundException.class, () -> siteMap.getLand(0,2));
    }

    @DisplayName("When get uncleared count called should return only uncleared non reserved tree land")
    @Test
    public void whenGetUnclearedCountCalledWithOutsideBoundary() throws InvalidLandTypeException, InvalidSitemapException, LandNotFoundException, ReservedTreeClearingException {
        //arrange
        List<String> data = List.of("or","tT");
        SiteMap siteMap = new SiteMap(data);
        siteMap.getLand(0,0).clear();

        //act
        int count = siteMap.getUnclearedNonReservedTreeLandCount();

        //assert
        assertEquals(2, count);
    }
}
