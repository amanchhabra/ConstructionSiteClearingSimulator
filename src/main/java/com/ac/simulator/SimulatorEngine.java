package com.ac.simulator;

import com.ac.simulator.constants.CommandType;
import com.ac.simulator.constants.Cost;
import com.ac.simulator.constants.Message;
import com.ac.simulator.domains.Bulldozer;
import com.ac.simulator.domains.SiteMap;
import com.ac.simulator.domains.commands.Command;
import com.ac.simulator.domains.commands.CommandBuilder;
import com.ac.simulator.exceptions.*;
import com.ac.simulator.utility.CommandLineUtility;
import com.ac.simulator.utility.FileUtility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ac.simulator.constants.Message.*;

/**
 * Simulator Engine which can
 * 1. Start and load the sitemap file
 * 2. Take commands from console
 * 3. Stop and give cost analysis
 */
public class SimulatorEngine {

    private static SiteMap siteMap;

    private final CommandLineUtility commandLineUtility;

    private boolean isReservedTreeVisited = false;

    private final Bulldozer bulldozer = new Bulldozer();

    private final List<Command> commandsList = new ArrayList<>();

    Map<String,Integer> costDetails = new HashMap<>();

    public SimulatorEngine(CommandLineUtility commandLineUtility) {
        this.commandLineUtility = commandLineUtility;
    }

    public void start(String filename) throws InvalidSitemapException, InvalidLandTypeException, InvalidCommandException {
        loadSitemap(filename);
        printStartupMessage();
        takeCommands();
    }

    private void printStartupMessage() {
        commandLineUtility.printMessage(WELCOME_MESSAGE.getDescription());
        commandLineUtility.printMessage(siteMap.toString());
        commandLineUtility.printMessage(COMMAND_INFO_MESSAGE.getDescription());
    }

    private void takeCommands() throws InvalidCommandException {
        commandLineUtility.printMessage(COMMAND_LINE_MESSAGE.getDescription());
        Command command = CommandBuilder.createCommand(commandLineUtility.takeInput());
        commandsList.add(command);
        if (command.getCommandType() == CommandType.QUIT) {
            stop();
        } else {
            try {
                command.execute(bulldozer, siteMap);
                takeCommands();
            } catch (ReservedTreeClearingException e) {
                isReservedTreeVisited = true;
                stop();
            } catch (LandNotFoundException e) {
                stop();
            }
        }
    }

    private void stop() {
        commandLineUtility.printMessage(STOP_MESSAGE.getDescription());
        String cmdsStr = commandsList.stream().map(Object::toString).reduce((a, b) -> a + ", " + b).orElse("");
        commandLineUtility.printMessage(cmdsStr);
        commandLineUtility.printMessage(COST_MESSAGE.getDescription());
        calculateAndPrintCostDetails();
        commandLineUtility.printMessage(THANK_YOU_MESSAGE.getDescription());
    }

    private void calculateAndPrintCostDetails() {
        commandLineUtility.printMessage(COST_DETAILS_HEADING.getDescription());

        int communicationOverheadCost = getAndPrintCost(getCommunicationOverhead(), Cost.COMMUNICATION, COST_DETAILS_COMMUNICATION_OVERHEAD_TEMPLATE);
        int fuelUsageCost = getAndPrintCost(bulldozer.getFuelConsumption(), Cost.FUEL_PER_UNIT, COST_DETAILS_FUEL_USAGE_TEMPLATE);
        int unclearedSquaresCost = getAndPrintCost(siteMap.getUnclearedNonReservedTreeLandCount(), Cost.UNCLEARED_SQUARE, COST_DETAILS_UNCLEARED_SQUARES_TEMPLATE);
        int destructionProtectedTreeCost = getAndPrintCost(isReservedTreeVisited ? 1 : 0, Cost.DESTRUCTION_PROTECTED_TREE, COST_DETAILS_DESTRUCTION_PROTECTED_AREA_TEMPLATE);
        int paintDamageCost = getAndPrintCost(bulldozer.getPaintDamage(), Cost.REPAIRING_PAINT_DAMAGE, COST_DETAILS_PAINT_DAMAGE_TEMPLATE);
        int total = communicationOverheadCost + fuelUsageCost + unclearedSquaresCost + destructionProtectedTreeCost + paintDamageCost;

        commandLineUtility.printMessage(COST_DETAILS_SEPERATOR.getDescription());
        commandLineUtility.printFormattedMessage(COST_DETAILS_TOTAL_TEMPLATE.getDescription(),total);
    }

    private int getAndPrintCost(int usage, Cost cost, Message costDetailsFuelUsageTemplate) {
        int usageCost = usage * cost.getCost();
        commandLineUtility.printFormattedMessage(costDetailsFuelUsageTemplate.getDescription(), usage, usageCost);
        return usageCost;
    }

    private int getCommunicationOverhead() {
        return (int) commandsList.stream().filter(command -> command.getCommandType() != CommandType.QUIT).count();
    }

    private void loadSitemap(String filename) throws InvalidLandTypeException, InvalidSitemapException {
        try {
            List<String> sitemapData = FileUtility.loadFile(filename);
            siteMap = new SiteMap(sitemapData);
        } catch (InvalidFileException e) {
            throw new InvalidSitemapException();
        }
    }
}
