import java.util.HashMap;
import java.util.Map;

public enum ProductType {
    Milk(1, "Milk", 2.19, false),
    IceCream(2, "Ice Cream", 2.95, true),
    Cheese(3, "Cheese", 4.20, true),
    Sausage(4, "Sausage", 29.30, true),
    Meat(5, "Meat", 7.35, false),
    Eggs(6, "Eggs", 2.99, false),
    Chicken(7, "Chicken", 6.20, true),
    Fish(8, "Fish", 14.39, true),
    Juice(9, "Juice", 3.25, false),
    Carrot(10, "Carrot", 1.07, false),
    Apple(11, "Apple", 1.78, false),
    Banana(12, "Banana", 2.99, false),
    Potato(13, "Potato", 8.50, true),
    Lemon(14, "Lemon", 6.50, true),
    Water(15, "Water", 0.73, true),
    Orange(16, "Orange", 3.30, false),
    SourCream(17, "Sour cream", 2.75, true),
    SparklingWater(18, "Sparkling water", 1.80, false),
    Butter(19, "Butter", 3.49, false),
    Chips(20, "Chips", 3.15, true),
    Cucumber(21, "Cucumber", 1.50, false),
    Tomato(22, "Tomato", 4.50, true),
    Bread(23, "Bread", 0.90, false),
    Chocolate(24, "Chocolate", 3.40, true),
    Coffee(25, "Coffee", 11.49, true),
    Tea(26, "Tea", 5.59, true),
    Beer(27, "Beer", 2.79, false),
    Wine(28, "Wine", 22.99, false),
    Cigarette(29, "Cigarette", 5.79, false);

    ProductType(long id, String name, double price, boolean discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    private final long id;
    private final String name;
    private final double price;
    private final boolean discount;
    private final static Map<Long, ProductType> productsMap = new HashMap<Long, ProductType>();

    static {
        ProductType[] productTypes = ProductType.values();

        for (ProductType product : productTypes) {
            productsMap.put(product.getId(), product);
        }
    }

    public static ProductType getProductById(Long id) {
        return productsMap.get(id);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean hasDiscount() {
        return discount;
    }
}

