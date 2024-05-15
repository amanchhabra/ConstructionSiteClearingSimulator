package com.ac.simulator.domains.commands.impl;

import com.ac.simulator.constants.CommandType;
import com.ac.simulator.domains.Bulldozer;
import com.ac.simulator.domains.SiteMap;
import com.ac.simulator.domains.commands.Command;

/**
 * Left Command to move the bulldozer to the left
 */
public class LeftCommand implements Command {
    @Override
    public void execute(Bulldozer bulldozer, SiteMap siteMap) {
        bulldozer.turnLeft();
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.LEFT;
    }

    @Override
    public String toString() {
        return "turn left";
    }
}
