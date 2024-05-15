package com.ac.simulator.domains.commands.impl;

import com.ac.simulator.constants.CommandType;
import com.ac.simulator.domains.Bulldozer;
import com.ac.simulator.domains.SiteMap;
import com.ac.simulator.domains.commands.Command;

/**
 * Right command to move the bulldozer to right
 */
public class RightCommand implements Command {
    @Override
    public void execute(Bulldozer bulldozer, SiteMap siteMap) {
        bulldozer.turnRight();
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.RIGHT;
    }

    @Override
    public String toString() {
        return "turn right";
    }
}
