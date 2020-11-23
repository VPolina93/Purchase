public class Purchase {
    private final ProductType product;
    private int productCount;

    public Purchase(ProductType product, int productCount) {
        this.product = product;
        this.productCount = productCount;
    }

    public ProductType getProduct() {
        return product;
    }

    public int getProductCount() {
        return productCount;
    }

    public double getBonus() {
        return productCount > 5 && product.hasDiscount() ? 10 : 0;
    }

    private double getBonusRate() {
        return (100 - this.getBonus()) / 100;
    }

    public double getProductPrice() {
        return product.getPrice() * this.getBonusRate();
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public double getTotalPrice() {
        return getProductPrice() * productCount;
    }

    public String getProductName() {
        return product.getName();
    }
}
