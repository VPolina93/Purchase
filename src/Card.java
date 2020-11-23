public class Card {
    private final int cardId;
    private final int cardDiscount;

    public Card(int cardId, int cardDiscount) {
        this.cardId = cardId;
        this.cardDiscount = cardDiscount;
    }

    public int getCardId() {
        return cardId;
    }

    public int getCardDiscount() {
        return cardDiscount;
    }
}

