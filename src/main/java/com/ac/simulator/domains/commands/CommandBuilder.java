package com.ac.simulator.domains.commands;

import com.ac.simulator.domains.commands.impl.AdvanceCommand;
import com.ac.simulator.domains.commands.impl.LeftCommand;
import com.ac.simulator.domains.commands.impl.QuitCommand;
import com.ac.simulator.domains.commands.impl.RightCommand;
import com.ac.simulator.exceptions.InvalidCommandException;

/**
 * Command builder to created commands of various command types
 */
public class CommandBuilder {
    public static Command createCommand(String commandString) throws InvalidCommandException {
        String[] commands = commandString.split(" ");
        switch (commands[0].toLowerCase()) {
            case "l":
            case "left":
                return new LeftCommand();
            case "r":
            case "right":
                return new RightCommand();
            case "a":
            case "advance":
                if (commands.length != 2) {
                    throw new InvalidCommandException();
                }
                try {
                    int steps = Integer.parseInt(commands[1]);
                    if (steps < 0) {
                        throw new InvalidCommandException();
                    }
                    return new AdvanceCommand(steps);
                } catch (NumberFormatException e) {
                    throw new InvalidCommandException();
                }
            case "q":
            case "quit":
                return new QuitCommand();
            default:
                throw new InvalidCommandException();
        }
    }
}
