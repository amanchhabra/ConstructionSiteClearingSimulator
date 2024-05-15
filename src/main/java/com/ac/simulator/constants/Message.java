package com.ac.simulator.constants;

/**
 * Message to display on console
 */
public enum Message {
    WELCOME_MESSAGE("\nWelcome to the Aconex site clearing simulator. This is a map of the site:\n\n"),
    COMMAND_INFO_MESSAGE("\nThe bulldozer is currently located at the Northern edge of the site, immediately to the West of the site, and facing East.\n\n"),
    COMMAND_LINE_MESSAGE("(l)eft, (r)ight, (a)dvance <n>, (q)uit: "),
    STOP_MESSAGE("\nThe simulation has ended at your request. These are the commands you issued:\n\n"),
    COST_MESSAGE("\n\nThe costs for this land clearing operation were:\n\n"),
    THANK_YOU_MESSAGE("\n\nThankyou for using the Aconex site clearing simulator."),
    COST_DETAILS_HEADING("Item                            Quantity    Cost\n"),
    COST_DETAILS_COMMUNICATION_OVERHEAD_TEMPLATE("communication overhead          %8d    %4d\n"),
    COST_DETAILS_FUEL_USAGE_TEMPLATE("fuel usage                      %8d    %4d\n"),
    COST_DETAILS_UNCLEARED_SQUARES_TEMPLATE("uncleared squares               %8d    %4d\n"),
    COST_DETAILS_DESTRUCTION_PROTECTED_AREA_TEMPLATE("destruction of protected tree   %8d    %4d\n"),
    COST_DETAILS_PAINT_DAMAGE_TEMPLATE("paint damage to bulldozer       %8d    %4d\n"),
    COST_DETAILS_SEPERATOR("----\n"),
    COST_DETAILS_TOTAL_TEMPLATE("Total                           %16d\n");
    private final String description;

    Message(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
