import pk.Simulation;

import java.util.Objects;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        // run the simulation
        Simulation.runSimulation(args.length > 0 && Objects.equals(args[0], "trace"));
        System.out.println("That's all folks!");
    }
    
}
