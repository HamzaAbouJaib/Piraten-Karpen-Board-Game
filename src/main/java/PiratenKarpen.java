import pk.Simulation;

import java.util.Objects;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        // run the simulation based on the arguments entered by the user.
        if(args.length >= 2 && args.length <= 3) Simulation.runSimulation(args[0], args[1], args.length == 3 && Objects.equals(args[2], "trace"));
        else System.out.println("Invalid number of command line arguments");
        System.out.println("That's all folks!");
    }
    
}
