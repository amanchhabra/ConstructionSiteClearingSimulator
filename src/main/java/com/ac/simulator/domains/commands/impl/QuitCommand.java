package com.ac.simulator.domains.commands.impl;

import com.ac.simulator.constants.CommandType;
import com.ac.simulator.domains.Bulldozer;
import com.ac.simulator.domains.SiteMap;
import com.ac.simulator.domains.commands.Command;

/**
 * Quit Command to quit the application
 */
public class QuitCommand implements Command {
    @Override
    public void execute(Bulldozer bulldozer, SiteMap siteMap) {

    }

    @Override
    public CommandType getCommandType() {
        return CommandType.QUIT;
    }

    @Override
    public String toString() {
        return "quit";
    }
}
