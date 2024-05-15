package com.ac.simulator.domains.commands.impl;

import com.ac.simulator.constants.CommandType;
import com.ac.simulator.domains.Bulldozer;
import com.ac.simulator.domains.SiteMap;
import com.ac.simulator.domains.commands.Command;
import com.ac.simulator.domains.lands.Land;
import com.ac.simulator.exceptions.LandNotFoundException;
import com.ac.simulator.exceptions.ReservedTreeClearingException;

/**
 * Advance Command is the command to move the bulldozer forward in the current direction.
 * This will also detect any paint damages and any removal of reserved trees
 */
public class AdvanceCommand implements Command {

    private final int steps;

    public AdvanceCommand(int steps) {
        this.steps = steps;
    }

    @Override
    public void execute(Bulldozer bulldozer, SiteMap siteMap) throws ReservedTreeClearingException, LandNotFoundException {
        for (int i = 0; i < this.steps; i++) {
            Land land = siteMap.getLand(bulldozer.getNextPosX(), bulldozer.getNextPosY());
            boolean isStopping = i == (this.steps - 1);
            bulldozer.advance(land, isStopping);
        }
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.ADVANCE;
    }

    @Override
    public String toString() {
        return "advance " + this.steps;
    }
}
