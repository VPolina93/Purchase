import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckPrinter {

    public static void print(ShoppingBasket basket) {
        printTop();
        printBody(basket);
        printBottom(basket);
    }

    private static void printTop() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        System.out.printf("%29s%n", "CASH RECEIPT");
        System.out.printf("%30s%n", "Supermarket 123");
        System.out.printf("%34s%n", "15, MILKYWAY Galaxy/Earth");
        System.out.println("Tel : 123-456-7890");
        System.out.println("CASHIER: #1520" + String.format("%30s", "DATE: " + df.format(now)));
        System.out.printf("%42s%n", "TIME: " + tf.format(now));
        System.out.println("--------------------------------------------");
        System.out.println(String.format("%-5s", "QTY") + String.format("%-17s", "DESCRIPTION") + String.format("%-7s", "PRICE") + String.format("%13s", "TOTAL"));
    }

    private static void printBody(ShoppingBasket basket) {
        String discountApply;
        for (Purchase purchase : basket.getPurchases()) {
            discountApply = (purchase.getBonus() == 0) ? "" : "(-" + String.format("%.0f", purchase.getBonus()) + "%)";

            String check = String.format("%-5s", purchase.getProductCount()) +
                    String.format("%-17s", purchase.getProductName()) +
                    String.format("%-7s", "$" + String.format("%.2f", purchase.getProduct().getPrice())) +
                    String.format("%-6s", discountApply) +
                    String.format("%8s", "$" + String.format("%.2f", purchase.getTotalPrice()));
            System.out.println(check);
        }
    }

    private static void printBottom(ShoppingBasket basket) {
        System.out.println("____________________________________________");
        System.out.println("--------------------------------------------");
        System.out.println("TAXABLE TOT." + String.format("%31s", "$" + String.format("%.2f", basket.getTotalPrice())));
        if (basket.getCard() != null) {
            System.out.println("VAT. " + basket.getCard().getCardDiscount() +
                    "%" + String.format("%35s", "$" + String.format("%.2f", basket.getTotalPrice() - basket.getTotalPriceWithDiscount())));
        }
        System.out.println("TOTAL" + String.format("%38s", "$" + String.format("%.2f", basket.getTotalPriceWithDiscount())));
    }
}
