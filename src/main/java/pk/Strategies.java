package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Strategies {

    private static final Logger logger = LogManager.getLogger(Strategies.class);

    public static Faces[] randomStrategy(Faces[] dice, Player p) {
        // simulates a player deciding to re-roll or keep their roll by basically a coin flip
        while(true) {
            boolean reroll = Math.random() > 0.5;
            if(reroll) {
                // Re-roll non skull dice and print the result of the re-roll
                dice = p.rerollDice(dice);
                logger.trace("Player " + p.playerID + "'s new roll: ");
                logger.trace(Game.formatDiceRoll(dice));
                // check if the number of skulls surpassed or equals 3 after the re-roll
                if (Game.skullCounter(dice) >= 3) {
                    break;
                }
            } else {
                // simulates the player deciding to keep his roll
                break;
            }
        }
        return dice;
    }
}
