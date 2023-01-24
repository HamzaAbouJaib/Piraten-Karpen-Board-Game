package pk;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;


public class Simulation {

    private static final Logger logger = LogManager.getLogger(Simulation.class);

    public static void runSimulation(String strat1, String strat2, Boolean trace) {
        if(!trace) {
            Configurator.setRootLevel(Level.OFF);
        }
        Player p1 = new Player(1);
        p1.strat = strat1;
        Player p2 = new Player(2);
        p2.strat = strat2;
        Game game = new Game();
        // Keep track of each player's wins
        // index 0 is for player 1 and index 1 is for player 2
        int[] playerwins = {0, 0};
        for (int i = 1; i < 43; i++) {
            p1.score = 0;
            p2.score = 0;
            logger.trace("Round " + i + ":");
            game.playGame(p1, p2);
            if (p1.score > p2.score) {
                logger.trace("Player 1 won!");
                playerwins[0]++;
            }
            if (p2.score > p1.score) {
                logger.trace("Player 2 won!");
                playerwins[1]++;
            }
        }
        String p1WinPercentage = "Player 1's win percentage is: " + Math.round((playerwins[0] / 42.0) * 100) + "%";
        String p2WinPercentage = "Player 2's win percentage is: " + Math.round((playerwins[1] / 42.0) * 100) + "%";
        logger.trace(p1WinPercentage);
        logger.trace(p2WinPercentage);
        logger.trace(playerwins[0] + "    " + playerwins[1]);
        System.out.println(p1WinPercentage);
        System.out.println(p2WinPercentage);;
    }
}
