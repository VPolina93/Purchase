import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
    private final List<Purchase> purchases = new ArrayList<Purchase>();
    private Card card = null;

    public void addPurchase(Purchase purchase) {
        if (purchases.size() == 0) {
            purchases.add(purchase);
            return;
        }

        Purchase existingPurchase = this.findPurchaseById(purchase.getProduct().getId());

        if (existingPurchase == null) {
            purchases.add(purchase);
        } else {
            int oldCount = existingPurchase.getProductCount();
            int newCount = purchase.getProductCount();
            existingPurchase.setProductCount(oldCount + newCount);
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Purchase purchase : purchases) {
            totalPrice = totalPrice + purchase.getTotalPrice();
        }
        return totalPrice;
    }

    public double getTotalPriceWithDiscount() {
        double totalPriceWithDiscount = this.getTotalPrice();
        if (card != null) {
            totalPriceWithDiscount = (totalPriceWithDiscount * (100 - card.getCardDiscount())) / 100;
        }
        return totalPriceWithDiscount;
    }

    private Purchase findPurchaseById(long id) {
        for (Purchase purchaseItem : purchases) {
            if (purchaseItem.getProduct().getId() == id) {
                return purchaseItem;
            }
        }
        return null;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }
}
