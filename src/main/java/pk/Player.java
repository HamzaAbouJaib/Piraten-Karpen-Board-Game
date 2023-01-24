package pk;

import java.util.Arrays;

public class Player {
    int playerID;
    public int score;
    String strat;
    Dice die = new Dice();

    public Player(int ID){
        this.playerID = ID;
        this.score = 0;
    }

    public Faces[] rollEightDice() {
        int numOfDice = 8;
        Faces[] dice = new Faces[numOfDice];
        for (int i = 0; i < numOfDice; i++) {
            dice[i] = die.roll();
        }
        return dice;
    }

    public Faces[] rerollDice(Faces[] dice) {
        int availableDice = 8;
        // calculates the number of dice that are not skulls
        for(Faces d: dice){
            if(d == Faces.SKULL){
                availableDice--;
            }
        }
        // stores the indices of the dice that have been rolled
        int[] usedIndices =new int[availableDice];
        // randomly gets the number of dice that will be re-rolled. At least two dice are rerolled.
        int iterations = (int)Math.floor(Math.random() * (availableDice - 1) + 2);
        int counter = 0;
        while(iterations > 0) {
            // selects a random die
            int index =(int) (Math.random()*8);
            Faces face = dice[index];
            // if the die selected is not a skull and has not been rolled then roll it.
            if (face != Faces.SKULL && Arrays.binarySearch(usedIndices, index) < 0){
                dice[index] = die.roll();
                usedIndices[counter++] =index;
                iterations--;
            }
        }
        return dice;
    }

    public void updateScore(Faces[] dice, int[] combos) {
        int score = 0;
        for (Faces die: dice
        ) {
            if(die == Faces.DIAMOND || die == Faces.GOLD) {
                score += 100;
            }
        }
        for (int combo:combos) {
            switch (combo){
                case 3 -> score+= 100;
                case 4 -> score += 200;
                case 5 -> score += 500;
                case 6 -> score += 1000;
                case 7 -> score += 2000;
                case 8 -> score += 4000;
            }

        }
        this.score += score;
    }
}
