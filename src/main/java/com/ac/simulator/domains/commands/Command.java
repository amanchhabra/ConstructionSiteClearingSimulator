package com.ac.simulator.domains.commands;

import com.ac.simulator.constants.CommandType;
import com.ac.simulator.domains.Bulldozer;
import com.ac.simulator.domains.SiteMap;
import com.ac.simulator.exceptions.LandNotFoundException;
import com.ac.simulator.exceptions.ReservedTreeClearingException;

/**
 * This is the command interface. Every child member need to support
 * 1. execute - This will be called to execute the command
 * 2. getCommandType - This will be called to retrieve the type of command
 */
public interface Command {
    void execute(Bulldozer bulldozer, SiteMap siteMap) throws ReservedTreeClearingException, LandNotFoundException;

    CommandType getCommandType();
}
