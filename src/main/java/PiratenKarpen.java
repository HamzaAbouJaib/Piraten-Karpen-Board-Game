import pk.Simulation;

import java.util.Objects;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        // run the simulation
        if(args.length >= 2) Simulation.runSimulation(args[0], args[1], Objects.equals(args[2], "trace"));
        System.out.println("That's all folks!");
    }
    
}
