package pk;

import java.util.Arrays;

public class Player {
    int playerID;
    public int score;
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
        // randomly gets the number of dice that will be re-rolled
        int iterations =(int)(Math.random() * availableDice) + 1;
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
}
