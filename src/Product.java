import java.util.Objects;

public class Product {
    private static int counter = 0;
    private int productId;
    private String productName;
    private String productDescription;
    private int productQuantity;
    private double productPrice;
    private Category productCategory;

    public Product(String productName, String productDescription,
                   int productQuantity, double productPrice, Category productCategory) {
        this.productId = ++counter;
        this.productName = productName;
        this.productDescription = productDescription;
        try {
            setProductQuantity(productQuantity); // limitation on max quantity- 15 articles

        } catch (Exception e) {
            System.out.println("An error occurred while creating new Product object!");
            e.printStackTrace();
        }

        this.productPrice = productPrice;
        this.productCategory = productCategory;

    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductQuantity(int productQuantity) throws Exception{
        if ( productQuantity <= 15) {
            this.productQuantity = productQuantity;
        } else {
            throw new StockLimitReachedException("Stock is full!");

        }

    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public boolean equals(Object o) { // equals() compares just ID since it is unique.
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + productId +
                ", Name='" + productName + "\'\n" +
                ", Description='" + productDescription + "\'\n" +
                ", Quantity=" + productQuantity +
                ", Price=" + productPrice +
                ", Category=" + productCategory +
                '}';
    }
}
