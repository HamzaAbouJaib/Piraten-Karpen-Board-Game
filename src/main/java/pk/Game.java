package pk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Game {

    private static final Logger logger = LogManager.getLogger(Game.class);

    public void gameRound(Player p1, Player p2){
        // Keep playing turns until a player's score exceeds 6000
        while(true) {
            if(p2.score >= 6000) break;
            turn(p1);
            if(p1.score >= 6000) break;
            turn(p2);
        }
        logger.trace("game done");

    }

    public void turn(Player p) {
        // At the start of a turn roll 8 dice
        Faces[] dice= p.rollEightDice();
        // print the faces rolled
        logger.trace(formatDiceRoll(dice));
        if (skullCountChecker(dice)){
            logger.trace("Player " + p.playerID + " has rolled 3 or more skulls, their turn is over.");
        } else {
            // roll the dice using the players strategy
            dice = strategy(dice, p);
            // Only add the score earned in the roll if the number of skulls <= 3
            if (!skullCountChecker(dice)) p.updateScore(dice, getCombos(dice));
            logger.trace("Player " + p.playerID + " ended their turn with a score of " + p.score);
        }
    }

    public Faces[] strategy(Faces[] dice, Player p) {
        // simulates a player deciding to re-roll or keep their roll by basically a coin flip
        while(true) {
            boolean reroll = Math.random() > 0.5;
            if(reroll) {
                // Re-roll non skull dice and print the result of the re-roll
                dice = p.rerollDice(dice);
                logger.trace("Player " + p.playerID + "'s new roll: ");
                logger.trace(formatDiceRoll(dice));
                // check if the number of skulls surpassed or equals 3 after the re-roll
                if (skullCountChecker(dice)) {
                    logger.trace("Player " + p.playerID + " has rolled 3 or more skulls, their turn is over.");
                    break;
                }
            } else {
                // simulates the player deciding to keep his roll
                break;
            }
        }
        return dice;
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

    public int[] getCombos(Faces[] dice){
        //the indices represent the Face's index in the Faces enum.
        int[] combos = {0 ,0 ,0 ,0 ,0};
        for (Faces die: dice) {
            switch (die){
                case MONKEY -> combos[0]++;
                case PARROT -> combos[1]++;
                case GOLD -> combos[2]++;
                case DIAMOND -> combos[3]++;
                case SABER -> combos[4]++;
            }
        }
        return combos;
    }


    public String formatDiceRoll(Faces[] dice) {
        String formated = "";
        for (Faces die:dice) {
            formated += die + ", ";
        }
        return formated;
    }

}
