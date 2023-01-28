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

    public static Faces[] comboStrategy(Faces[] dice, Player p, Cards selectedCard) {
        while(true) {
            int numOfSkulls = Game.skullCounter(dice);
            if(numOfSkulls < 2) {
                int[] combos = Game.getCombos(dice);
                int largestComboIndex = 0;
                for (int i = 1; i < combos.length; i++) {
                    if (combos[largestComboIndex] < combos[i]) largestComboIndex = i;
                }
                // the AI will prioritize re-rolling diamonds and golds if they are the max combo as they will provide more points
                if (selectedCard == Cards.MONKEYBUSINESS && largestComboIndex != 2 && largestComboIndex != 3){
                    if (numOfSkulls == 1 && combos[0] + combos[1] < 6 || numOfSkulls == 0 && combos[0] + combos[1] < 7) {
                        for (int i = 0; i < dice.length; i++) {
                            if (dice[i] != Faces.MONKEY && dice[i] != Faces.PARROT && dice[i] != Faces.SKULL) {
                                dice[i] = new Dice().roll();
                            }
                        }
                    } else {
                        break;
                    }
                } else {
                    if (numOfSkulls == 1 && combos[largestComboIndex] < 6 || numOfSkulls == 0 && combos[largestComboIndex] < 7) {
                        for (int i = 0; i < dice.length; i++) {
                            if (dice[i] != Faces.values()[largestComboIndex] && dice[i] != Faces.SKULL) {
                                dice[i] = new Dice().roll();
                            }
                        }
                    } else {
                        break;
                    }
                }

            } else {
                break;
            }
            logger.trace(p.playerID +"'s  re-roll " + Game.formatDiceRoll(dice));
        }
        logger.trace(p.playerID +"'s Final re-roll " + Game.formatDiceRoll(dice));
        return dice;
    }
    public static void seaBattleStrategy(Player p, int saberTarget) {
        Faces[] dice = p.rollEightDice();
        logger.trace("player " + p.playerID +" initial roll " + Game.formatDiceRoll(dice));
        int saberCount = Game.getCombos(dice)[4];
        // keep looping until the sabers rolled are equal to or greater than the target on the card
        while (saberCount < saberTarget) {
            for (int i = 0; i < dice.length; i++){
                if(dice[i] != Faces.SABER && dice[i] != Faces.SKULL){
                    dice[i] = new Dice().roll();
                }
            }
            logger.trace("player" + p.playerID + " new roll: " + Game.formatDiceRoll(dice));
            // end the turn when 3 or more skulls are rolled
            if(Game.skullCounter(dice) >=3) break;
            // get the new saber count
            saberCount = Game.getCombos(dice)[4];
        }
        // if the turn ended with 3 or more skulls, then the player loses the specified points
        if (Game.skullCounter(dice) >=3){
            switch (saberTarget){
                case 2 -> p.score -= 300;
                case 3 -> p.score -= 500;
                case 4 -> p.score -= 1000;
            }
            logger.trace("score after sea battle defeat " + p.score);
            return;
        }
        // score update after winning sea battle
        switch (saberTarget){
            case 2 -> p.score += 300;
            case 3 -> p.score += 500;
            case 4 -> p.score += 1000;
        }
        logger.trace("score before updateScore " + p.score);
        // update the score with the combos and diamonds/golds gained
        p.updateScore(dice, Game.getCombos(dice));
        logger.trace("score after updateScore " + p.score);
    }
}
