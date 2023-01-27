package pk;

public class CardDeck {
    private final Cards[] cards = new Cards[35];

    // when a CardDeck is instantiated generate the deck.
    public CardDeck(){
        generateDeck();
    }

    private void generateDeck(){
        int seaBattle2Cards = 2;
        int seaBattle3Cards = 2;
        int seaBattle4Cards = 2;
        // create a deck filled with empty cards
        for(int i = 0; i < 35; i++) {
            cards[i] = Cards.NOP;
        }

        // the next 3 while loops place the cards in a random empty location in the deck
        while(seaBattle2Cards > 0) {
            int randomIndex = (int) (Math.random() * 35);
            cards[randomIndex] = Cards.SEABATTLE2;
            seaBattle2Cards--;
        }
        while(seaBattle3Cards > 0) {
            int randomIndex = (int) (Math.random() * 35);
            if (cards[randomIndex] != Cards.SEABATTLE2) {
                cards[randomIndex] = Cards.SEABATTLE3;
                seaBattle3Cards--;
            }
        }
        while(seaBattle4Cards > 0) {
            int randomIndex = (int) (Math.random() * 35);
            if (cards[randomIndex] != Cards.SEABATTLE2 && cards[randomIndex] != Cards.SEABATTLE3) {
                cards[randomIndex] = Cards.SEABATTLE4;
                seaBattle4Cards--;
            }
        }
    }
}
