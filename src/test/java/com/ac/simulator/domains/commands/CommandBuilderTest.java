package com.ac.simulator.domains.commands;

import com.ac.simulator.constants.CommandType;
import com.ac.simulator.exceptions.InvalidCommandException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandBuilderTest {

    @DisplayName("When Left Command String is passed builder creates Left Command")
    @Test
    public void whenLeftStringPassedCreatesLeftCommand() throws InvalidCommandException {
        //arrange
        String commandStr = "Left";

        //act
        Command command = CommandBuilder.createCommand(commandStr);

        //assert
        assertTrue(command.getCommandType().equals(CommandType.LEFT));
    }

    @DisplayName("When Left Initial (l) String is passed builder creates Left Command")
    @Test
    public void whenLeftInitialStringPassedCreatesLeftCommand() throws InvalidCommandException {
        //arrange
        String commandStr = "L";

        //act
        Command command = CommandBuilder.createCommand(commandStr);

        //assert
        assertTrue(command.getCommandType().equals(CommandType.LEFT));
    }

    @DisplayName("When Right Command String is passed builder creates Right Command")
    @Test
    public void whenRightStringPassedCreatesRightCommand() throws InvalidCommandException {
        //arrange
        String commandStr = "Right";

        //act
        Command command = CommandBuilder.createCommand(commandStr);

        //assert
        assertTrue(command.getCommandType().equals(CommandType.RIGHT));
    }

    @DisplayName("When Right Initial (r) String is passed builder creates Right Command")
    @Test
    public void whenRightInitialStringPassedCreatesRightCommand() throws InvalidCommandException {
        //arrange
        String commandStr = "R";

        //act
        Command command = CommandBuilder.createCommand(commandStr);

        //assert
        assertTrue(command.getCommandType().equals(CommandType.RIGHT));
    }

    @DisplayName("When Advance Command String is passed builder creates Advance Command")
    @Test
    public void whenAdvanceStringPassedCreatesAdvanceCommand() throws InvalidCommandException {
        //arrange
        String commandStr = "Advance 4";

        //act
        Command command = CommandBuilder.createCommand(commandStr);

        //assert
        assertTrue(command.getCommandType().equals(CommandType.ADVANCE));
    }

    @DisplayName("When Advance Initial (a) String is passed builder creates Advance Command")
    @Test
    public void whenAdvanceInitialStringPassedCreatesAdvanceCommand() throws InvalidCommandException {
        //arrange
        String commandStr = "a 4";

        //act
        Command command = CommandBuilder.createCommand(commandStr);

        //assert
        assertTrue(command.getCommandType().equals(CommandType.ADVANCE));
    }

    @DisplayName("When steps are negative in advance command builder throws exception")
    @Test
    public void whenStepsNegativeInAdvanceCommandThrowException() {
        //arrange
        String commandStr = "a -1";

        //act and assert
        assertThrows(InvalidCommandException.class,() -> CommandBuilder.createCommand(commandStr));
    }

    @DisplayName("When steps are invalid number in advance command builder throws exception")
    @Test
    public void whenStepsInvalidNumberInAdvanceCommandThrowException() {
        //arrange
        String commandStr = "a a";

        //act and assert
        assertThrows(InvalidCommandException.class,() -> CommandBuilder.createCommand(commandStr));
    }

    @DisplayName("When steps not provided in advance command builder throws exception")
    @Test
    public void whenStepsNotProvidedInAdvanceCommandThrowException() {
        //arrange
        String commandStr = "a";

        //act and assert
        assertThrows(InvalidCommandException.class,() -> CommandBuilder.createCommand(commandStr));
    }

    @DisplayName("When Quit Command String is passed builder creates Quit Command")
    @Test
    public void whenQuitStringPassedCreatesQuitCommand() throws InvalidCommandException {
        //arrange
        String commandStr = "Quit";

        //act
        Command command = CommandBuilder.createCommand(commandStr);

        //assert
        assertTrue(command.getCommandType().equals(CommandType.QUIT));
    }

    @DisplayName("When Quit Initial (q) String is passed builder creates Quit Command")
    @Test
    public void whenQuitInitialStringPassedCreatesQuitCommand() throws InvalidCommandException {
        //arrange
        String commandStr = "Q";

        //act
        Command command = CommandBuilder.createCommand(commandStr);

        //assert
        assertTrue(command.getCommandType().equals(CommandType.QUIT));
    }

    @DisplayName("When invalid command builder throws exception")
    @Test
    public void whenInvalidCommandCommandThrowException() {
        //arrange
        String commandStr = "a 2 2";

        //act and assert
        assertThrows(InvalidCommandException.class,() -> CommandBuilder.createCommand(commandStr));
    }
}
