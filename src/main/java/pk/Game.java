package pk;

public class Game {
    public void turn(Player p) {
        // At the start of a turn roll 8 dice
        Faces[] dice= p.rollEightDice();
        // print the faces rolled
        for (Faces die: dice) System.out.print(die + ", ");
        System.out.println();
        if (skullCountChecker(dice)){
            System.out.println("Player " + p.playerID + " has rolled 3 or more skulls, their turn is over.");
        } else {
            // Do something
        }
    }
}
