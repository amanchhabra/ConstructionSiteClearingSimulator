package com.ac.simulator;

import com.ac.simulator.exceptions.InvalidCommandException;
import com.ac.simulator.exceptions.InvalidLandTypeException;
import com.ac.simulator.exceptions.InvalidSitemapException;
import com.ac.simulator.utility.CommandLineUtility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.ac.simulator.constants.Message.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SimulatorEngineTest {



    @DisplayName("Start when called should load file and print start up message")
    @Test
    public void startWhenCalledShouldLoadFileAndPrintStartupMessage() throws InvalidCommandException, InvalidLandTypeException, InvalidSitemapException {
        //arrange
        CommandLineUtility commandLineUtility = mock(CommandLineUtility.class);
        SimulatorEngine simulatorEngine = new SimulatorEngine(commandLineUtility);
        when(commandLineUtility.takeInput()).thenReturn("q");

        //act
        simulatorEngine.start("src/test/resources/sitemaptest.txt");


        //assert
        verify(commandLineUtility,times(1)).printMessage(WELCOME_MESSAGE.getDescription());
        verify(commandLineUtility,times(1)).printMessage("o r \nt T \n");
        verify(commandLineUtility,times(1)).printMessage(COMMAND_INFO_MESSAGE.getDescription());
    }

    @DisplayName("Simulator exits if enters at a reserved tree land")
    @Test
    public void simulatorExitsIfPassThroughAReservedTreeLand() throws InvalidCommandException, InvalidLandTypeException, InvalidSitemapException {
        //arrange
        CommandLineUtility commandLineUtility = mock(CommandLineUtility.class);
        SimulatorEngine simulatorEngine = new SimulatorEngine(commandLineUtility);
        when(commandLineUtility.takeInput())
                .thenReturn("a 1")
                .thenReturn("r")
                .thenReturn("a 1")
                .thenReturn("l")
                .thenReturn("a 2");

        //act
        simulatorEngine.start("src/test/resources/sitemaptest.txt");

        //assert
        verify(commandLineUtility,times(1)).printMessage(STOP_MESSAGE.getDescription());
    }

    @DisplayName("Simulator exits if bulldozer exits boundary")
    @Test
    public void simulatorExitsIfBulldozerExitsBoundary() throws InvalidCommandException, InvalidLandTypeException, InvalidSitemapException {
        //arrange
        CommandLineUtility commandLineUtility = mock(CommandLineUtility.class);
        SimulatorEngine simulatorEngine = new SimulatorEngine(commandLineUtility);
        when(commandLineUtility.takeInput())
                .thenReturn("a 1")
                .thenReturn("r")
                .thenReturn("a 2");

        //act
        simulatorEngine.start("src/test/resources/sitemaptest.txt");

        //assert
        verify(commandLineUtility,times(1)).printMessage(STOP_MESSAGE.getDescription());
    }

    @DisplayName("Simulator exits when entered quit command")
    @Test
    public void simulatorExitsWhenEnteredQuitCommand() throws InvalidCommandException, InvalidLandTypeException, InvalidSitemapException {
        //arrange
        CommandLineUtility commandLineUtility = mock(CommandLineUtility.class);
        SimulatorEngine simulatorEngine = new SimulatorEngine(commandLineUtility);
        when(commandLineUtility.takeInput())
                .thenReturn("a 1")
                .thenReturn("r")
                .thenReturn("q");

        //act
        simulatorEngine.start("src/test/resources/sitemaptest.txt");

        //assert
        verify(commandLineUtility,times(1)).printMessage(STOP_MESSAGE.getDescription());
    }

    @DisplayName("Simulator prints complete cost details after exit")
    @Test
    public void simulatorPrintsCompleteCostDetailsAfterExit() throws InvalidCommandException, InvalidLandTypeException, InvalidSitemapException {
        //arrange
        CommandLineUtility commandLineUtility = mock(CommandLineUtility.class);
        SimulatorEngine simulatorEngine = new SimulatorEngine(commandLineUtility);
        when(commandLineUtility.takeInput())
                .thenReturn("a 1")
                .thenReturn("r")
                .thenReturn("a 1")
                .thenReturn("l")
                .thenReturn("a 1");

        //act
        simulatorEngine.start("src/test/resources/sitemaptest.txt");

        //assert
        verify(commandLineUtility,times(1)).printFormattedMessage(COST_DETAILS_COMMUNICATION_OVERHEAD_TEMPLATE.getDescription(),5,5);
        verify(commandLineUtility,times(1)).printFormattedMessage(COST_DETAILS_FUEL_USAGE_TEMPLATE.getDescription(),3,3);
        verify(commandLineUtility,times(1)).printFormattedMessage(COST_DETAILS_UNCLEARED_SQUARES_TEMPLATE.getDescription(),1,3);
        verify(commandLineUtility,times(1)).printFormattedMessage(COST_DETAILS_DESTRUCTION_PROTECTED_AREA_TEMPLATE.getDescription(),1,10);
        verify(commandLineUtility,times(1)).printFormattedMessage(COST_DETAILS_PAINT_DAMAGE_TEMPLATE.getDescription(),0,0);
        verify(commandLineUtility,times(1)).printFormattedMessage(COST_DETAILS_TOTAL_TEMPLATE.getDescription(),21);
    }
}
