package com.ac.simulator.domains;

import com.ac.simulator.constants.Direction;
import com.ac.simulator.constants.FuelConsumption;
import com.ac.simulator.constants.LandType;
import com.ac.simulator.domains.lands.Land;
import com.ac.simulator.exceptions.ReservedTreeClearingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BulldozerTest {

    @DisplayName("Bulldozer starts from the left of top left")
    @Test
    public void bulldozerStartsFromTheLeftOfTopLeft(){
        //arrange
        Bulldozer bulldozer = new Bulldozer();

        //act
        //assert
        assertEquals(0, bulldozer.getPosX());
        assertEquals(-1, bulldozer.getPosY());
    }

    @DisplayName("turnLeft when direction is east then direction is north")
    @Test
    public void turnLeftWhenEastThenNorth() {
        //arrange
        Bulldozer bulldozer = new Bulldozer();
        int initialX = bulldozer.getPosX();
        int initialY = bulldozer.getPosY();

        //act
        bulldozer.turnLeft();

        //assert
        assertEquals(initialX + Direction.NORTH.getX(), bulldozer.getNextPosX());
        assertEquals(initialY + Direction.NORTH.getY(), bulldozer.getNextPosY());
    }

    @DisplayName("turnLeft when direction is north then direction is west")
    @Test
    public void turnLeftWhenNorthThenWest() {
        //arrange
        Bulldozer bulldozer = new Bulldozer();
        int initialX = bulldozer.getPosX();
        int initialY = bulldozer.getPosY();
        bulldozer.setDirection(Direction.NORTH);

        //act
        bulldozer.turnLeft();

        //assert
        assertEquals(initialX + Direction.WEST.getX(), bulldozer.getNextPosX());
        assertEquals(initialY + Direction.WEST.getY(), bulldozer.getNextPosY());
    }

    @DisplayName("turnLeft when direction is west then direction is south")
    @Test
    public void turnLeftWhenWestThenSouth() {
        //arrange
        Bulldozer bulldozer = new Bulldozer();
        int initialX = bulldozer.getPosX();
        int initialY = bulldozer.getPosY();
        bulldozer.setDirection(Direction.WEST);

        //act
        bulldozer.turnLeft();

        //assert
        assertEquals(initialX + Direction.SOUTH.getX(), bulldozer.getNextPosX());
        assertEquals(initialY + Direction.SOUTH.getY(), bulldozer.getNextPosY());
    }

    @DisplayName("turnLeft when direction is south then direction is east")
    @Test
    public void turnLeftWhenSouthThenEast() {
        //arrange
        Bulldozer bulldozer = new Bulldozer();
        int initialX = bulldozer.getPosX();
        int initialY = bulldozer.getPosY();
        bulldozer.setDirection(Direction.SOUTH);

        //act
        bulldozer.turnLeft();

        //assert
        assertEquals(initialX + Direction.EAST.getX(), bulldozer.getNextPosX());
        assertEquals(initialY + Direction.EAST.getY(), bulldozer.getNextPosY());
    }

    @DisplayName("turnRight when direction is east then direction is south")
    @Test
    public void turnRightWhenEastThenSouth() {
        //arrange
        Bulldozer bulldozer = new Bulldozer();
        int initialX = bulldozer.getPosX();
        int initialY = bulldozer.getPosY();
        bulldozer.setDirection(Direction.EAST);

        //act
        bulldozer.turnRight();

        //assert
        assertEquals(initialX + Direction.SOUTH.getX(), bulldozer.getNextPosX());
        assertEquals(initialY + Direction.SOUTH.getY(), bulldozer.getNextPosY());
    }

    @DisplayName("turnRight when direction is south then direction is west")
    @Test
    public void turnRightWhenSouthThanWest() {
        //arrange
        Bulldozer bulldozer = new Bulldozer();
        int initialX = bulldozer.getPosX();
        int initialY = bulldozer.getPosY();
        bulldozer.setDirection(Direction.SOUTH);

        //act
        bulldozer.turnRight();

        //assert
        assertEquals(initialX + Direction.WEST.getX(), bulldozer.getNextPosX());
        assertEquals(initialY + Direction.WEST.getY(), bulldozer.getNextPosY());
    }

    @DisplayName("turnRight when direction is west then direction is north")
    @Test
    public void turnRightWhenWestThanNorth() {
        //arrange
        Bulldozer bulldozer = new Bulldozer();
        int initialX = bulldozer.getPosX();
        int initialY = bulldozer.getPosY();
        bulldozer.setDirection(Direction.WEST);

        //act
        bulldozer.turnRight();

        //assert
        assertEquals(initialX + Direction.NORTH.getX(), bulldozer.getNextPosX());
        assertEquals(initialY + Direction.NORTH.getY(), bulldozer.getNextPosY());
    }

    @DisplayName("turnRight when direction is north then direction is east")
    @Test
    public void turnRightWhenNorthThanEast() {
        //arrange
        Bulldozer bulldozer = new Bulldozer();
        int initialX = bulldozer.getPosX();
        int initialY = bulldozer.getPosY();
        bulldozer.setDirection(Direction.NORTH);

        //act
        bulldozer.turnRight();

        //assert
        assertEquals(initialX + Direction.EAST.getX(), bulldozer.getNextPosX());
        assertEquals(initialY + Direction.EAST.getY(), bulldozer.getNextPosY());
    }

    @DisplayName("advance should move one step in current direction")
    @Test
    public void advanceShouldMoveOneStepInCurrentDirection() throws ReservedTreeClearingException {
        //arrange
        Bulldozer bulldozer = new Bulldozer();
        int initialX = bulldozer.getPosX();
        int initialY = bulldozer.getPosY();
        Land land = mock(Land.class);
        when(land.getLandType()).thenReturn(LandType.PLAIN_LAND);

        //act
        bulldozer.advance(land, true);

        //assert
        assertEquals(initialX + Direction.EAST.getX(), bulldozer.getPosX());
        assertEquals(initialY + Direction.EAST.getY(), bulldozer.getPosY());
    }

    @DisplayName("advance should clear land")
    @Test
    public void advanceShouldClearLand() throws ReservedTreeClearingException {
        //arrange
        Bulldozer bulldozer = new Bulldozer();
        int initialX = bulldozer.getPosX();
        int initialY = bulldozer.getPosY();
        Land land = mock(Land.class);
        when(land.getLandType()).thenReturn(LandType.PLAIN_LAND);

        //act
        bulldozer.advance(land, true);

        //assert
        verify(land, times(1)).clear();
    }

    @DisplayName("advance should spend right fuel when plain land")
    @Test
    public void advanceShouldSpendRightFuelWhenPlainLand() throws ReservedTreeClearingException {
        //arrange
        Bulldozer bulldozer = new Bulldozer();
        int initialX = bulldozer.getPosX();
        int initialY = bulldozer.getPosY();
        Land land = mock(Land.class);
        when(land.getLandType()).thenReturn(LandType.PLAIN_LAND);

        //act
        bulldozer.advance(land, true);

        //assert
        assertEquals(FuelConsumption.CLEARING_PLAIN_LAND.getFuelConsumption(), bulldozer.getFuelConsumption());
    }

    @DisplayName("advance should spend right fuel when uncleared rocky land")
    @Test
    public void advanceShouldSpendRightFuelWhenUnclearedRockyLand() throws ReservedTreeClearingException {
        //arrange
        Bulldozer bulldozer = new Bulldozer();
        Land land = mock(Land.class);
        when(land.getLandType()).thenReturn(LandType.ROCKY_LAND);
        when(land.isUncleared()).thenReturn(true);

        //act
        bulldozer.advance(land, true);

        //assert
        assertEquals(FuelConsumption.CLEARING_ROCKY_LAND.getFuelConsumption(), bulldozer.getFuelConsumption());
    }

    @DisplayName("advance should spend right fuel when cleared rocky land")
    @Test
    public void advanceShouldSpendRightFuelWhenClearedRockyLand() throws ReservedTreeClearingException {
        //arrange
        Bulldozer bulldozer = new Bulldozer();
        Land land = mock(Land.class);
        when(land.getLandType()).thenReturn(LandType.ROCKY_LAND);
        when(land.isUncleared()).thenReturn(false);

        //act
        bulldozer.advance(land, true);

        //assert
        assertEquals(FuelConsumption.VISITING_CLEARED_LAND.getFuelConsumption(), bulldozer.getFuelConsumption());
    }

    @DisplayName("advance should spend right fuel when uncleared tree land")
    @Test
    public void advanceShouldSpendRightFuelWhenUnclearedTreeLand() throws ReservedTreeClearingException {
        //arrange
        Bulldozer bulldozer = new Bulldozer();
        Land land = mock(Land.class);
        when(land.getLandType()).thenReturn(LandType.TREE);
        when(land.isUncleared()).thenReturn(true);

        //act
        bulldozer.advance(land, true);

        //assert
        assertEquals(FuelConsumption.CLEARING_TREE.getFuelConsumption(), bulldozer.getFuelConsumption());
    }

    @DisplayName("advance should spend right fuel when cleared tree land")
    @Test
    public void advanceShouldSpendRightFuelWhenClearedTreeLand() throws ReservedTreeClearingException {
        //arrange
        Bulldozer bulldozer = new Bulldozer();
        Land land = mock(Land.class);
        when(land.getLandType()).thenReturn(LandType.TREE);
        when(land.isUncleared()).thenReturn(false);

        //act
        bulldozer.advance(land, true);

        //assert
        assertEquals(FuelConsumption.VISITING_CLEARED_LAND.getFuelConsumption(), bulldozer.getFuelConsumption());
    }

    @DisplayName("advance should add paint damage when uncleared tree and not stopping ")
    @Test
    public void advanceShouldAddPaintDamageWhenUnclearedTreeAndNotStopping() throws ReservedTreeClearingException {
        //arrange
        Bulldozer bulldozer = new Bulldozer();
        Land land = mock(Land.class);
        when(land.getLandType()).thenReturn(LandType.TREE);
        when(land.isUncleared()).thenReturn(true);

        //act
        bulldozer.advance(land, false);

        //assert
        assertEquals(1, bulldozer.getPaintDamage());
    }

    @DisplayName("advance should not add paint damage when cleared tree and not stopping ")
    @Test
    public void advanceShouldNotAddPaintDamageWhenClearedTreeAndNotStopping() throws ReservedTreeClearingException {
        //arrange
        Bulldozer bulldozer = new Bulldozer();
        Land land = mock(Land.class);
        when(land.getLandType()).thenReturn(LandType.TREE);
        when(land.isUncleared()).thenReturn(false);

        //act
        bulldozer.advance(land, false);

        //assert
        assertEquals(0, bulldozer.getPaintDamage());
    }

    @DisplayName("advance should not add paint damage when uncleared tree and stopping ")
    @Test
    public void advanceShouldNotAddPaintDamageWhenUnclearedTreeAndStopping() throws ReservedTreeClearingException {
        //arrange
        Bulldozer bulldozer = new Bulldozer();
        Land land = mock(Land.class);
        when(land.getLandType()).thenReturn(LandType.TREE);
        when(land.isUncleared()).thenReturn(true);

        //act
        bulldozer.advance(land, true);

        //assert
        assertEquals(0, bulldozer.getPaintDamage());
    }

    @DisplayName("advance should not add paint damage when cleared tree and stopping ")
    @Test
    public void advanceShouldNotAddPaintDamageWhenClearedTreeAndStopping() throws ReservedTreeClearingException {
        //arrange
        Bulldozer bulldozer = new Bulldozer();
        Land land = mock(Land.class);
        when(land.getLandType()).thenReturn(LandType.TREE);
        when(land.isUncleared()).thenReturn(false);

        //act
        bulldozer.advance(land, true);

        //assert
        assertEquals(0, bulldozer.getPaintDamage());
    }
}
