package pk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Simulation {

    private static final Logger logger = LogManager.getLogger(Simulation.class);

    public static void runSimulation() {
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Game game = new Game();
        // Keep track of each player's wins
        // index 0 is for player 1 and index 1 is for player 2
        int[] playerwins = {0, 0};
        for (int i = 1; i < 43; i++) {
            p1.score = 0;
            p2.score = 0;
            System.out.println("Round " + i + ":");
            game.gameRound(p1, p2);
            if (p1.score > p2.score) {
                System.out.println("Player 1 won!");
                playerwins[0]++;
            }
            if (p2.score > p1.score) {
                System.out.println("Player 2 won!");
                playerwins[1]++;
            }
        }
        System.out.println("42 games have been played.");
        System.out.println("Player 1's win percentage is: " + Math.round((playerwins[0] / 42.0) * 100) + "%");
        System.out.println("Player 2's win percentage is: " + Math.round((playerwins[1] / 42.0) * 100) + "%");
    }
}
