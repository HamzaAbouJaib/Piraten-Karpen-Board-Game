package pk;

public class Simulation {
    public static void runSimulation() {
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Game game = new Game();
        for (int i = 1; i < 43; i++) {
            p1.score = 0;
            p2.score = 0;
            System.out.println("Round " + i + ":");
            game.gameRound(p1, p2);
            if (p1.score > p2.score) {
                System.out.println("Player 1 won!");
            }
            if (p2.score > p1.score) {
                System.out.println("Player 2 won!");
            }
        }
    }
}
