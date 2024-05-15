package com.ac.simulator;

import com.ac.simulator.exceptions.ApplicationException;
import com.ac.simulator.exceptions.InvalidArgumentException;
import com.ac.simulator.utility.CommandLineUtility;

/**
 * Application class
 */
public class SimulatorApplication {

    public static void main(String[] args) {
        SimulatorEngine engine = new SimulatorEngine(new CommandLineUtility());
        try {
            if (args.length != 1) {
                throw new InvalidArgumentException();
            }
            engine.start(args[0]);
        } catch (ApplicationException e) {
            System.out.println(e.getErrorName() + " " + e.getErrorDescription());
        }
    }
}
