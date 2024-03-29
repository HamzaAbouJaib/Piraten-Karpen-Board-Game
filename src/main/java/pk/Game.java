package pk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Objects;

public class Game {

    private static final Logger logger = LogManager.getLogger(Game.class);
    // create an instance of the CardDeck
    private CardDeck deck;

    public void playGame(Player p1, Player p2){
        deck = new CardDeck();
        while(true) {
            if(p2.score >= 6000) {
                turn(p1);
                if (p2.score == p1.score) {
                    draw(p1, p2);
                }
                break;
            }
            turn(p1);
            if(p1.score >= 6000) {
                turn(p2);
                if (p2.score == p1.score) {
                    draw(p1, p2);
                }
                break;
            }
            turn(p2);
        }
        logger.trace("Game over!");
    }

    private void draw(Player p1, Player p2){
        logger.trace("TIE");
        do {
            turn(p1);
            turn(p2);
        } while (p1.score == p2.score);
    }

    private void turn(Player p) {
        logger.trace("Player " + p.playerID +"'s turn");
        // pick a card from the deck
        Cards selectedCard = deck.pickCard();
        logger.trace("player " + p.playerID + " picked " + selectedCard);

        switch (selectedCard){
            case SEABATTLE2 -> Strategies.seaBattleStrategy(p, 2);
            case SEABATTLE3 -> Strategies.seaBattleStrategy(p, 3);
            case SEABATTLE4 -> Strategies.seaBattleStrategy(p, 4);
            default -> {
                // At the start of a turn roll 8 dice
                Faces[] dice = p.rollEightDice();
                // print the faces rolled
                logger.trace(formatDiceRoll(dice));
                if (skullCounter(dice) >= 3) {
                    logger.trace("Player " + p.playerID + " has rolled 3 or more skulls, their turn is over.");
                } else {
                    // roll the dice using the players strategy
                    dice = Objects.equals(p.strat, "random") ? Strategies.randomStrategy(dice, p) : Strategies.comboStrategy(dice, p, selectedCard);
                    int[] combos = getCombos(dice);
                    // if MonkeyBusiness card is picked then join parrots and monkeys
                    if (selectedCard == Cards.MONKEYBUSINESS) {
                        combos[0] += combos[1];
                        combos[1] = 0;
                    }
                    logger.trace(Arrays.toString(combos));
                    // Only add the score earned in the roll if the number of skulls <= 3
                    if (skullCounter(dice) < 3) p.updateScore(dice, combos);
                    else logger.trace("Player " + p.playerID + " has rolled 3 or more skulls, their turn is over.");
                }
            }
        }
        logger.trace("Player " + p.playerID + " ended their turn with a score of " + p.score);
    }

    public static int skullCounter(Faces[] dice){
        int num_of_skulls = 0;
        // Calculate the number of skulls in a given roll
        for (Faces die: dice) {
            if(die == Faces.SKULL){
                num_of_skulls++;
            }
        }
        // return if the number of dice is >= 3 meaning the players turn ended.
        return num_of_skulls;
    }

    public static int[] getCombos(Faces[] dice){
        //the indices represent the Face's index in the Faces enum.
        //Ex: combos[0] represents number of monkey faces because MONKEY is the first entry in Faces enum
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


    public static String formatDiceRoll(Faces[] dice) {
        String formated = "";
        for (Faces die:dice) {
            formated += die + ", ";
        }
        return formated;
    }

}
