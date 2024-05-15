package com.ac.simulator.domains;

import com.ac.simulator.constants.Direction;
import com.ac.simulator.constants.FuelConsumption;
import com.ac.simulator.domains.lands.Land;
import com.ac.simulator.exceptions.ReservedTreeClearingException;

import static com.ac.simulator.constants.LandType.TREE;

/**
 * Bulldozer class.
 * This class allows various actions on bulldozer:
 * 1. Turn Left
 * 2. Turn Right
 * 3. Advance
 * 4. Spend Fuel
 * 5. Report Paint Damage
 */
public class Bulldozer {

    private Direction direction = Direction.EAST;

    private int posX = 0;
    private int posY = -1;

    private int fuelConsumption = 0;
    private int paintDamage;

    public void turnLeft() {
        switch (direction) {
            case EAST -> direction = Direction.NORTH;
            case NORTH -> direction = Direction.WEST;
            case WEST -> direction = Direction.SOUTH;
            case SOUTH -> direction = Direction.EAST;
        }
    }

    public void turnRight() {
        switch (direction) {
            case EAST -> direction = Direction.SOUTH;
            case SOUTH -> direction = Direction.WEST;
            case WEST -> direction = Direction.NORTH;
            case NORTH -> direction = Direction.EAST;
        }
    }

    public void advance(Land land, boolean isStopping) throws ReservedTreeClearingException {
        posX += direction.getX();
        posY += direction.getY();
        boolean isUncleared = land.isUncleared();

        spendFuel(land);
        land.clear();
        if (!isStopping && isUncleared && land.getLandType().equals(TREE)) {
            incrementPaintDamage();
        }
    }

    private void spendFuel(Land land) {
        int currentFuelConsumption = 0;
        switch (land.getLandType()) {
            case TREE -> currentFuelConsumption = land.isUncleared() ?
                    FuelConsumption.CLEARING_TREE.getFuelConsumption() :
                    FuelConsumption.VISITING_CLEARED_LAND.getFuelConsumption();
            case ROCKY_LAND -> currentFuelConsumption = land.isUncleared() ?
                    FuelConsumption.CLEARING_ROCKY_LAND.getFuelConsumption() :
                    FuelConsumption.VISITING_CLEARED_LAND.getFuelConsumption();
            case PLAIN_LAND -> currentFuelConsumption = FuelConsumption.CLEARING_PLAIN_LAND.getFuelConsumption();
        }
        this.fuelConsumption += currentFuelConsumption;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    private void incrementPaintDamage() {
        this.paintDamage += 1;
    }

    public int getPaintDamage() {
        return paintDamage;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getNextPosX() {
        return posX + direction.getX();
    }

    public int getNextPosY() {
        return posY + direction.getY();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
