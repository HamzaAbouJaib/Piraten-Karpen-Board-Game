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

    public boolean skullCountChecker(Faces[] dice){
        int num_of_skulls = 0;
        // Calculate the number of skulls in a given roll
        for (Faces die: dice) {
            if(die == Faces.SKULL){
                num_of_skulls++;
            }
        }
        // return if the number of dice is >= 3 meaning the players turn ended.
        return num_of_skulls >= 3;
    }

}
