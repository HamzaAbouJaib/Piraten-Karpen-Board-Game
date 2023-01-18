package pk;

public class Player {
    int playerID;
    public int score;

    public Player(int ID){
        this.playerID = ID;
        this.score = 0;
    }

    public Faces[] rollEightDice() {
        int numOfDice = 8;
        Faces[] dice = new Faces[numOfDice];
        for (int i = 0; i < numOfDice; i++) {
            Dice die = new Dice();
            dice[i] = die.roll();
        }
        return dice;
    }
}
