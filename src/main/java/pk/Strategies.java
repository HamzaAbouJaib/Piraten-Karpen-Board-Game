package pk;

public class Strategies {
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
                if (skullCounter(dice) >= 3) {
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
}
