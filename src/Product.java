
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
        setProductQuantity(productQuantity); // limitation on max quantity- 15 articles
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

    public void setProductQuantity(int productQuantity) {
        if ( productQuantity > 15) {
            System.err.println("Max quantity exceeded. Capacity is only 15 articles!");
        } else if (productQuantity < 0) {
            System.err.println("Max quantity exceeded. Capacity is only 15 articles!");
        } else {
            this.productQuantity = productQuantity;
        }

    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }



    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productQuantity=" + productQuantity +
                ", productPrice=" + productPrice +
                ", productCategory=" + productCategory +
                '}';
    }
}
