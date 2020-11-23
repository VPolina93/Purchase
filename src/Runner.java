import java.util.HashMap;
import java.util.Map;

public class Runner {
    private final static Map<Integer, Card> cardMap = new HashMap<Integer, Card>();

    static {
        Card card1 = new Card(1234, 5);
        Card card2 = new Card(1567, 3);
        Card card3 = new Card(1890, 7);
        cardMap.put(card1.getCardId(), card1);
        cardMap.put(card2.getCardId(), card2);
        cardMap.put(card3.getCardId(), card3);
    }

    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            return;
        }

        ShoppingBasket basket = new ShoppingBasket();

        for (String arg : args) {
            String[] argumentsArray = arg.split("-");
            String argKey = argumentsArray[0];
            String argValue = argumentsArray[1];

            if (!argKey.equals("card")) {
                long productId = Long.parseLong(argKey);
                int productCount = Integer.parseInt(argValue);
                ProductType product = ProductType.getProductById(productId);

                if (product != null) {
                    Purchase purchase = new Purchase(product, productCount);
                    basket.addPurchase(purchase);
                }
            } else {
                int cardId = Integer.parseInt(argValue);
                basket.setCard(cardMap.get(cardId));
            }
        }

        CheckPrinter.print(basket);
    }
}
